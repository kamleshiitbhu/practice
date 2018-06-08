class Main{
  static int max(int a,int b){
    return (a>b)?a:b;
  }
  public static void main(String[] args){
    String s1,s2;
    s1 = "OldSite:GeeksforGeeks.org";;//"GeeksQuiz";
    s2 = "NewSite:GeeksQuiz.com";;//"GeeksForGeeks";
    int m = s1.length();
    int n = s2.length();
    boolean check[][] = new boolean[m+1][n+1];
    int l[][] = new int[m+1][n+1];
    for(int i=0;i<=m;i++){
      l[i][0] = 0;
    }
    for(int i=0;i<=n;i++){
      l[0][i] = 0;
    }
    int ans = -1;
    int index = 0;
    for(int i=1;i<=m;i++){
      for(int j=1;j<=n;j++){
        if(s1.charAt(i-1)==s2.charAt(j-1)){
          if(check[i-1][j-1]){
            l[i][j] = l[i-1][j-1] + 1;
          }else{
            l[i][j] = 1;
          }
          check[i][j] = true;
        }else{
          l[i][j] = 0;
        }
        if(ans<l[i][j]){
          ans = l[i][j];
          index = i-ans;
        }
      }
    }
    System.out.println("answer = " + ans  + " and string is " + s1.substring(index,index+ans));
  }
}
