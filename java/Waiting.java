class Waiting{
  static int find_queue(int p[],int t[]){
    int q[]=new int[5];//={0};
    int l=t.length;
    q[0]=p[0];
    int queue=1;
    for(int i=1;i<l;i++){
      int c=-1;
      for(int j=0;j<queue;j++){
        if(q[j]>0)
          q[j]=q[j]-(t[i]-t[i-1]);
        if(q[j]<0)
          q[j]=0;
      }
      int s=0;
      for(int j=0;j<queue;j++){
        int sum = q[j]+p[i];
        if(sum>10){
          continue;
        }
        if(sum>=s){
          s=sum;
          c=j;
        }
      }
      if(c==-1 && queue==5){
        return -1;
      }else if(c==-1){
        q[queue]=p[i];
        queue++;
      }else{
        q[c]=q[c]+p[i];
      }
    }
    return queue;
  }
  public static void main(String args[]){
    int p[]={8,5,2,6};
    int t[]={1,2,3,4};
    System.out.println("min queue = " + find_queue(p,t));
  }
}
