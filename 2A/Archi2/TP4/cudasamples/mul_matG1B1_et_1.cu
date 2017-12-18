 
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <cuda_runtime.h>
 

// CUDA Kernel
__global__ void matrixMul( float* C, float* A, float* B, int TM)
{
   float cc;
   int k;
   // calcul des coordonnees du thread
   int i =  blockIdx.x;
   int j =  threadIdx.x;
 
   cc = 0.;
   // calcul de c[i][j]
   for(k=0;k<TM;k++){
      cc += A[i*TM+k] * B[k*TM+j];
   }
   C[i*TM+j] = cc;
}
 
 
/////////////////////////////////////////////////////////
// Programme main
/////////////////////////////////////////////////////////
 
int main(int argc, char** argv)
{
	int i, j, GRID_SIZE_X, BLOCK_SIZE_X;
	int TM=1024;
   int size = TM*TM*sizeof(float);
	cudaError_t cerror;

	if (argc>1) {
		 TM=atoi(argv[1]);
	}
	BLOCK_SIZE_X = TM; 
	GRID_SIZE_X = TM;
 
   // definiton de la grille et des blocs
   dim3 block(BLOCK_SIZE_X);
   dim3 grid(GRID_SIZE_X);

   // allocation des matrices sur CPU
   float *h_A, *h_B, *h_C ;

   h_A = (float*) malloc(size);
   h_B = (float*) malloc(size);
   h_C = (float*) malloc(size);


   
   // initialisation des matrices avec des valeurs permettant de verifier le resultat
   for(i = 0; i < TM; i++){
      for(j = 0; j < TM; j++){
      	h_A[i*TM+j] = 1.0;
      	h_B[i*TM+j] = 1.0;
		h_C[i*TM+j] = 0.0;

		if (i==j) {
			h_A[i*TM+j]=(float) (i+1);
			h_B[i*TM+j]=(float) (i+1);
		}
      }
   }

   // Pour mesurer le temps de calcul
   float tc, tt_cpuGpu, tt_gpuCpu;
   cudaEvent_t depart, arret,cpuGpuDebut, cpuGpuFin, gpuCpuDebut, gpuCpuFin;
   cudaEventCreate(&depart);
   cudaEventCreate(&arret);
   cudaEventCreate(&cpuGpuDebut);
   cudaEventCreate(&cpuGpuFin);
   cudaEventCreate(&gpuCpuDebut);
   cudaEventCreate(&gpuCpuFin);
   cudaEventRecord(depart,0);
   cudaEventRecord(cpuGpuDebut,0);
   cudaEventRecord(gpuCpuDebut,0);

   // allocation des matrices sur GPU
   float *d_A, *d_B, *d_C;
   cudaMalloc((void**) &d_A,size);
   cudaMalloc((void**) &d_B,size);
   cudaMalloc((void**) &d_C,size);
 
   // copie des matrives A et B depuis le CPU vers le GPU
   cudaMemcpy(d_A, h_A, size,cudaMemcpyHostToDevice);
   cudaMemcpy(d_B, h_B, size,cudaMemcpyHostToDevice);
      // Mesure du temps : transfert + calcul
   cudaEventRecord(cpuGpuFin,0);
   cudaEventSynchronize(cpuGpuFin);
   cudaEventElapsedTime(&tt_cpuGpu,cpuGpuDebut, cpuGpuFin);

   cudaEventDestroy(cpuGpuDebut);
   cudaEventDestroy(cpuGpuFin);
   printf("Transfert A,B de CPU vers GPU : %f seconde\n", tt_cpuGpu/1000.0);

   // lancement des threads
   matrixMul<<< grid, block >>>(d_C, d_A, d_B, TM);
 
   // Vérification en cas d'erreur
   cerror=cudaGetLastError(); 
   if ((int)cerror !=0) { 
     printf("Erreur appel kernel %d \n", (int) cerror);
     exit(cerror);
   }
   // copie de la matrive C depuis le GPU
   cudaMemcpy(h_C,d_C, size,cudaMemcpyDeviceToHost);
   // Mesure du temps : transfert + calcul
   cudaEventRecord(gpuCpuFin,0);
   cudaEventSynchronize(gpuCpuFin);
   cudaEventElapsedTime(&tt_gpuCpu,gpuCpuDebut, gpuCpuFin);

   cudaEventDestroy(gpuCpuDebut);
   cudaEventDestroy(gpuCpuFin);
   printf("Transfert C de GPU vers CPU : %f seconde\n", tt_gpuCpu/1000.0);


   // Mesure du temps : transfert + calcul
   cudaEventRecord(arret,0);
   cudaEventSynchronize(arret);
   cudaEventElapsedTime(&tc,depart, arret);

   cudaEventDestroy(depart);
   cudaEventDestroy(arret);
   printf("Temps consommé : %f seconde\n", tc/1000.0);

   // verification du resultat
  for(i = 0; i < TM; i++){
    for(j = 0; j < TM; j++){
	if ((i==j) && (h_C[i*TM+j] != (float)((i+1)*(i+1)+TM-1))) 	   	{
		printf("Erreur i: %d j: %d %f\n", i, j, h_C[i*TM+j] ); exit(1);
		}
		else if ((i!=j) && (h_C[i*TM+j] != (float)(i+j+TM))) 			{
			printf("Erreur i: %d j: %d\n", i, j);
			exit(1);
		}
      }
   } 

   // liberation de la memoire
   free(h_A);
   free(h_B);
   free(h_C);
   cudaFree(d_A);
   cudaFree(d_B);
   cudaFree(d_C);
 
}
