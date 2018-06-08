#include <iostream>
using namespace std;
char str[100001];
int p[32];
int arr[100000];
struct Node {
    int key, val;
    Node* next;
    Node(int key, int val)
    {
        this->key = key;
        this->val = val;
    }
    ~Node(){
        next=NULL;
    }
};
class HashMap {
private:
    int size;
    Node** map;
    int hashCode(int key);
 
public:
    HashMap(int size);
    ~HashMap();
    bool put(int key, int value);
    int get(int key);
    bool remove(int key);
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
 
int HashMap::hashCode(int key)
{
	int hash=key%size;
	if(hash<0)
		hash=(hash+size)%size;
    return hash;
}
bool HashMap::put(int key, int value)
{
    int k = hashCode(key);
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
int HashMap::get(int key)
{
    int k = hashCode(key);
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
bool HashMap::remove(int key)
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
HashMap *map=new HashMap(1000);

int max(int a,int b){
	return a>b?a:b;
}

int main()
{
    int n;
    cin>>n;
    cin>>str;
	int m=0;
	int max_len=-1;
	for(int i=0;i<n;i++){
		if(str[i]=='1'){
			arr[i]=1;
		}else if(str[i]=='0'){
			arr[i]=-1;
		}
	}
	for(int i=0;i<n;i++)
		if(str[i]=='x')
			p[m++]=i;
	for(int i=1<<m;i>0;i--){
		int x=i;
		for(int j=0;j<m;j++){
			if((x&1)==1){
				arr[p[j]]=1;
			}else{
				arr[p[j]]=-1;
			}
			x=x>>1;
		}
		int sum=0;
		int t;
		for(int j=0;j<n;j++){
			sum=sum+arr[j];
			if(sum==0){
				max_len=max(max_len,j+1);
			}else{
				t=map->get(sum);
				if(t!=-1){
					max_len=max(max_len,j-t);
					//cout<<i<<" "<<t<<\n;
				}else{
					map->put(sum,j);
				}
			}			
		}
		//cout<<max_len<<"\n";
	}
	cout<<max_len<<"\n";
    return 0;
}
