#include <iostream>
using namespace std;
int twocomplement1(int n){
  return ((~n)+1);
}
int twocomplement2(int n){
  return (0-n);
}
int main(void){
  int n;
  cout<<"Enter number = ";
  cin>>n;
  int a = twocomplement1(n);
  int b = twocomplement2(n);
  cout<<((a==b)?"true":"false")<<endl;  
}
