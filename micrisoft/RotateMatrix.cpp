#include <iostream>
using namespace std;
void rotateMatrix(int N,int *mat){
  for(int i=0;i<N/2;i++){
    for(int j=i;j<N-i-1;j++){
      int temp=*(mat+i*N+j);
      *(mat+i*N+j)=*(mat+j*N+N-1-i);
      *(mat+j*N+N-1-i)=*(mat+(N-1-i)*N+N-1-j);
      *(mat+(N-1-i)*N+N-1-j)=*(mat+(N-1-j)*N+i);
      *(mat+(N-1-j)*N+i)=temp;
    }
  }
}
void dispayMatrix(int N,int *m){
  for(int i=0;i<N;i++){
    for(int j=0;j<N;j++){
      cout<<*(m+i*N+j)<<" ";
    }
    cout<<endl;
  }
}
int main(void){
  int N=4;
  int mat[N][N] =
  {
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12},
    {13, 14, 15, 16}
  };
 dispayMatrix(4,(int*)mat);
 rotateMatrix(4,(int*)mat);
 cout<<endl<<endl;
 dispayMatrix(4,(int*)mat);
}
