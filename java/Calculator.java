
public class Calculator {
	static int all[] = new int[1000];
	static boolean arr[] = new boolean[10];
	static boolean op[] = new boolean[5];
	static boolean visited[] = new boolean[1000];
	static int aval_num[];
	static void set_array(int a[],boolean b[]) {
		int size = a.length;
		for(int i=0;i<size;i++) {
			b[a[i]] = true;
		}
	}
	static int isPossioble(int x) {
		int count = 0;
		while(x>0) {
			int temp = x%10;
			if(!arr[temp])
				return Integer.MAX_VALUE;
			count++;
			x = x/10;
		}
		return count;
	}
	static int min(int a,int b) {
		return a>b?b:a;
	}
	 static void findMinimum() {
		for(int i=1;i<1000;i++) {
			for(int j=i;j<1000;j++) {
				if(all[i] == Integer.MAX_VALUE || all[j] == Integer.MAX_VALUE) {
					continue;
				}
				if(op[0] && i+j<1000) {
					all[i+j] = min(all[i+j],all[i]+all[j]+1);
				}
				if(j-i>0 && op[1] && j-i<1000) {
					all[j-i] = min(all[j-i],all[i]+all[j]+1);
				}
				if(op[2] && i*j<1000) {
					all[i*j] = min(all[i*j],all[i]+all[j]+1);
				}
				if(op[3] && i+j<1000) {
					all[j/i] = min(all[j/i],all[i]+all[j]+1);
				}
			}
		}
	 }
	public static void main(String[] args) {
		int aval_num[] = {1,2,6,7,8};
		int aval_op[] = {1/* + */,2/* - *//* / */};
		set_array(aval_num,arr);
		set_array(aval_op,op);
		all[0] = 0;
		for(int i=1;i<all.length;i++) {
			all[i] = isPossioble(i);
		}
		for(int i=0;i<10;i++) {
			findMinimum();
		}
		System.out.println(all[981]+1);;
	}
}
