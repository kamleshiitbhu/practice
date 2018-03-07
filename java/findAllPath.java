

import java.util.*;

public class findAllPath {
	static int pathCount;

	//static int[] x = { 1, 0, 1 };

	//static int[] y = { 0, 1, 1 };
	static Test test[] = new Test[100];
    
	ArrayList<Test> al  = new ArrayList<Test>();
	
	static int[][] current = new int[1000][1000];

	static void checkForPath(int[][] mat) {
		test[0] = new Test(0,0);
		pathToDest(mat, 0, 0,1);

		System.out.println(pathCount);

	}
	static void printPath(int index){
		System.out.println("------------path---------------");
		for(int i=0;i<index;i++){
			System.out.println("("+test[i].x+","+test[i].y+")");
		}
		System.out.println();
	}
	static void pathToDest(int[][] mat, int row, int col,int index) {
		int len=mat.length-1;
		if (row> len || col > len) {
			return ;
		}
		
	
       //check for prime number safety and store path
		if(IsSafe(mat, row, col)){
            if(row == 2 && col == 2){
				printPath(index);
            	pathCount++;
    			return ;	
            }
		}else{
			return;
		}
		
		/*if (row == 2 && col == 2 ) {
			pathCount++;
			return ;
		}*/
		test[index] = new Test(row,col+1);
		pathToDest(mat, row, col + 1,index+1);
		test[index] = new Test(row + 1,col);
		pathToDest(mat, row + 1, col,index+1);
		test[index] = new Test(row+1,col+1);
		pathToDest(mat, row + 1, col + 1,index+1);
		
	}
    //prime number check
	static Boolean IsSafe(int[][] mat, int i, int j) {
		if(mat[i][j]<=2)
			return true;
		int count = 0;
		//System.out.println(" " + i + " " + j);

		for (int x = 2; x <= mat[i][j] / 2; x++) {
			if (mat[i][j] % x == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) throws Exception {

		// Scanner

		Scanner s = new Scanner(System.in);

		int[][] mat = {

		{ 2, 3, 7 },

		{ 5, 4, 2 },

		{ 3, 7, 11 } };

		checkForPath(mat);

	}

}
	class Test{
		 int x;
		 int y;
	    Test(int x,int y){
			 this.x=x;
			 this.y=y;
		 }
		
	}


