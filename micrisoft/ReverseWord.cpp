#include <iostream>
using namespace std;
void substring(char *s,int i,int j){
  for(int k=i;k<j;k++){
    cout<<s[k];
  }
}
int length(char *str){
  int l=0;
  while(str[l])
    l++;
  return l;
}
int reverseString(char *str){
  int len=length(str);
  int pre=len;
  for(int i=len-1;i>=0;i--){
    if(str[i]=='.'){
      substring(str,i+1,pre);
      cout<<'.';
      pre=i;
    }
  }
  substring(str,0,pre);
}
int main(void){
  int test,size;
  cin>>test;
  char *str=new char[1000];
  while(test--){
    cin>>str;
    cout<<reverseString(str)<<endl;
  }
  // int arr[]={1,2,-1,4};
  // int size=sizeof(arr)/sizeof(arr[0]);
  // cout<<"answer = "<<findMaxSum(arr,size)<<endl;
}
