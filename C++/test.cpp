#include <iostream>
using namespace std;
int a, b ,c =0;
void fun_at_google(void);
int main(){
	static int a = 1;
	fun_at_google();
	a+=1;
	fun_at_google();
	cout<<"a = "<<a<<" b = "<<b<<endl;
}
void fun_at_google(void){
	static int a = 2;
	int b = 1;
	a+=++b;
	cout<<"a = "<<a<<" b = "<<b<<endl;
}