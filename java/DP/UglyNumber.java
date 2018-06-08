import java.util.*;

class Main{
  public static void main(String[] args){
    HashSet<Integer> set = new HashSet<>();
    int n = 150;
    set.add(1);;
    set.add(2);
    set.add(3);
    set.add(4);
    set.add(5);
    int count = 5;
    int ans = 0;
    int i = 5;
    while(count<n){
      int r = 2;
      i++;
      if(i%r==0 && set.contains(i/r)){
        set.add(i);
        count++;
        ans = i;
        continue;
      }
      r = 3;
      if(i%r==0 && set.contains(i/r)){
        set.add(i);
        count++;
        ans = i;
        continue;
      }
      r = 5;
      if(i%r==0 && set.contains(i/r)){
        set.add(i);
        count++;
        ans = i;
        continue;
      }
    }
    System.out.println("answer = " + ans);
  }
}
