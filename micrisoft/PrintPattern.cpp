#include <iostream>
using namespace std;
void printpattern(int n){
  if(n==0 || n<0){
    cout<<n<<" ";
    return;
  }
  cout<<n<<" ";
  printpattern(n-5);
  cout<<n<<" ";
}
int main(void){
  printpattern(10);
}
