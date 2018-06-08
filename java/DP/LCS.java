class Main{
  static int  max(int a,int b){
    return (a>b?a:b);
  }
  static int max(int a,int b,int c){
    return max(a,max(b,c));
  }
  public static void main(String[] args){
      String s1,s2;
      s1 = "AABEBCDD";
      /*
      int m = s1.length();
      int n = s2.length();
      int p[][] = new int[m+1][n+1];
      for(int i=1;i<=m;i++){
        for(int j=1;j<=n;j++){
          if(s1.charAt(i-1)==s2.charAt(j-1)){
            p[i][j] = p[i-1][j-1] + 1;
          }
          p[i][j] = max(p[i][j],p[i-1][j],p[i][j-1]);
        }
      }
      System.out.println("answer = " + p[m][n]);
      */
      int n = s1.length();
      int p[][] = new int[n+1][n+1];
      for(int i=1;i<=n;i++){
        for(int j=1;j<=i;j++){
          if(i!=j && s1.charAt(i-1)==s1.charAt(j-1)){
            p[i][j] = p[i-1][j-1] + 1;
          }else
            p[i][j] = max(p[i-1][j],p[i][j-1]);
        }
      }
      System.out.println("answer = " + p[n][n]);
  }
}
