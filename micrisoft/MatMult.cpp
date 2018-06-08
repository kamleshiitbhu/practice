#include <iostream>
using namespace std;
#define MAX_VALUE 0x7fffffff
int min(int a,int b){
  return (a>b?b:a);
}
long multi(int p[],int size){
  int m[size][size];
  for(int i=0;i<size;i++){
    m[i][i]=0;
  }
  for(int l=2;l<size;l++){
    for(int i=1;i<=size-1;i++){
      int j=i+l-1;
      if(j>=size){
        break;
      }
      m[i][j] = MAX_VALUE;
      for(int k=i;k<j;k++){
        m[i][j] = min(m[i][j],m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j]);
      }
    }
  }
  return m[1][size-1];
}
int main(void){
  int arr[]={1,2,3,4};
  int size = sizeof(arr)/sizeof(arr[0]);
  long ans = multi(arr,size);
  cout<<"answer = "<<ans<<endl;
}
