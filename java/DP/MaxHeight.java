class Main{
  public static void main(String[] args){
    int arr[] = {1,2,3,4,6,2};
    int sum = 0;
    for(int i=0;i<arr.length;i++){
      sum = sum + arr[i];
    }
    int n = arr.length;
    int half;
    if(sum%2 == 0)
      half = sum/2;
    else
      half = sum/2 + 1;
    boolean visited[][][]=new boolean[n+1][half+1][half+1];
    for(int i=0;i<=n;i++){
      visited[i][0][0]=true;
      if(i>0){
        visited[i][arr[i-1]][0]=true;
        visited[i][0][arr[i-1]]=true;
      }
    }
    for(int i=1;i<=n;i++){
      for(int s1=0;s1<=half;s1++){
        for(int s2=0;s2<=half;s2++){
          visited[i][s1][s2] = visited[i][s1][s2] | visited[i-1][s1][s2];
          if(s1-arr[i-1]>=0){
            visited[i][s1][s2] = visited[i-1][s1-arr[i-1]][s2] | visited[i][s1][s2];
          }
          if(s2-arr[i-1]>=0){
            visited[i][s1][s2] = visited[i-1][s1][s2-arr[i-1]] | visited[i][s1][s2];
          }
        }
      }
    }
    int ans = 0;
    for(int i=0;i<=half;i++){
      if(visited[n][i][i]){
        ans = i;
      }
    }
    System.out.println("answer = " + ans);
  }
}
