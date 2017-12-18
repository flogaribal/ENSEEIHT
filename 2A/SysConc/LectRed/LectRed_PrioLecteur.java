// Time-stamp: <08 Apr 2008 11:35 queinnec@enseeiht.fr>

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import Synchro.Assert;

/** Lecteurs/rédacteurs
 * stratégie d'ordonnancement: priorité aux rédacteurs,
 * implantation: avec un moniteur. */
public class LectRed_PrioLecteur implements LectRed {

	private int nbLecteurs;
	private boolean redacteur;
	private Lock lock;
	private Condition vc_lect;
	private Condition vc_ecr;
	
    public LectRed_PrioLecteur(){
    	nbLecteurs = 0;
    	redacteur = false;
    	lock = new ReentrantLock();
    	vc_ecr = lock.newCondition();
    	vc_lect = lock.newCondition();
    }

    public void demanderLecture() throws InterruptedException {
    	lock.lock();
    	
    	while (redacteur) {
    		vc_lect.await();
    	}
    	
    	nbLecteurs++;
    	vc_lect.signal();
    	
    	lock.unlock();
    }

    public void terminerLecture() throws InterruptedException {
    	lock.lock();
    	
    	nbLecteurs--;
    	if (nbLecteurs == 0) {
    		vc_ecr.signal();
    	}
    	
    	lock.unlock();
    }

    public void demanderEcriture() throws InterruptedException {
    	lock.lock();
    	
    	while (nbLecteurs != 0 || redacteur) {
    		vc_ecr.await();
    	}
    	redacteur = true;
    	
    	lock.unlock();
    }

    public void terminerEcriture() throws InterruptedException {
    	lock.lock();
    	
    	redacteur = false;
    	vc_lect.signal();
    	
    	if (nbLecteurs == 0) {
    		vc_ecr.signal();
    	}     	
    	
    	lock.unlock();
    }

    public String nomStrategie()
    {
        return "Stratégie: Priorité Lecteur.";
    }
}
