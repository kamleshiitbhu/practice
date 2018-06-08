class Cube{
  int l,w,h;
  Cube(int l,int w,int h){
    this.l = l;
    this.w = w;
    this.h = h;
  }
}
class Main{
  static int hash[];
  static int max(int a,int b){
    return (a>b)?a:b;
  }
  static int findMaxHeight(Cube[] cubes,int state,int index,int type){
    if(hash[state]!=-1){
      return hash[state];
    }
    int n = cubes.length;
    int m_height = Integer.MIN_VALUE;
    for(int i=0;i<n;i++){
      if((state&(1<<i))==1){
        if(type==1){
          if((cubes[i].w<cubes[index].w && cubes[i].h<cubes[index].h) || (cubes[i].w<cubes[index].h && cubes[i].h<cubes[index].w)){
            int t_state = (state^(1<<i)); //temp state
            int height = cubes[i].l + findMaxHeight(cubes,t_state,i,1);
            m_height = max(m_height,height);
          }
          else if((cubes[i].l<cubes[index].w && cubes[i].h<cubes[index].h) || (cubes[i].h<cubes[index].h && cubes[i].l<cubes[index].w)){
            int t_state = (state^(1<<i)); //temp state
            int height = cubes[i].w + findMaxHeight(cubes,t_state,i,2);
            m_height = max(m_height,height);
          }else if((cubes[i].l<cubes[index].w && cubes[i].w<cubes[index].h) || (cubes[i].w<cubes[index].h && cubes[i].l<cubes[index].w)){
            int t_state = (state^(1<<i)); //temp state
            int height = cubes[i].h + findMaxHeight(cubes,t_state,index,3);
            m_height = max(m_height,height);
          }
          int t_state = (state^(1<<i)); //temp state
          int height = findMaxHeight(cubes,t_state,i,type);
          m_height = max(m_height,height);
        }else if(type==2){
          if((cubes[i].w<cubes[index].l && cubes[i].h<cubes[index].h) || (cubes[i].w<cubes[index].h && cubes[i].h<cubes[index].l)){
            int t_state = (state^(1<<i)); //temp state
            int height = cubes[i].l + findMaxHeight(cubes,t_state,i,1);
            m_height = max(m_height,height);
          }
          else if((cubes[i].l<cubes[index].l && cubes[i].h<cubes[index].h) || (cubes[i].h<cubes[index].h && cubes[i].l<cubes[index].l)){
            int t_state = (state^(1<<i)); //temp state
            int height = cubes[i].w + findMaxHeight(cubes,t_state,i,2);
            m_height = max(m_height,height);
          }else if((cubes[i].l<cubes[index].l && cubes[i].w<cubes[index].h) || (cubes[i].w<cubes[index].h && cubes[i].l<cubes[index].l)){
            int t_state = (state^(1<<i)); //temp state
            int height = cubes[i].h + findMaxHeight(cubes,t_state,i,3);
            m_height = max(m_height,height);
          }
          int t_state = (state^(1<<i)); //temp state
          int height = cubes[i].h + findMaxHeight(cubes,t_state,index,type);
          m_height = max(m_height,height);
        }else if(type==3){
          if((cubes[i].w<cubes[index].w && cubes[i].h<cubes[index].l) || (cubes[i].w<cubes[index].l && cubes[i].h<cubes[index].w)){
            int t_state = (state^(1<<i)); //temp state
            int height = cubes[i].l + findMaxHeight(cubes,t_state,i,1);
            m_height = max(m_height,height);
          }
          else if((cubes[i].l<cubes[index].w && cubes[i].h<cubes[index].l) || (cubes[i].h<cubes[index].l && cubes[i].l<cubes[index].w)){
            int t_state = (state^(1<<i)); //temp state
            int height = cubes[i].w + findMaxHeight(cubes,t_state,i,2);
            m_height = max(m_height,height);
          }else if((cubes[i].l<cubes[index].w && cubes[i].w<cubes[index].l) || (cubes[i].w<cubes[index].l && cubes[i].l<cubes[index].w)){
            int t_state = (state^(1<<i)); //temp state
            int height = cubes[i].h + findMaxHeight(cubes,t_state,i,3);
            m_height = max(m_height,height);
          }
          int t_state = (state^(1<<i)); //temp state
          int height = cubes[i].h + findMaxHeight(cubes,t_state,index,type);
          m_height = max(m_height,height);
        }
      }
    }
    hash[state] = m_height;
    return hash[state];
  }
  public static void main(String[] args){
    Cube[] cubes={new Cube(27,24,35),new Cube(76,36,3)};
    int n = cubes.length;
    hash = new int[(1<<n)];
    int state = (1<<n)-1;
    for(int i=0;i<hash.length;i++){
      hash[i]=-1;
    }
    hash[0] = 0;
    int m_height = Integer.MIN_VALUE;
    for(int i=1;i<n;i++){
      int height;
      int t_state = (state^(1<<i)); //temp state
      height = cubes[i].l + findMaxHeight(cubes,t_state,i,1);
      m_height = max(m_height,height);
      height = cubes[i].w + findMaxHeight(cubes,t_state,i,2);
      m_height = max(m_height,height);
      height = cubes[i].h + findMaxHeight(cubes,t_state,i,3);      
      m_height = max(m_height,height);
    }
    hash[state] = m_height;
    System.out.println("answer = " + hash[state]);
  }
}
