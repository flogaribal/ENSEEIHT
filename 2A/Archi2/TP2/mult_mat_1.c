#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>
/////////////////////////////////////////////////////////
// Program main
/////////////////////////////////////////////////////////
int main(int argc, char** argv)
{
   register int i, j, k, TM, msec,ji,dec;
   //float cc;
   clock_t start, temps;
   float *MA, *MB, *MC;

// TM saisie comme argument du main, sinon 1000 par defaut
   TM=1000;
   if (argc > 1) {
   	TM=atoi(argv[1]);
   }

// allocation memoire pour les matrices A, B, et C
   MA = (float *) malloc(TM*TM*sizeof(float));
   MB = (float *) malloc(TM*TM*sizeof(float));
   MC = (float *) malloc(TM*TM*sizeof(float));

// initialisation des matrices avec des valeurs permettant de vérifier le resultat
   for(i = 0; i < TM; i++){
      for(j = 0; j < TM; j++){
      	MA[i*TM+j] = 1.0;
      	MB[i*TM+j] = 1.0;
      	MC[i*TM+j] = 0.0;
		if (i==j) {
			MA[i*TM+j]=(float) (i+1);
			MB[i*TM+j]=(float) (i+1);
		}
      }
   }
   start = clock();
  
   // ________multiplication C = A * B__________ 
   // LOCALITE TEMPORELLE SUR B
   dec = 16;

   for (i=0; i<TM ;i++) {
      for (j=0; j<TM ;j+=dec) { 
         for (k=0; k<TM ; k++) {
            for (ji=j; ji<j+dec;ji++) {
               MC[i * TM + ji]  += MA[i * TM + k] * MB[k * TM + ji];
            }
         }
      }
   }

   // TRANSPOSE DE B : QUELLE LOCALITE ?
   for (i = 0; i < TM; i++) {
 	for (j = 0; j < TM; j++) {
   		cc = 0.0;
   		for (k = 0; k < TM; k++)
   			{
          		cc  += MA[i * TM + k] * MB[j * TM + k];
   		}
        MC[i * TM + j] = cc;
 	}
   }


   // LOCALITE SPATIALE DE B
   for (i = 0; i < TM; i++) {
     	for (j = 0; j < TM; j++) {
       		cc = 0.0;
       		for (k = 0; k < TM; k++){
          		cc  += MA[i * TM + k] * MB[k * TM + j];
       		}
            MC[i * TM + j] = cc;
     	}
   }
   temps = clock() - start;
   msec = temps * 1000 / CLOCKS_PER_SEC;
   printf("Temps multiplication %d secondes %d millisecondes\n", msec/1000, msec%1000);

// Verification des resultats
// Si les boucles de multiplication ne sont pas exécutées correctement, les erreurs sont détectées et affichées à l'écran.
   for(i = 0; i < TM; i++){
      for(j = 0; j < TM; j++){
		if ((i==j) && (MC[i*TM+j] != (float)((i+1)*(i+1)+TM-1))) {
				printf("Erreur i: %d j: %d\n", i, j);
			}
		else if ((i!=j) && (MC[i*TM+j] != (float)(i+j+TM))) {
			printf("Erreur i: %d j: %d\n", i, j);
		}
      }
   }

   // liberation de l'espace memoire
   free(MA);
   free(MB);
   free(MC);
   return(0);
}

Recompiler avec l’option –O3, exécuter et comparer les résultats.
En consultant le code assembleur généré par gcc –O3 –S add_vect.c, on peut remarquer
que la boucle interne est exécutée seulement 25 fois (add $16, %rax, et rebouclage si
%rax != 400), et que cette boucle utilise les instructions movaps et addps, instructions de
l’ensemble sse qui travaillent sur 16 octets à la fois (4 éléments consécutifs du vecteur).
Les options de compilation, -O1 et -O2, introduisent quelques optimisations simples sur
certaines opérations, boucles et sur l'utilisation des registres, tout en limitant la taille du
code 
L’option –O3 pousse l’optimisation plus loin, en utilisant des caractéristiques ou des
particularités du processeur.
