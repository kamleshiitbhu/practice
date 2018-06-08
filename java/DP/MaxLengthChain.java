class Point{
  int x,y;
  Point(int x,int y){
    this.x = x;
    this.y = y;
  }
}
class Main{
  static int max(int a,int b){
    return (a>b)?a:b;
  }
  public static void main(String[] args){
    Point arr[]={new Point(5, 24), new Point(39, 60), new Point(15, 28), new Point(27, 40), new Point(50, 90) };
    int n = arr.length;
    int l[]=new int[n];
    l[0] = 1;
    for(int i=1;i<n;i++){
      l[i] = Integer.MIN_VALUE;
      for(int j=0;j<i;j++){
        if(arr[j].y<arr[i].x){
          l[i] = max(l[i],l[j]+1);
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
