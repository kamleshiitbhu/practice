class Main{
  static int max(int a,int b){
    return (a>b)?a:b;
  }
  public static void main(String[] args){
    int arr[]= {1, 101, 2, 3, 100, 4, 5};
    int n = arr.length;
    int l[]=new int[n];
    l[0] = arr[0];
    for(int i=1;i<n;i++){
      l[i] = Integer.MIN_VALUE;
      for(int j=0;j<i;j++){
        if(arr[i]>arr[j]){
          l[i] = max(l[i],l[j]+arr[i]);
        }
      }
    }
    int ans = l[0];
    for(int i=1;i<n;i++){
      ans = max(ans,l[i]);
    }
    System.out.println("answer = " + ans);
  }
}
