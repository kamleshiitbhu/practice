import java.util.*;
import java.util.Random;
class Node{
	Integer value;
	int height;
	Node left,right;
	Node(int value,int height){
		this.value=value;
		this.height=height;
		left=right=null;
	}
}
public class AVLTree{
	Node root;
	AVLTree(){
		root=null;
	}
	int height(Node node){
		int l,r;
		l=r=0;
		if(node.left!=null)
			l=node.left.height;
		if(node.right!=null)
			r=node.right.height;		
		return l>r?l:r;
	}
	Node leftright(Node node){
		Node x,y,z;
		z=node;
		y=z.left;
		x=y.left;
		z.left=y.right;
		y.right=z;
		z.height=height(z)+1;
		y.height=height(y)+1;
		return y;
	}
	Node rightleft(Node node){
		Node x,y,z;
		z=node;
		y=z.right;
		x=y.right;
		z.right=y.left;
		y.left=z;
		z.height=height(z)+1;
		y.height=height(y)+1;
		return y;
	}
	Node insert(Node node,int value){
		if(node==null)
			return new Node(value,1);
		if(Integer.compare(node.value,value)>0)
			node.left=insert(node.left,value);
		else if(Integer.compare(node.value,value)<0)
			node.right=insert(node.right,value);
		else
			return node;
		node.height=height(node)+1;
		if(balance(node)>1){
			if(Integer.compare(value,node.left.value)>=0)
				node.left=rightleft(node.left);
			return leftright(node);
		}else if(balance(node)<-1){
			if(Integer.compare(value,node.right.value)<0)
				node.right=leftright(node.right);
			return rightleft(node);
		}
		return node;
	}
	void inorder(Node node){
		if(node!=null){
			inorder(node.left);
			System.out.print(node.value+" ");
			inorder(node.right);
		}
	}
	int balance(Node node){
		int l,r;
		l=r=0;
		if(node.left!=null)
			l=node.left.height;
		if(node.right!=null)
			r=node.right.height;
		return (l-r);
	}
	boolean isBinaryNode(Node node){
		if(node.left!=null){
			if(Integer.compare(node.left.value,node.value)>0)
				return false;
		}
		if(node.right!=null){
			if(Integer.compare(node.right.value,node.value)<0)
				return false;
		}
		return true;
	}
	boolean isAVLTree(Node node){
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
	Node minValueNode(Node node){
		Node pre=null;
		while(node!=null){
			pre=node;
			node=node.left;
		}
		return pre;
	}
	Node deleteNode(Node node,int value){
		if(node == null)
			return node;
		if(Integer.compare(node.value,value)>0)
			node.left=deleteNode(node.left,value);
		else if(Integer.compare(node.value,value)<0)
			node.right=deleteNode(node.right,value);
		else{
			if(node.left==null || node.right==null){
				Node temp=node.left==null?node.right:node.left;
				if(temp==null)
					node=null;				
			}else{
				Node temp=minValueNode(node.right);
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
	    if (b > 1 && balance(node.left) >= 0)
	        return leftright(node);
	 
	    // Left Right Case
	    if (b > 1 && balance(node.left) < 0)
	    {
	        node.left =  rightleft(node.left);
	        return leftright(node);
	    }
	 
	    // Right Right Case
	    if (b < -1 && balance(node.right) <= 0)
	        return rightleft(node);
	 
	    // Right Left Case
	    if (b < -1 && balance(node.right) > 0)
	    {
	        node.right = leftright(node.right);
	        return rightleft(node);
	    }
	    return node;	
	}
	boolean search(Node node,int value){
		if(node==null)
			return false;
		if(Integer.compare(node.value,value)==0)
			return true;
		if(Integer.compare(node.value,value)<0)
			return search(node.left,value);			
		else
			return search(node.right,value);		
	}
	public static void main(String args[]){		
		//System.out.println("1. insert element ");
		//System.out.println("2. print all elements ");
		Scanner sc=new Scanner(System.in);
		AVLTree tree=new AVLTree();
		int option;
		int value;
		boolean flag=true;
		Random rand = new Random();
		int MAX_NODE=100000;
		int MAX_TEST=100;
		int DEL_NODE=1000;
		int test=rand.nextInt(MAX_TEST);
		int t=1;
		System.out.println("      "+ test + " test running "+"      ");
		while((test--)>0){
			int count=0;
			int n=rand.nextInt(MAX_NODE);
			while((n--)>0){
				value = rand.nextInt(100000000);
				tree.root=tree.insert(tree.root,value);
			}
			n=rand.nextInt(DEL_NODE);
			while((n--)>0){
				value = rand.nextInt(100000000);
				if(tree.search(tree.root,value))
					count++;
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
		//tree.inorder(tree.root);
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