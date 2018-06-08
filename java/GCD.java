import java.util.*;
class Node {
    int key, val;
    Node next;
    Node(int key, int val)
    {
        this.key = key;
        this.val = val;
    }
};
class HashMap {
    private int size;
    private Node map[];
    int hashCode(int key)
    {
        return key % size;
    }
    HashMap(int size)
    {
        this.size = size;
        map = new Node[size];
        for (int i = 0; i < size; i++) {
            map[i] = null;
        }
    }
    /*
    ~HashMap()
    {
        reset();
        delete map;
    }
    */
     

    boolean put(int key, int value)
    {
        int k = hashCode(key);
        Node curr;
        curr = map[k];
        while (curr != null) {
            if (curr.key == key) {
                curr.val = value;
                return true;
            }
            curr = curr.next;
        }
        Node head = new Node(key, value);
        head.next = map[k];
        map[k] = head;
        return false;
    }
    int get(int key)
    {
        int k = hashCode(key);
        Node curr;
        curr = map[k];
        while (curr != null) {
            if (curr.key == key) {
                return curr.val;
            }
            curr = curr.next;
        }
        return -1;
    }
}    
/*
bool remove(int key)
{
    int k = hashCode(key);
    Node* curr = map[k];
    Node *pre=0;
    while(curr!=0){
        if(curr->key == key){
            break;
        }
        pre=curr;
        curr=curr->next;
    }
    if(curr==0){
        return false;
    }
    if(pre==0){
        curr=map[k];
        map[k]=map[k]->next;
        delete curr;
        return true;
    }
    pre->next=curr->next;
    delete curr;
    return true;
}
 
void HashMap::reset(){
    Node* next;
    Node* curr;
    for (int i = 0; i < size; i++) {
        curr = map[i];
        while (curr != 0) {
            next = curr->next;
            delete curr;
            curr = next;
        }
        map[i]=0;
    }
}
*/







class GCD{
    static final int  MAX_N  = 100000;
    static final int  MAX_A  = 100000;
    static final int  MAX_TEST =  100000;
    static final int mod=1000000007;  
    static int arr[]=new int[MAX_N];
    static int n,q;  
    static int gcd(int a,int b){
        if(a==0)
            return b;
        if(b==0)
            return a;
        if(a>b){
            return gcd(a%b,b);
        }else{
            return gcd(b%a,a);
        }
    }
    static HashMap map=new HashMap(10000);
    static int fib(int n){
        if(n<=2)
            return 1;
        int a,b,c;
        a=1;b=1;
        c=-1;
        for(int i=3;i<=n;i++){
            c=(a%mod+b%mod)%mod;
            a=b;
            b=c;
        }
        return c;
    }
    static int min(int a,int b){
        return a>b?b:a;
    }
    static int gcd(int l,int r,int n){
        int x=arr[l];
        int y=-1;
        int g=-1;
        for(int i=l+1;i<=r;i++){
            if(arr[i]<x){
                y=x;
                x=arr[i];
                g=gcd(x,y);
            }
            if(x==1 || g==1)
                return 1;
        }
        if(g==-1){
            g=x;
        }
        for(int i=l;i<=r;i++){
            g=gcd(g,arr[i]);
            if(g==1)
                return g;
        }
        return g;
    }    
    public static void main(String[] args)
    {
        int l,r,x,n,q,t;  
        Scanner sc=new Scanner(System.in); 
        n=sc.nextInt();
        q=sc.nextInt();
         for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for(int i=0;i<q;i++){
            l=sc.nextInt();
            r=sc.nextInt();            
            l--;
            r--;
            if(r==l){
                x=arr[l];
            }else{
                x=gcd(l,r,n);
            }
            t=map.get(x);
            if(t==-1){
                t=fib(x);
                map.put(x,t);
            }
            System.out.println(t);       
        }
    }
}    
