class Salesman{
  static int dp[];
  static int binarytodecimal(boolean visited[]){
    int l = visited.length;
    int ans = 0;
    for(int i=0;i<l;i++){
      if(visited[i]){
        ans = ans | (1<<i);
      }
    }
    return ans;
  }
  static int abs(int x){
    if(x<0){
      return -x;
    }
    return x;
  }
  static int rec(int mat[][],visited[],int i){
    int bin = binarytodecimal(visited);
    if(dp[bin]!=-1){
      return dp[bin];
    }
    int min=Integer.MAX_VALUE;
    for(int j=0;j<visited.length;j++){
      if(!visited[j]){
        visited[j]=true;
        int dist = mat[i][j] + rec(mat,visited,j);
        visited[j]=false;
        min = (min>dist)?dist:min;
      }
      dp[bin]=
    }
  }
  public static void main(String args[]){
    int x[]={1,6,3,8,4,7};
    int y[]={2,6,3,6,3,6};
    int p = x.length;
    int mat[][] = new int[p][p];
    for(int i=0;i<p;i++){
      for(int j=0;j<p;j++){
        if(i==j){
          mat[i][j]=0;
        }
        mat[i][j]=mat[j][i]=abs(x[i]-x[j])+abs(y[i]-y[j]);
      }
    }
    dp = new int[(1<<p)];
    for(int i=0;i<dp.length;i++){
      dp[i] = -1;
    }
    boolean visited[]=new boolean[x.length];
  }
}
