class Main{
  static int  min(int a,int b){
    return (a>b?b:a);
  }
  public static void main(String[] args){
    int n,k;
    n = 5;k =2;
    k = min(n-k,k);
    int c[][]=new int[n+1][k+1];
    for(int i=1;i<=n;i++){
      c[i][0] = 1;
      c[i][1] = i;
    }
    for(int i=2;i<=n;i++){
      for(int j=1;j<=min(n,k);j++){
        c[i][j] = c[i-1][j-1] + c[i-1][j];
      }
    }
    System.out.println("answer = " + c[n][k]);
  }
}
