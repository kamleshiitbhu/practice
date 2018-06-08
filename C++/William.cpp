#include<iostream>
using namespace std;
#define MAX_INT		999999
#define MAX_N 		100
#define MAX_K		100
int r[MAX_N],g[MAX_N],b[MAX_N];
int s[MAX_K];
int q[MAX_K];
int a[MAX_N][MAX_N];
int m;
int positve(int x){
	return x>0?x:-x;
}
int max(int x,int y){
	return x>y?x:y;
}
int min(int a,int b){
	return a>b?b:a;
}
int max(int x,int y,int z){
	return max(x,max(y,z));
}
int  dist(int i,int j){
	int x,y,z;
	x=positve(r[i]-r[j]);
	y=positve(g[i]-g[j]);
	z=positve(b[i]-b[j]);
	return max(x,y,z);
}
void find(int curr,int count,int index,int n,int k){

	if(count>=k){
		if(m>=curr){
			m=curr;
			for(int i=0;i<k;i++)
				q[i]=s[i];
		}
		return;
	}
	if(index>=n){
		return;
	}
	/* include current element */
	int temp=0;
	for(int i=0;i<count;i++){
		temp=max(temp,a[s[i]][index]);
		if(temp>=m)
			break;
	}
	if(temp<m){
		s[count]=index;
		if(curr<MAX_INT)
			temp=max(temp,curr);
		find(temp,count+1,index+1,n,k);
	}
	/* Not include current element */
	find(curr,count,index+1,n,k);
}
int main(){
	int t,n,k;
	cin>>t;
	while(t--){
		cin>>n>>k;
		for(int i=0;i<n;i++){
			cin>>r[i]>>g[i]>>b[i];
		}
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				int d=dist(i,j);
				a[i][j]	= a[j][i]=d;
			}
		}
		m=MAX_INT;
		for(int i=0;i<n;i++){
			s[0]=i;
			find(MAX_INT,1,i+1,n,k);
		}
		
		cout<<m<<endl;
		for(int i=0;i<k;i++){
			cout<<r[q[i]]<<" "<<g[q[i]]<<" "<<b[q[i]]<<endl;
		}
	}
}