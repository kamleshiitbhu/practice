import java.util.*;
class Anirudh{
	final static int MAX_N = 32;
	static 	HashMap<Integer,Long> map = new HashMap<>();
	static long findMaxPoints(int current,int arr[]){
		Long point = map.get(current);
		if(point!=null){
			return point;
		}
		long max=Long.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			if(((1<<i)&current)!=0){
				long left,right;
				left = right = -1;
				//find in left
				for(int index=i-1;index>=0;index--){
					if(((1<<index)&current)!=0){
						left = arr[index];
						break;
					}
				}
				for(int index=i+1;index<arr.length;index++){
					if(((1<<index)&current)!=0){
						right = arr[index];
						break;
					}
				}
				long p=-1;
				if(left!=-1 && right!=-1){
					p = left * right;
				}else if(left!=-1){
					p=left;
				}else if(right!=-1){
					p=right;
				}else{
					p=arr[i];
				}
				p=p+findMaxPoints(current^(1<<i),arr);
				//System.out.println("value of p = " + p + " current = " + current);
				max = (max>p)?max:p;				
			}
		}
		map.put(current,max);
		return max;
	}
	public static void main(String[] args){
		int arr[]={10,20,30,40};
		map.put(0,0L);
		int current = 0;
		int n = arr.length;
		current = (1<<n)-1; 
		System.out.println("answer = " + findMaxPoints(current,arr));
		//System.out.println("value of 13 = " + map.get(13));		
			
	}
	
}
