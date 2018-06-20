class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}

class Main{
    static void travellist(Node node){
        while(node!=null){
            System.out.println("data = " + node.data);
            node=node.next;
        }
    }
    static Node reverselist(Node root){
        Node p,q,r;
        p=null;
        q=root;
        while(q!=null){
            r=q.next;
            q.next=p;
            p=q;
            q=r;
        }
        return p;
    }
    static Node reverselist(Node root,int k){
        Node p,q,r;
        r=p=null;
        q=root;
        int count=0;
        while(q!=null && count<k){            
            r=q.next;
            q.next=p;
            p=q;
            q=r;
            count++;
        }        
        if(q!=null)
            root.next = reverselist(q,k);
        return p;
    }
    static Node addNode(Node root,int data){
        Node t = new Node(data);
        t.next = root;
        return t;
    }
    public static void main(String[] arg){
        Node root = null;
        for(int i=10;i>0;i--){
            root = addNode(root,i);
        }
        //System.out.println("original list");
        //travellist(root);
        System.out.println();
        System.out.println("after reserse list");
        root = reverselist(root,3);
        travellist(root);
    }
}