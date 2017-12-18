//v0.1 8/10/16 (PM)

import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.concurrent.ExecutionException;

import java.util.List;
import java.util.LinkedList;

import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

class MaxLocal  implements Callable<Integer> {
    private int début;
    private int fin;
    private int[] tableau;

    MaxLocal(int[] t, int d, int f) {
        début = d;
        fin = f;
        tableau = t;
    }

    @Override
    public	Integer call() { // le résultat doit être un objet
        int ml = 0;
        
        for (int i=début; i< fin; i++) {
        	if (ml < tableau[i]) {
        		ml = tableau[i];
        	}
        }
        
        return new Integer(ml);
    }
}

class TraiterFragment extends RecursiveTask<Integer> {
    private int début;
    private int fin;
    private int[] tableau;
    static int seuil;

    private int max = 0;

    TraiterFragment(int[] t, int d, int f) {
        début = d;
        fin = f;
        tableau = t;
    }

    protected Integer compute() {
    	
        int taille = fin-début;
        
        if (taille > seuil) {
        	taille = taille /2;
        	// Si tableau trop grand on divise en 2tableau
        	
        	TraiterFragment t1 = new TraiterFragment(tableau, début, début + taille -1);
        	TraiterFragment t2 = new TraiterFragment(tableau, début +taille, fin);
        	
        	t1.fork();
        	max = t2.compute();
        	Math.max(t1.join(), max);
        	
        } else { 
        	
        	if (taille > 0) {
        		max = tableau[début];
	        	
	        	// Si le tableau est assez petit
	        	for (int i=début; i<fin; i++){
	            	Math.max(tableau[i], max);
	        	}
        	} else {
        		return null;
        	}
        }
        
        return new Integer(max);
    }
}

public class MaxTab {

    static int maxMono(int[] t) {
        int max = 0;
        for (int i = 0; i <t.length; i++) {
            max = Math.max(t[i], max);
        }
        return max;
    }

    static int maxPoolFixe(ExecutorService xs, int[] t, int nbT)
    throws InterruptedException, ExecutionException {
        int max = 0;
        int d = 0;									//indice de départ d'une recherche locale
        int f = 0;  							//indice de fin d'une recherche locale
        int grain = Math.max(1,t.length/nbT); 	/*taille d'une recherche locale 
        										 * = taille du tableau/nombre de tâches lancées
        										 * (ou 1 dans le cas (aberrant) où il y a plus
        										 * de tâches que d'éléments du tableau) */
        List<Future<Integer>> résultats=new LinkedList<Future<Integer>>();

        
        // Divise le tableau en sous taches
        for (int i=0; i<nbT; i++){
        	d = f;
        	f =  (t.length < f) ? t.length :  f+grain; 
        	
        	résultats.add(xs.submit(new MaxLocal(t, d, f)));
        }
        
        // Récupère les résultats
        for (Future<Integer> res : résultats) {
        	max = Math.max(res.get(), max);
        }

        return max;
    }

    static int maxForkJoin(ForkJoinPool f, int[] t) {
        TraiterFragment tout = new TraiterFragment(t,0, t.length);
        int max = f.invoke(tout);
        
        return max;
    }

    public static void main(String[] args)
    throws InterruptedException, ExecutionException, IOException, FileNotFoundException {

        
    	 
        int nbOuvriersPool=0; // nb ouvriers du pool fixe. Bonne valeur : nb de processeurs disponibles
        int nbEssais=-1;
        int nbTâches=-1;
        int tailleTronçon=-1; //nombre d'éléments du tableau traités par chaque ouvrier
        String chemin="";
        int[] tableau;
        long départ, fin;
        int max;

        long[] tempsMono, tempsPool,tempsForkJoin;

        if (args.length == 5) { //analyse des paramètres
            chemin = args[0];
            try {
                nbEssais = Integer.parseInt (args[1]);
                nbTâches = Integer.parseInt (args[2]);
                tailleTronçon = Integer.parseInt (args[3]);
                nbOuvriersPool = Integer.parseInt (args[4]);
            }
            catch (NumberFormatException nfx) {
                throw new IllegalArgumentException("Usage : MaxTab <fichier> <nb essais> "+
                                              	"<nb tâches (pool)> <taille tronçon (FJ)>"
                                                + " <nb ouvriers du pool (pool)>");            }
        }
        if ((nbEssais<1) || (nbTâches<1) || (tailleTronçon<1) || (nbOuvriersPool<1)
                || !Files.isRegularFile(Paths.get(chemin), LinkOption.NOFOLLOW_LINKS))
            throw new IllegalArgumentException("Usage : MaxTab <fichier> <nb essais> " +
                                            	"<nb tâches (pool)> <taille tronçon (FJ)>"
                                                + " <nb ouvriers du pool (pool)>");
        //appel correct
        tempsMono = new long[nbEssais];
        tempsPool = new long[nbEssais];
        tempsForkJoin = new long[nbEssais];
        tableau=TableauxDisque.charger(chemin);
        System.out.println(Runtime.getRuntime().availableProcessors()+" processeurs disponibles pour la JVM");

        //créer un pool avec un nombre fixe d'ouvriers
        ExecutorService poule = Executors.newFixedThreadPool(nbOuvriersPool);

        //créer un pool ForkJoin
        ForkJoinPool fjp = new ForkJoinPool();
        TraiterFragment.seuil=tailleTronçon;

        for (int i = 0; i < nbEssais; i++) {
            départ = System.nanoTime();
            max = maxMono(tableau);
            fin = System.nanoTime();
            tempsMono[i] = (fin - départ);
            System.out.println("Essai ["+i+"] : maximum = " + max+", durée (mono) " +
                               tempsMono[i]/1_000+ "µs");
        }
        System.out.println("--------------------");

        for (int i = 0; i < nbEssais; i++) {
            départ = System.nanoTime();
            max = maxPoolFixe(poule, tableau, nbTâches);
            fin = System.nanoTime();
            tempsPool[i] = (fin - départ);
            System.out.println("Essai ["+i+"] : maximum = " + max+", durée (pool) " +
                               tempsPool[i]/1_000+ "µs");
        }
        poule.shutdown();
        System.out.println("--------------------");

        for (int i = 0; i < nbEssais; i++) {
            départ = System.nanoTime();
            max = maxForkJoin(fjp,tableau);
            fin = System.nanoTime();
            tempsForkJoin[i] = (fin - départ);
            System.out.println("Essai ["+i+"] : maximum = " + max+", durée (FJ) " +
                               tempsForkJoin[i]/1_000+ "µs");
        }
        System.out.println("--------------------");
    }
}