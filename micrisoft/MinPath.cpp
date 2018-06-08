#include <iostream>
using namespace std;
long minpath(int n){
  long path[n][n];
  path[0][0]=1;
  for(int i=1;i<n;i++){
    path[0][i]=1;
  }
  for(int i=1;i<n;i++){
    path[i][0]=1;
  }
  for(int i=1;i<n;i++){
    for(int j=1;j<n;j++){
      path[i][j]=path[i-1][j] + path[i][j-1];
    }
  }
  return path[n-1][n-1];
}
int main(void){
  int n = 64;
  cout<<"answer = "<<minpath(n)<<endl;
}
