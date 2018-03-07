struct Node {
    int key, val;
    Node* next;
    Node(int key, int val)
    {
        this->key = key;
        this->val = val;
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
    int get(key);
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
    Node* next;
    Node* curr;
    for (int i = 0; i < size; i++) {
        curr = map[i];
        while (curr != 0) {
            next = curr->next;
            delete (curr);
            curr = next;
        }
    }
    delete (map);
}

int HashMap::hashCode(int key)
{
    return key % size;
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
    head->next = map[i];
    map[i] = head;
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
    Node* curr = key[k];
    if (curr == 0)
        return false;
    if (curr->key == key) {
        map[k] = map[k]->next;
        delete (curr);
        return true;
    }
    while (curr->next != 0 && curr->next->key != key) {
        curr = curr->key;
    }
    if (curr->next == 0)
        return false;
    Node* temp = curr->next;
    curr->next = temp->next;
    delete (temp);
    return true;
}
void HashMap::reset(){
    Node* next;
    Node* curr;
    for (int i = 0; i < size; i++) {
        curr = map[i];
        while (curr != 0) {
            next = curr->next;
            delete (curr);
            curr = next;
        }
        map[i]=0;
    }
}
