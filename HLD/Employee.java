@Builder
public class Employee {
    Integer id;
    String name;

    private static volatile AtomicInteger currentIndex = 0;
    Employee(String name) {
        id = getNextId();
        this.name = name;
    }
    private Integer static getNextId() {
        return currentIndex++;
    }

    public static void main(String[] args) throws Exception {
        Employee e1 = new Employee("E1");

    }

    public int countOnes(int x) {
        int ans = 0;
        while (x > 0) {
            if (x & 1 == 1) {
                ans += 1;
            }
            x = x >> 1;
        }
        return ans;
    }



}

// 1110101010101

// x & 1

// add , delete , modify

// loadbalancer --> multiple service
// database --> mongodb
// model (id, text, postid, supercommentid)
// add comment
    // restapi -> addComment(postid, text, ) => push database 
    // response => 201 
    // delete => de


               4
            2      5
        2      1       4


        // O(n)
        // o(2*h) => o(h)