import java.util.*;
class Node{
	int r,c;
	boolean valid;
	Node(){
		r=c=-1;
		valid=false;
	}
}
class Turtle{
	static final int MAX_A	=	100001;
	static final int MAX_TEST	= 100;
	static final int MAX    = 1000;
	static final int mod = 1000000007;
	static int a[][]=new int[MAX][MAX];
	static int c[][]=new int[MAX][MAX];
	static int prime[]=new int[MAX_A];
	static Node path[]=new Node[MAX+MAX+1];
	static Node ans[]=new Node[2*MAX+1];
	static int count=0;
	static void	init(){	
		for(int i=0;i<2*MAX+1;i++){
			path[i]=new Node();
			ans[i]=new Node();
		}

	}
	static void copyAnswer(){
		int i=0;
		while(true){
			if(!path[i].valid){
				break;
			}
			//System.out.println(path[i].valid);
			ans[i].r=path[i].r;
			ans[i].c=path[i].c;
			ans[i].valid=path[i].valid;
			i++;
		}
	}
	static boolean lexographical(){
	    int i=0;
	    while(true){
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
	    return false;  
	}
	static void printAnswer(){
		int i=0;
		while(true){
			if(!ans[i].valid){
				break;
			}
			System.out.println(ans[i].r + " " + ans[i].c);
			i++;
		}
	}
	static void initPrime(int max){
		int p=2;
		int t;
		while(true){
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
	static boolean  findPath(int i,int j,int n,int m,int index){		
		if(i==n-1 && j==m-1){
		    path[index].r=i+1;
			path[index].c=j+1;
			path[index].valid=true;
			if(lexographical() || !ans[0].valid){

				copyAnswer();
			}
			path[index].valid=false;
			count++;
			count=count%mod;
			return true;
		}		
		if((i+1)<n && (j+1)<m && (prime[a[i+1][j+1]]==0)){
			path[index].r=i+1;
			path[index].c=j+1;
			path[index].valid=true;
			if(findPath(i+1,j+1,n,m,index+1))
				return true;
		}	
		if((i+1)<n && (prime[a[i+1][j]]==0)){
			path[index].r=i+1;
			path[index].c=j+1;
			path[index].valid=true;
			if(findPath(i+1,j,n,m,index+1))
				return true;
		}
		if((j+1)<m && (prime[a[i][j+1]]==0)){
			path[index].r=i+1;
			path[index].c=j+1;
			path[index].valid=true;
			if(findPath(i,j+1,n,m,index+1))
				return true;
		}
		return false;
	}
	static int maximum(int a,int b){
	    return a>b?a:b;
	}
	public static void main(String[] args){
		init();
		Scanner sc=new Scanner(System.in);
		int n,m,max=-1;
		n=sc.nextInt();
		m=sc.nextInt();
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				a[i][j]=sc.nextInt();				
				max=maximum(max,a[i][j]);
			}
		}
		initPrime(max);
		for(int i=0;i<n;i++){
			if(prime[a[i][0]]==0)
				c[i][0]=1;
			else
				break;
		}		
		for(int i=0;i<m;i++){
			if(prime[a[0][i]]==0)
				c[0][i]=1;
			else
				break;
		}
		for(int i=1;i<n;i++){
			for(int j=1;j<m;j++){
				if(prime[a[i][j]]==0){
					if(i>0)
						c[i][j]=c[i][j]+c[i-1][j];
					if(i>0 && j>0)
						c[i][j]=c[i][j]+c[i-1][j-1];
					if(j>0)
						c[i][j]=c[i][j]+c[i][j-1];					
				}				
			}
		}
		System.out.println(c[n-1][m-1]);
		if(c[n-1][m-1]>0)
			findPath(0,0,n,m,0);
		//System.out.println(c[n-1][m-1]);
		//printAnswer();
	}
}