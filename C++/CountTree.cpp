#include <iostream>
using namespace std;
class Tree{	
	static int height[0];
public:
	static int countBalanceTree(int h){		
		height[0]=height[1]=1;
		for(int i=2;i<=h;i++){
			height[i]=height[i-1]*(height[i-1]+2*height[i-2]);
		}
		return height[h];
	}
};
int Tree::height[];
int main(void){
	int h;
	cout<<"Enter height = ";
	cin>>h;
	cout<<(Tree::countBalanceTree(h))<<" Balanced Tree can be create of height "<<h<<endl;	
	return 0;
}