 #include<iostream>
using namespace std;
class Node{
public:
	int value;
	Node *left;
	Node *right;
	Node *father;
	int height;
	Node(int value){
		this->value=value;
		left=NULL;
		right=NULL;
		father=NULL;
	}
};
class AVLTree{
	Node *head;
	AVLTree(){
		head=NULL;
	}
	void leftrotate(Node *node){
		Node *l;
		Node *r;
		Node *x;
		Node *f=node.father;
		l=node.left;
		r=node.right;
		x=node.right.left;
		node.right=x;
		if(x!=NULL)
			x.father=node;
		r.left=node;
		node.father=r;
		if(f!=NULL){
			if(f.left==node){
				f.left=r;
			}else{
				f.right=r;
			}
		}
		/*
		while(node.father!=NULL){
			f=node.father;
			int a,b;
			a=b=0;
			if(!f.left)
				a=f.left.height;
			if(!f.right)
				b=f.right.height;
			f.height=a>b?a:b;
			node=f;
		}
		*/
		changeHeight(node);				
	}
	void rightrotate(Node *node){
		Node *l;
		Node *r;
		Node *x;
		Node *f=node.father;
		l=node.left;
		r=node.right;
		x=node.left.right;
		node.left=x;		
		if(x!=NULL){
			x.father=node;
		}
		l.right=node;
		node.father=l;
		if(f!=NULL){
			if(f.left==node){
				f.left=l;
			}else{
				f.right=l;
			}

		}
		/*
		while(node.father!=NULL){
			f=node.father;
			int a,b;
			a=b=0;
			if(!f.left)
				a=f.left.height;
			if(!f.right)
				b=f.right.height;
			f.height=a>b?a:b;
			node=f;
		}
		*/
		changeHeight(node);		
	}
	int balance(Node *node){
		int l,r;
		l=r=0;
		if(!node.left)
			l=node.left.height;
		if(!node.right)
			r=node.right.height;
		return l-r;
	}
	void changeHeight(Node *node){
		Node *f;
		while(node.father!=NULL){
			f=node.father;
			int a,b;
			a=b=0;
			if(!f.left)
				a=f.left.height;
			if(!f.right)
				b=f.right.height;
			f.height=a>b?a:b;
			node=f;
		}		
	}
	Node* insert(Node *head,int value){		
		if(head==NULL){
			Node *node=new Node(value);
			node.height=1;
			head=node;
			changeHeight(node);
			return node;
		}else{
			if(value>=head.value){
				head.right=insert(head.right,value);
				head.right.father=head;
				int balance=balance(head);
				if(balance==1){
					if(balance(head.left)==-1){
						leftrotate(head.left);
					}
					rightrotate(head);
				}else if(balance==-1){
					if()
				}			
			}else{
				head.left=insert(head.left,value);
				head.left.father=head;				
			}
		}
		
	}
};