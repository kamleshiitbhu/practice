import java.util.*;
class FindComb{
	static int find(int a[],int sum){
		int n=a.length;
		int s[][]=new int[n+1][sum+1];
		for(int i=0;i<=n;i++)
			s[i][0]=1;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=sum;j++){
				s[i][j]=s[i-1][j]+((j-a[i-1]>=0)?s[i-1][j-a[i-1]]:0);
			}
		}
		return s[n][sum];
	}
	static int count=0;
	static void find(int a[],int sum,int n,int index,int curr){
		if(curr>sum)
			return;
		if(curr==sum){
			count++;
			return;
		}
		if(index>=n)
			return;
		find(a,sum,n,index+1,curr+a[index]);
		find(a,sum,n,index+1,curr);
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int sum=sc.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		int x=find(a,sum);
		find(a,sum,a.length,0,0);
		System.out.println("dynamic = "+x+"\nbacktrack = "+count);
	}
}