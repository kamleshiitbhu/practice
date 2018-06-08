#include <iostream>
using namespace std;
int a[100][100];
int p[10000];
bool isLoop(int n,int m,int i,int j,int f){
	if(i<0 || j<0 || i>=n || j>=m || a[i][j]==0)
		return false;
	if(p[i*m+j]==-1){
		p[i*m+j]=f;
	f=i*m+j;
	if(isLoop(m,n,i+1,j,f))
		return true;
	if(isLoop(m,n,i,j+1,f))
		return true;
	if(isLoop(m,n,i-1,j,f))
		return true;
	if(isLoop(m,n,i,j-1,f))
		return true;
	}else {
		if(p[f]!=i*m+j){			
			return true;
		}			
		return false;
	}
}
int main(){
	int n,m;
	cin>>n>>m;
	for(int i=0;i<n;i++){
		for(int j=0;j<m;j++){
			cin>>a[i][j];
			p[i*m+j]=-1;
		}			
	}	
	if(isLoop(n,m,0,0,0)){
		cout<<"Loop exists in matrix\n";
	}else{
		cout<<"Loop does not exists in matrix\n";
	}
}