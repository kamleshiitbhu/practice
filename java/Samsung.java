import java.util.*;
class TestClass {
	static int findMaxPrice(Model[] models,int count[],int a,int b,int c,int d,int e,int i) {
		int n=models.length;
		if(i>=n)
			return 0;
		int x,y,z;
		x=y=z=0;
		x=a*d+b*e;
		Model model=models[i];
		a=a-model.c;
		b=b-model.b;
		c=c+model.m;
		if(a>=0 && b>=0 && c>=0) {
			if(checkUnique(count)<3) {
				count[i]++;
				y=model.p+findMaxPrice(models,count,a,b,c,d,e,i);
				count[i]--;
			} else if(checkUnique(count)==3 && count[i]>0)
			{
				count[i]++;
				y=model.p+findMaxPrice(models,count,a,b,c,d,e,i);
				count[i]--;
			}
		}
		a=a+model.c;
		b=b+model.b;
		c=c+model.m;
		z=findMaxPrice(models,count,a,b,c,d,e,i+1);		
		return max(x,y,z);
	}
	static int max(int a,int b,int c) {
		if(a>b) {
			if(a>c)
				return a;
			else
				return c;				
		} else {
			if(b>c)
				return b;
			else
				return c;
		}
	}
	static int checkUnique(int count[]) {
		int n=count.length;
		int c=0;
		for(int i=0;i<n;i++) {
			if(count[i]>0)
				c++;
		}
		return c;
	}
	public static void main(String[] args) {
		/*
			t is test case
			a is number of CPU
			b is number of BOARD
			c is number of MEMORY
			d is price of one CPU
			e is price of one BOARD
			n is count of Model
		*/
		int t,a,b,c,d,e;
		int n;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		while((t--)>0){
			a=sc.nextInt();
			b=sc.nextInt();
			c=sc.nextInt();
			d=sc.nextInt();
			e=sc.nextInt();
			n=sc.nextInt();
			Model[] models=new Model[n];
			int count[]=new int[n];
			for(int i=0;i<n;i++) {
				int p,q,r,s;
				p=sc.nextInt();
				q=sc.nextInt();
				r=sc.nextInt();
				s=sc.nextInt();
				models[i]=new Model(p,q,r,s);
			}
			int maxPrice=findMaxPrice(models,count,a,b,c,d,e,0);
			System.out.println("TEST CASE " + (t+1) + ":  " + maxPrice);
		}
	}
}
class Model {
	/*
		c is number of CPU used
		b is number of BOARD used
		m is number of MEMORY used		
		p is price of Model
	*/
	int c,m,b,p;
	Model(int c,int b,int m,int p) {
		this.c=c;
		this.b=b;
		this.m=m;
		this.p=p;
	}
}