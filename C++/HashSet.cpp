struct Node{
    int val;
    Node *next;
    Node(int val){
        this->val=val;
    }
};
class HashSet{
private:
    Node **key;
    int size;
    HashSet(int size){
        this->size=size;
        key=new Node*[size];
        for(int i=0;i<size;i++){
            key[i]=0;
        }       
    }
    ~HashSet(){
        Node *next;
        for(int i=0;i<size;i++){
            if(key[i]!=0){
                Node *curr=key[i];
                while(curr!=0){     
                    next=curr.next;
                    delete(curr);
                    curr=next;
                }
                key[i]=0;
            }
        }
    }
    int hashCode(int value){
        return value%size;
    }
public:
    bool add(int value){
        int k=hashCode(value);
        Node *curr=key[k];
        while(curr!=0){
            if(curr->val==value){
                return true;
            }
            curr=curr->nextl
        }
        Node *head=new Node(value);
        head->next=key[k];
        key[k]=head;
        return false;       
    }
    bool remove(int value){
        int k=hashCode(value);
        Node *curr=key[k];
        if(curr->val==value){
            key[k]=key[k]->next;
            delete(curr);
            return true;
        }
        while(curr->next->val!=value){
            curr=curr->val;
        }
        Node *temp=curr->next;
        curr->next=temp->next;
        delete(temp);
        return true;
    }
};