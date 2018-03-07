import java.util.*;
import java.util.Random;
class Node<T extends Integer>{
	T value;
	int height;
	Node left,right;
	Node(T value,int height){
		this.value=value;
		this.height=height;
		left=right=null;
	}
}
class AVLTree<T extends Integer>{
	Node<T> root;
	AVLTree(){
		root=null;
	}
	int height(Node<T> node){
		int l,r;
		l=r=0;
		if(node.left!=null)
			l=node.left.height;
		if(node.right!=null)
			r=node.right.height;		
		return l>r?l:r;
	}
	Node<T> leftright(Node<T> node){
		Node<T> x,y,z;
		z=node;
		y=z.left;
		x=y.left;
		z.left=y.right;
		y.right=z;
		z.height=height(z)+1;
		y.height=height(y)+1;
		return y;
	}
	Node<T> rightleft(Node<T> node){
		Node<T> x,y,z;
		z=node;
		y=z.right;
		x=y.right;
		z.right=y.left;
		y.left=z;
		z.height=height(z)+1;
		y.height=height(y)+1;
		return y;
	}
	Node<T> insert(Node<T> node,T value){
		if(node==null)
			return new Node<T>(value,1);
		if(T.compare(node.value,value)>0)
			node.left=insert(node.left,value);
		else if(T.compare(node.value,value)<0)
			node.right=insert(node.right,value);
		else
			return node;
		node.height=height(node)+1;
		if(balance(node)>1){
			if(T.compare(value,node.left.value)>=0)
				node.left=rightleft(node.left);
			return leftright(node);
		}else if(balance(node)<-1){
			if(T.compare(value,node.right.value)<0)
				node.right=leftright(node.right);
			return rightleft(node);
		}
		return node;
	}
	void inorder(Node<T> node){
		if(node!=null){
			inorder(node.left);
			System.out.println(node.value+" ");
			inorder(node.right);
		}
	}
	int balance(Node<T> node){
		int l,r;
		l=r=0;
		if(node.left!=null)
			l=node.left.height;
		if(node.right!=null)
			r=node.right.height;
		return (l-r);
	}
	boolean isBinaryNode(Node<T> node){
		if(node.left!=null){
			if(T.compare(node.left.value,node.value)>0)
				return false;
		}
		if(node.right!=null){
			if(T.compare(node.right.value,node.value)<0)
				return false;
		}
		return true;
	}
	boolean isAVLTree(Node<T> node){
		if(node==null)
			return true;
		if(balance(node)<=1 && balance(node) >=-1){
			if(isBinaryNode(node)){
				if(isAVLTree(node.left) && isAVLTree(node.right))
					return true;
			}
		}		
		return false;
	}
	Node<T> minValueNode(Node<T> node){
		Node<T> pre=null;
		while(node!=null){
			pre=node;
			node=node.left;
		}
		return pre;
	}
	Node<T> deleteNode(Node<T> node,T value){
		if(node == null)
			return node;
		if(T.compare(node.value,value)>0)
			node.left=deleteNode(node.left,value);
		else if(T.compare(node.value,value)<0)
			node.right=deleteNode(node.right,value);
		else{
			if(node.left==null || node.right==null){
				Node<T> temp=node.left==null?node.right:node.left;				
					return temp;			
			}else{
				Node<T> temp=minValueNode(node.right);
				node.value=temp.value;
				node.right=deleteNode(node.right,temp.value);
			}
		}
		if(node==null)
			return null;
		node.height=height(node)+1;

	    int b = balance(node);
	 
	    // If this node becomes unbalanced, then there are 4 cases
	 
	    // Left Left Case
	    if (b > 1 && balance(node.left) >=-1)
	        return leftright(node);
	 
	    // Left Right Case
	    if (b > 1 && balance(node.left) < -1)
	    {
	        node.left =  rightleft(node.left);
	        return leftright(node);
	    }
	 
	    // Right Right Case
	    if (b < -1 && balance(node.right) <= 1)
	        return rightleft(node);
	 
	    // Right Left Case
	    if (b < -1 && balance(node.right) > 1)
	    {
	        node.right = leftright(node.right);
	        return rightleft(node);
	    }
	    return node;	
	}
	boolean search(Node<T> node,T value){
		if(node==null)
			return false;
		//System.out.println(T.compare(node.value,value) + " " +value +" "+ node.value);
		if(T.compare(node.value,value)<0)
			return search(node.right,value);			
		else if(T.compare(node.value,value)>0)
			return search(node.left,value);		
		else
			return true;
	}
	public static void main(String args[]){		
		//System.out.println("1. insert element ");
		//System.out.println("2. print all elements ");
		Scanner sc=new Scanner(System.in);
		AVLTree<Integer> tree=new AVLTree<Integer>();
		int option;
		Integer value;
		boolean flag=true;
		Random rand = new Random();
		int MAX_VALUE=10000;
		int MAX_NODE=10;
		int MAX_TEST=200;
		int DEL_NODE=100000;
		int test=rand.nextInt(MAX_TEST)+1;
		int t=1;
		System.out.println("      "+ test + " test running "+"      ");
		while((test--)>0){
			int count=0;
			tree.root=null;
			int n=rand.nextInt(MAX_NODE+1);
			//System.out.println(n +" node will inserted ");
			while((n--)>0){
				value = rand.nextInt(MAX_VALUE+1);
				//System.out.println(n);
				tree.root=tree.insert(tree.root,value);
			}
			//tree.inorder(tree.root);
			//System.out.println();
			n=rand.nextInt(DEL_NODE+1);
			while((n--)>0){
				value = rand.nextInt(MAX_VALUE+1);
				if(tree.search(tree.root,value)){
					//tree.inorder(tree.root);
					//System.out.println();
					//System.out.println(value + " found");
					count++;
				}
				tree.root=tree.deleteNode(tree.root,value);
			}
			System.out.println(t + ": "+count + " node deleted from tree ");			
			t++;
			if(!tree.isAVLTree(tree.root)){
				flag=flag&false;				
			}
		}
		if(flag){
			System.out.println("      " + "this tree is AVL tree " + "      ");
		}else{
			System.out.println("this tree is not AVL tree ");
		}
		//System.out.println(tree.root.value);
		//tree.inorder(tree.root);
		System.out.println();
		/*
		while(true){
			System.out.println("Enter any option ");
			option=sc.nextInt();
			switch(option){
				case 1:
					System.out.print("Enter elemrnt : ");
					value=sc.nextInt();
					tree.root=tree.insert(tree.root,value);
					System.out.println("succesfully inserted");
					break;
				case 2:
					tree.inorder(tree.root);
					System.out.println();
					break;
				default:
					System.out.println("Enter any valid option ");
			}			
		}
		*/
	}
}