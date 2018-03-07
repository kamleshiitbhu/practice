#include<iostream>
using namespace std;
class Node{	
	public:
		int data;
		Node* left;
		Node *right;
		Node(int data){
			this->data=data;
			left=NULL;
			right=NULL;
		}
};
class Tree{
	public:
		Tree(){
		}
		Node* insert(Node* root,int data){
			if(root==NULL){
				return new Node(data);
			}
			if((root->data)>data){
				root->left=insert(root->left,data);
			}else{
				root->right=insert(root->right,data);
			}
		}
		void inorder(Node *root){
			if(root!=NULL){
				inorder(root->left);
				cout<<root->data<<" ";
				inorder(root->right);
			}
		}
		Node* remove(Node *root,int data){
			if(root==NULL){
				return NULL;
			}
			if(root->data	==	data){
				if(root->left==NULL){
					Node *temp=root->right;
					delete(root);
					return temp;
				}
				if(root->left->right	=	NULL){
					Node *r=root->right;
					Node *l=root->left;
					l->right=r;
					delete(root);
					return l;
				}				
				Node *f=root->left;
				Node *c=root->left->right;
				while(c->left!=NULL	||	c->right!=NULL){
					if(c->right){
						f=c;
						c=c->left;
					}else{
						f=c;
						c=c->right;
					}
				}
				root->data=c->data;
				if(f->left==c){
					f->left=NULL;
				}else{
					f->right=NULL;
				}
				delete(c);
				return root;				
			}
			if((root->data)>data){
				root->left=remove(root->left,data);
			}else{
				root->right=remove(root->right,data);
			}
		}
};
Node *head=NULL;
int main(void){	
	cout<<"1. Insert any number \n";
	cout<<"2. print current tree\n";
	cout<<"3. remove any number\n";
	int option,data;
	Tree t;
	while(1){
		cout<<"-----Enter any option-----\n\n";
		cin>>option;
		switch(option){
			case 1:
				cout<<"Enter data you want insert: ";
				cin>>data;
				head=t.insert(head,data);
				cout<<"-----data insert successfully-----\n\n";
				break;
			case 2:
				cout<<"-----complete Tree------\n";
				t.inorder(head);
				cout<<"\n\n";
				break;
			case 3:
				cout<<"Enter data you want remove: ";
				cin>>data;
				t.remove(head,data);
				cout<<"-----data remove successfully-----\n\n";
				break;
			default:
				cout<<"Enter any valid option\n\n";
		}
	}
}
