#include <iostream>
using namespace std;
int findMaxSum(int arr[],int size){
  int max=arr[0];
  int curr=arr[0];
  for(int i=1;i<size;i++){
    curr=curr+arr[i];
    if(curr<arr[i]){
      curr=arr[i];
    }
    if(max<curr){
      max=curr;
    }
  }
  return max;
}
int main(void){
  int test,size;
  cin>>test;
  int *arr;
  while(test--){
    cin>>size;
    arr=new int[size];
    for(int i=0;i<size;i++){
      cin>>arr[i];
    }
    cout<<findMaxSum(arr,size)<<endl;
  }
  // int arr[]={1,2,-1,4};
  // int size=sizeof(arr)/sizeof(arr[0]);
  // cout<<"answer = "<<findMaxSum(arr,size)<<endl;
}
