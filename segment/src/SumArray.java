import java.util.Random;
public class SumArray {
	static int m[];
	static final int MAX_SIZE = 500;
	static final int MAX_NUMBER = 10000;
	static int segment(int arr[],int s,int e,int node){
		if(s==e){
			//System.out.println(s + " " + e);
			m[node] = arr[s];
		}else{
			int a,b;
			int mid = (s+e)/2;
			a = segment(arr,s,mid,2*node + 1);
			b = segment(arr,mid+1,e,2*node + 2);
			m[node] = a+b;
		}
		return m[node];
	}
	static int find_sum(int i,int j,int s,int e,int node){
		if(i>j)
			return 0;
		//System.out.print(s + " " + e);
		if(s==e){
			if(i<=s && j>=s)
				return m[node];
			return 0;
		}
		if((i<s && j<s) || (i>e && j>e)){
			return 0;
		}
		int a,b;
		int mid = (s+e)/2;
		a = find_sum(i,j,s,mid,2*node+1);
		b = find_sum(i,j,mid+1,e,2*node+2);
		return a+b;
	}
	static void change(int diff,int arr[],int s,int e,int index,int node){
		if(s==e){
			m[node]+=diff; 
		}else{
			int mid = (s+e)/2;
			m[node]+=diff;
			if(s<=index && index<=mid){				
				change(diff, arr, s, mid, index, 2*node+1);
			}else if((mid+1)<=index && index<=e){
				change(diff, arr, mid+1, e, index, 2*node+2);
			}
		}
	}
	public static void main(String args[]){
		Random rand = new Random();
		int size = (rand.nextInt()%(MAX_SIZE) + MAX_SIZE)%(MAX_SIZE)+1;
		int arr[] = new int[size];
		for(int i=0;i<size;i++)
			arr[i] = rand.nextInt()%(MAX_NUMBER)+1;
		m = new int[1500];
		segment(arr,0,arr.length-1,0);
		System.out.println();
		int test = 10000;
		boolean flag = true;
		while((test--)>0){
			int j = (rand.nextInt()%arr.length + arr.length)%arr.length;
			int i = (rand.nextInt()%arr.length + arr.length)%arr.length;
			int sum1 = 0;
			for(int k=i;k<=j;k++)
				sum1+=arr[k];
			int sum2 = find_sum(i, j, 0, arr.length-1, 0);			
			if(sum1!=sum2){
				flag = false;
				System.out.println("sum1 = " + sum1 + " and sum2 = " + sum2);
				System.out.println("not working properly");
				break;
			}
		}
		test = 1000;
		while((test--)>0){
			int index = (rand.nextInt()%arr.length + arr.length)%arr.length;
			int new_val = rand.nextInt()%(MAX_NUMBER)+1;
			int diff = new_val-arr[index];
			arr[index]+=diff;
			change(diff, arr, 0, arr.length-1, index, 0);			
		}
		test = 10000;		
		while((test--)>0){
			int j = (rand.nextInt()%arr.length + arr.length)%arr.length;
			int i = (rand.nextInt()%arr.length + arr.length)%arr.length;
			int sum1 = 0;
			for(int k=i;k<=j;k++)
				sum1+=arr[k];
			int sum2 = find_sum(i, j, 0, arr.length-1, 0);			
			if(sum1!=sum2){
				flag = false;
				System.out.println("sum1 = " + sum1 + " and sum2 = " + sum2);
				System.out.println("not working properly");
				break;
			}
		}		
		if(flag){
			System.out.println("working properly so far");
		}

	}
}
