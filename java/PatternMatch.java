import java.util.*;
class PatternMatch{
	static void preProcess(String pattern,int l[]){
		int length=pattern.length();
		l[0]=0;
		int j=0;
		int i=1;
		while(i<length){
			if((pattern.charAt(i)==pattern.charAt(j)) || (pattern.charAt(i)==(pattern.charAt(j)^32))){
				j++;
				l[j]=j;
				i++;
			}else {
				if(j!=0){
					j=l[j-1];
				}else{
					j=0;
					i++;					
				}
			}
		}
	}
	static void match(String str,String pattern){
		int l1=str.length();
		int l2=pattern.length();
		int i=0;
		int j=0;
		int l[]=new int[l2];		
		preProcess(pattern,l);		
		while(i<l1){
			if((pattern.charAt(j)==str.charAt(i)) || (pattern.charAt(j)==(str.charAt(i)^32))){				
				i++;
				j++;
			}
			if(j==l2){
				System.out.println("string found at " + (i-j));
				j=l[j-1];
			}else if(i<l1 && (pattern.charAt(j)!=str.charAt(i)) && ((pattern.charAt(j)!=(str.charAt(i)^32)))){
				if(j!=0)
					j=l[j-1];
				else{
					i++;					
				}
			}
		}
	}
	static void checkMatch(String a,String b){
		boolean flag=true;
		int m=a.length();
		int n=b.length();
		int i=0,j=0;
		while(i<m&&j<n){
			if((a.charAt(i)==b.charAt(j)) || (a.charAt(i)==(b.charAt(j)^32))){
				i++;
				j++;
			}				
			else{
				flag=false;
				break;
			}
		}
		if(flag)
			System.out.println("String are same");
		else
			System.out.println("String are not same");
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		String pattern,str;
		System.out.println("Enter two string by space saperated ");
		pattern=sc.nextLine().trim();
		str=sc.nextLine().trim();
		match(str,pattern);
		//checkMatch(str,pattern);
	}
}