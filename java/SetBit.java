class SetBit{
	static long set[] = new long[32];
	static long c[][] = new long[32][32];
	static long coff(int n,int k){
		if(k==0 || k==n){
			c[n][k]=1;			
		}
		if(c[n][k]==-1)
			c[n][k] = coff(n-1,k-1)+coff(n-1,k);
		return c[n][k];
	}
	public static void main(String[] args){
		long ans = 0;
		c[0][0] = 0;
		int n = Integer.parseInt(args[0]);
		for(int i=0;i<32;i++){
			for(int j=0;j<32;j++){
				c[i][j] = -1;
			}
		}
		set[0] = 1;
		for(int i=1;i<32;i++){
			set[i] = 1;
			for(int j=1;j<=i;j++){					
				set[i] = set[i] + j*coff(i,j);
			}
			//System.out.println(i+" "+set[i]);
		}
		int count = 0;
		for(int i=0;i<32;i++){
			if(((1<<i)&n)!=0){	
				count++;
				ans = set[i];
			}
		}
		
		//System.out.println(count+"  " + ans);	
		for(int i=1;i<count;i++){
			ans = ans + (i+1)*coff(count-1,i);
		}
		System.out.println("Total set bit count is  " + ans);					
	}
}