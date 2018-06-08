void function2(){
	int b = 10;
}
void function(){
	int a = 10;
	function2(); 
}
int main(){
	function();
	return 0;
}
