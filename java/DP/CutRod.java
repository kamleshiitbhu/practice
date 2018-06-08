class Main{
  static int  max(int a,int b){
    return (a>b?a:b);
  }
  public static void main(String[] args){
    int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
    int l = arr.length;
    int price[] = new int[l+1];
    price[1] = arr[0];
    for(int i = 2;i<=l;i++){
      price[i] = arr[i-1];
      for(int j=1;j<i;j++){
        price[i] = max(price[i],price[j]+price[i-j]);
      }
    }
    System.out.println("answer = " + price[l]);
  }
}
