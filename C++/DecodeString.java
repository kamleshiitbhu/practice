import java.util.*;
class DecodeString{
	static int countString(String str){
		char[] s=str.toCharArray();
		int l=s.length;
		int c[]=new int[l+1];
		c[0]=c[1]=1;
		for(int i=2;i<=l;i++){
			c[i]=0;
			if(s[i-1]>'0')
				c[i]=c[i-1];
			if(s[i-2]<'2' || (s[i-2]=='2' && s[i-1]<'7'))
				c[i]=c[i]+c[i-2];
		}
		return c[l];
	}
	public static void main(String  args[]){
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		System.out.println(countString(str));
	}
}