#include <iostream>
using namespace std;
class demo{
public:
	int a;
	void display(){
		cout<<"this is display function"<<endl;		
	}
};
int main(void){
	demo *obj = 0;
	obj->display();
	cout<<&demo::display<<" hjjhh";
}