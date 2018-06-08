/*
class Dimension{
  int r,c;
  Dimension(int r,int c){
    this.r=r;
    this.c=c;
  }
}
int max(Dimension a,Dimension b){
  if()
}
class Main{
  public static void main(String[] args){
    int mat[][];
    int row = mat.length;
    int col = mat[0].length;
    Dimension sol[][]=new Dimension[row][col];
    if(mat[0][0]==1){
      sol[0][0] = new Dimension(1,1);
    }
    for(int r=1;r<row;r++){
      if(mat[r][0]==1){
        sol[r][0] = new Dimension(sol[r-1][0].r+1,sol[r-1][0].c);
      }else{
        sol[r][0]=new Dimension(0,0);
      }
    }
    for(int c=1;c<col;c++){
      if(mat[0][c]==1){
        sol[0][c] = new Dimension(sol[0][c-1].r,sol[0][c-1].c+1);
      }else{
        sol[r][0]=new Dimension(0,0);
      }
    }
    for(int r=1;r<row;r++){
      for(int c=1;c<col;c++){
        if(mat[r][c]==1){
          sol[0][c] = new Dimension(sol[0][c-1].r,sol[0][c-1].c+1);
        }else{
          sol[r][0]=new Dimension(0,0);
        }
      }
    }
  }
}
*/
