#include <iostream>
using namespace std;
int min(int a,int b){
	return a>b?b:a;
}
int findMin(int arr[],int size){
	int l[size];
	l[0]=0;
	for(int i=1;i<size;i++){
		l[i] = 10000;
		for(int j=0;j<i;j++){
			if(l[j]!=10000 && (i-j)<=arr[j])
				l[i] = min(l[i],l[j]+1);
		}
	}
	for(int i=0;i<size;i++){
	//	cout<<l[i]<<endl;
	}
	if(l[size-1]!=10000)
		return l[size-1];
	return -1;
}
int main(void){
	 int arr[] = {1, 3, 6, 1, 0, 9};
	int n = sizeof(arr)/sizeof(arr[0]);
	cout<<findMin(arr,n)<<endl;
}