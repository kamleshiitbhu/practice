class Point{
  int x,y;
  Point(int x,int y){
    this.x = x;
    this.y = y;
  }
}
class Main{
  static int hash[];
  static Point office;
  static Point home;
  static int min(int a,int b){
    return(a>b)?b:a;
  }
  static int abs(int x){
    if(x<0){
      return -x;
    }
    return x;
  }
  static int dist(Point a,Point b){
    return (abs(a.x-b.x)+abs(a.y-b.y));
  }
  static int findDistance(Point[] points,int state,int index){
    if(state==0){
      return dist(home,points[index]);
    }
    if(hash[state]!=Integer.MAX_VALUE){
      return hash[state];
    }
    int n = points.length;
    int m_distance = Integer.MAX_VALUE;
    for(int i=0;i<n;i++){
      if((state&(1<<i))!=0){
        int t_state = (state^(1<<i));
        int distance = dist(points[index],points[i]) + findDistance(points,t_state,i);
        m_distance = min(m_distance,distance);
      }
    }

    hash[state] = m_distance;
    return hash[state];
  }
  public static void main(String[] args){
    office = new Point(0,0);
    home = new Point(100,100);
    Point[] points = {new Point(20,30),new Point(50,50)};
    int n = points.length;
    hash = new int[(1<<n)];
    hash[0] = 0;
    for(int i=1;i<hash.length;i++){
      hash[i] = Integer.MAX_VALUE;
    }
    int state = (1<<n)-1;
    int m_distance = Integer.MAX_VALUE;
    for(int i = 0;i<n;i++){
      int t_state = (state^(1<<i));      
      int distance = dist(office,points[i])+findDistance(points,t_state,i);
      m_distance = min(m_distance,distance);
    }
    hash[state] = m_distance;
    System.out.println("answer = " + hash[state]);
  }
}
