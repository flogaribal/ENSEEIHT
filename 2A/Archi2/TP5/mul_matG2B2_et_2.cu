 
#include <stdio.h>
#include <stdlib.h>
#include <stdio.h>
#include <math.h>
 

#define TILE_SIZE 16



// CUDA Kernel
__global__ void matrixMul( float* C, float* A, float* B, int TM)
{
  __shared__ float As [TILE_SIZE][TILE_SIZE];
  __shared__ float Bs [TILE_SIZE][TILE_SIZE];

    // chaque thread calcule C[i][j]
    // Coordonnees absolues du thread : indices i j
    int j = blockIdx.x * blockDim.x+ threadIdx.x;
    int i = blockIdx.y * blockDim.y+ threadIdx.y;
    int tx = threadIdx.x;
    int ty = threadIdx.y;
 
    float value = 0;

    for(int ke=0; ke<TM; ke += TILE_SIZE) {
      // Remplissage de As et de Bs
      As[ty][tx] = A[i * TM + ke + tx];
      Bs[ty][tx] = B[(ke + ty) * TM + j];

      __syncthreads();

      // Calcul
      for (int k = 0; k < TILE_SIZE; k++) {
        value += As[ty][k] * Bs[k][tx];
      }

      __syncthreads();
    }

   C[i * TM + j] = value;
}
  
/////////////////////////////////////////////////////////
// Program main
/////////////////////////////////////////////////////////
 
int main(int argc, char** argv) {
  int i, j, TM, BLOCK_SIZE_X, BLOCK_SIZE_Y;
  unsigned int M_size;
  float *h_A, *h_B, *h_C;
  float *d_A, *d_B, *d_C;
  cudaError_t cerror;
  float  elapsedTime ;
  cudaEvent_t start , stop ;

  // Valeurs par defaut
  TM=2048;
  BLOCK_SIZE_X = TILE_SIZE;
  BLOCK_SIZE_Y = TILE_SIZE;

  // Possibilite de lire TM dans arg1, BLOCK_SIZE_X dans arg2 et BLOCK_SIZE_Y ans arg3
  if (argc>1) {
    TM=atoi(argv[1]);
  }
  // if (argc>3) {
  //   BLOCK_SIZE_X =atoi(argv[2]);
  //   BLOCK_SIZE_Y =atoi(argv[3]);
  // }
  
  // Verification de la bonne taille TM par rapport aux dimensions des blocs
  if ((TM % BLOCK_SIZE_X) !=0) {
    printf("Taille matrice non multiple de taille bloc X %d \n", BLOCK_SIZE_X);
    exit(1);
  }
  if ((TM % BLOCK_SIZE_Y) !=0) {
    printf("Taille matrice non multiple de taille bloc Y %d \n", BLOCK_SIZE_Y);
    exit(1);
  }
  
  // Allocation memoire sur CPU
  M_size = TM*TM*sizeof(float);
  h_A = (float*) malloc(M_size);
  h_B = (float*) malloc(M_size);
  h_C = (float*) malloc(M_size);
  
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
  
  // Allocation memoire sur GPU
  cudaMalloc((void**) &d_A, M_size);
  cudaMalloc((void**) &d_B, M_size);
  cudaMalloc((void**) &d_C, M_size);
  
  // Calcul du temps : top depart
  cudaEventCreate (&start ) ;
  cudaEventCreate (&stop ) ;
  cudaEventRecord ( start , 0 ) ;
  
  // copie des donnes CPU vers GPU
  cudaMemcpy(d_A, h_A, M_size, cudaMemcpyHostToDevice);
  cudaMemcpy(d_B, h_B, M_size, cudaMemcpyHostToDevice);
  
  // choix de la structure : grille et blocs
  dim3 threads(BLOCK_SIZE_X, BLOCK_SIZE_Y);
  dim3 grid(TM / threads.x, TM / threads.y);
 
   printf("bloc %d %d \n", BLOCK_SIZE_X, BLOCK_SIZE_Y);
   printf("grille %d %d \n", TM / threads.x, TM / threads.y);
   
   // Lancement des threads
   matrixMul<<< grid, threads >>>(d_C, d_A, d_B, TM);

   // En cas d'erreur
   cerror=cudaGetLastError(); 
   if ((int)cerror !=0) { 
     printf("Erreur appel kernel %d \n", (int) cerror);
     exit(cerror);
   }
 
   // copie des resultats depuis le GPU
   cudaMemcpy(h_C, d_C, M_size, cudaMemcpyDeviceToHost);
   
   // Calcul du temps d'execution
   cudaEventRecord ( stop , 0 ) ;
   cudaEventSynchronize ( stop ) ;
   cudaEventElapsedTime ( &elapsedTime , start , stop ) ;
   cudaEventDestroy ( start ) ;
   cudaEventDestroy ( stop ) ;
   printf ( "Temps consomme: %f secondes\n" , elapsedTime / 1000.0 ) ;

  // Verification des resultats

   for(i = 0; i < TM; i++){
     for(j = 0; j < TM; j++){
      	if ((i==j) && (h_C[i*TM+j] != (float)((i+1)*(i+1)+TM-1))) {
      		printf("Erreur i: %d j: %d %f\n", i, j, h_C[i*TM+j] ); exit(1);
      	}
      	else if ((i!=j) && (h_C[i*TM+j] != (float)(i+j+TM))){
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
