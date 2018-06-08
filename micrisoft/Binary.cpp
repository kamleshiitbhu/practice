#include <iostream>
using namespace std;
void binary(int n){
  if(n>1){
    binary(n>>1);
  }
  cout<<n%2;
}
int main(void){
  binary(255);
  cout<<endl;
}
