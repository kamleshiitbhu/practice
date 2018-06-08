#include <iostream>
using namespace std;
class Node{
public:
  int data;
  Node *left;
  Node *right;
  Node(int data){
    this->data=data;
    this->left=0;
    this->right=0;
    //cout<<"left = "<<left<<" "<<"right = "<<right<<endl;
  }
};
class Stack{
public:
  Node **a;
  int top;
  int size;
  Stack(int size){
    this->size=size;
    a=new Node*[size];
    top=-1;
  }
  void push(Node *data){
    a[++top]=data;
  }
  Node* pop(){
    Node* data=a[top];
    --top;
    return data;
  }
  Node* peek(){
    return a[top];
  }
  bool isempty(){
    return (top==-1);
  }
};
void inorder(Node *q,int k){
  Stack *st = new Stack(100);
  Node *root=q;
  while(root){
    st->push(root);
    root=root->left;
  }
  while(!st->isempty() && (root=st->pop())){
    if(!(--k)){
      cout<<root->data<<" ";
      break;
    }
    if(root->right){
      root=root->right;
      while(root){
        st->push(root);
        root=root->left;
      }
    }
  }
}
int main(void){
  Node *root=new Node(20);
  root->left=new Node(8);
  root->right=new Node(22);
  root->left->left=new Node(4);
  root->left->right=new Node(12);
  root->left->right->left=new Node(10);
  root->left->right->right=new Node(14);
  inorder(root,3);
  return 0;
}
