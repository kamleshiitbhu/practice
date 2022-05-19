import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1, 2, 3, 4);
        System.out.println(getMinimumCost(l, 6));
    }
    public static long getMinimumCost(List<Integer> parcel, int k) {
        if (parcel.size() >= k) {
            return 0;
        }
        Collections.sort(parcel);
        k = k - parcel.size();
        long ans = 0;
        int index = 0;
        for (int i = 1; i < parcel.get(parcel.size() - 1) && k > 0; i++) {
            if (parcel.get(index) == i) {
                index += 1;
            } else {
                k--;
                ans = ans + i;
            }
        }
        int start = 1;
        while (k > 0) {
            ans = ans + parcel.get(parcel.size() - 1) + start;
            k--;
            start++;
        }
        return ans;
    }
}