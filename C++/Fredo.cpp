#include <iostream>
using namespace std;
long long arr[1000000];
struct Node {
    long long key, val;
    Node* next;
    Node(long long key, long long val)
    {
        this->key = key;
        this->val = val;
    }
};
class HashMap {
private:
    int size;
    Node** map;
    long long hashCode(long long key);
 
public:
    HashMap(int size);
    ~HashMap();
    bool put(long long key, long long value);
    int get(long long key);
    bool remove(long long key);
    void reset();
};
HashMap::HashMap(int size)
{
    this->size = size;
    map = new Node*[size];
    for (int i = 0; i < size; i++) {
        map[i] = 0;
    }
}
HashMap::~HashMap()
{
    reset();
    delete map;
}
 
long long HashMap::hashCode(long long key)
{
    return key % size;
}
bool HashMap::put(long long key, long long value)
{
    long long k = hashCode(key);
    Node* curr;
    curr = map[k];
    while (curr != 0) {
        if (curr->key == key) {
            curr->val = value;
            return true;
        }
        curr = curr->next;
    }
    Node* head = new Node(key, value);
    head->next = map[k];
    map[k] = head;
    return false;
}
int HashMap::get(long long key)
{
    long long k = hashCode(key);
    Node* curr;
    curr = map[k];
    while (curr != 0) {
        if (curr->key == key) {
            return curr->val;
        }
        curr = curr->next;
    }
    return -1;
}
bool HashMap::remove(long long key)
{
    long long k = hashCode(key);
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
HashMap *map1=new HashMap(1000);
HashMap *map2=new HashMap(1000);
int main()
{
    int n,q;
    long long t,p;
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>arr[i];
        t=map1->get(arr[i]);
        if(t==-1){
            map1->put(arr[i],1);
        }else{
            map1->put(arr[i],t+1);
        }
    }   
    for(int i=0;i<n;i++){
        t=map1->get(arr[i]);
        p=map2->get(t);
        if(t==-1)
          map2->put(t,arr[i]);
    }    
    return 0;
}
