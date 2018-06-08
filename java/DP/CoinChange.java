class Main{
  static final boolean REPEAT = false;
  public static void main(String[] args){
    int a[] = {1,2,3};
    int n = a.length;
    int sum = 5;
    int p[][]=new int[n+1][sum+1];
    for(int i=0;i<=n;i++){
      for(int j=0;j<=sum;j++){
        p[i][j] = 0;
      }
    }
    for(int i=1;i<=n;i++){
      for(int j=0;j<=sum;j++){
        p[i][j] = p[i][j] + p[i-1][j];
        if(j-a[i-1]>0){
          if(REPEAT){
            p[i][j] = p[i][j] + p[i][j-a[i-1]];
          }else{
            p[i][j] = p[i][j] + p[i-1][j-a[i-1]];
          }
        }
        else if(j == a[i-1]){
          if(REPEAT){
            p[i][j] = p[i][j] + 1;
          }else{
            p[i][j] = p[i-1][j] + 1;
          }
        }
        //  System.out.println(i +" " + j + " " + p[i][j]);
      }
    }
    System.out.println("answer = " + p[n][sum]);
  }
}
