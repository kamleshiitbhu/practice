#include <iostream>
#include <stdlib.h>  
using namespace std;
#define MAX_A		100001
#define MAX_TEST	100
#define MAX     1000
#define mod 1000000007
int a[MAX][MAX];
int prime[MAX_A];
int count=0;
struct Node{
	int r,c;
	bool valid;
};
Node path[MAX+MAX+1];
Node ans[2*MAX+1];
void copyAnswer(){
	int i=0;
	while(1){
		if(!path[i].valid){
			break;
		}
		ans[i].r=path[i].r;
		ans[i].c=path[i].c;
		ans[i].valid=path[i].valid;
		i++;
	}
}
bool lexographical(){
    int i=0;
    while(1){
        if(!path[i].valid || !ans[i].valid)
            break;
        if(path[i].r==ans[i].r && path[i].c==ans[i].c){
            i++;
        }else if(path[i].r>ans[i].r){
            return true;
        }else if(path[i].r==ans[i].r && path[i].c>ans[i].c){
            return true;
        }else{
            return false;
        }
    }    
}
void printAnswer(){
	int i=0;
	while(1){
		if(!ans[i].valid){
			break;
		}
		cout<<ans[i].r<<" "<<ans[i].c<<"\n";
		i++;
	}
}
void init(int max){
	int p=2;
	int t;
	while(1){
		int j=2;
		int x=p*j;
		while(x<=max){
			prime[x]=1;
			j++;
			x=p*j;			
		}
		t=-1;	
		for(int i=p+1;i<=max;i++){
			if(prime[i]==0){
				t=i;
			}
		}
		if(t==-1)
			break;
		p=t;				
	}
}
void findPath(int i,int j,int n,int m,int index){
	if(i==n-1 && j==m-1){
	    path[index].r=i+1;
		path[index].c=j+1;
		path[index].valid=true;
		if(lexographical()){
			copyAnswer();
		}
		path[index].valid=false;
		count++;
		count=count%mod;
		return;
	}
	if((i+1)<n && (j+1)<m && (prime[a[i+1][j+1]]==0)){
		path[index].r=i+1;
		path[index].c=j+1;
		path[index].valid=true;
		findPath(i+1,j+1,n,m,index+1);
	}	
	if((i+1)<n && (prime[a[i+1][j]]==0)){
		path[index].r=i+1;
		path[index].c=j+1;
		path[index].valid=true;
		findPath(i+1,j,n,m,index+1);
	}
	if((j+1)<m && (prime[a[i][j+1]]==0)){
		path[index].r=i+1;
		path[index].c=j+1;
		path[index].valid=true;
		findPath(i,j+1,n,m,index+1);
	}
}
int maximum(int a,int b){
    return a>b?a:b;
}
int main(){
	int n,m,max=-1;
	cin>>n>>m;
	for(int i=0;i<n;i++){
		for(int j=0;j<m;j++){
			cin>>a[i][j];
			max=maximum(max,a[i][j]);
		}
	}
	init(max);
	findPath(0,0,n,m,0);
	cout<<count<<"\n";
	printAnswer();
}