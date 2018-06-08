#include<iostream>
using namespace std;
struct Test{
	unsigned int a;
	unsigned int b;
	unsigned int i;
	unsigned short c;
	unsigned short d;
	unsigned int e;
	unsigned char f;
	unsigned char g;
	unsigned short h;
};
int main(void){
int size=sizeof(Test);
cout<<size;
}
