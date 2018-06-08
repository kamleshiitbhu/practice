#include<iostream>
using namespace std;
char* exp;
struct stack{
	int top;
	char st[200];
	stack(){
		top-1;
	}
};
int len(char *s){
	cout<<"debug 0";
	int l=0;
	while(s[l]!='\0')
		l++;
	return l;
}
char* postorder(stack s,int l){
	int	i=0; 	
	char *res=new char[l+1];
	cout<<"debug 1";
	int k=0;
	while(i<l){
	cout<<"debug 2";
		if(exp[i] == '+' || exp[i] == '-' || exp[i] == '*' || exp[i] == '/'){
			cout<<"debug 3";
			if(s.top==-1){
				cout<<"debug 4";
				s.top++;
				s.st[s.top]=exp[i];
				i++;
			}else{
				cout<<"debug 5";
				char c=s.st[s.top];
				if(exp[i] == '*' || exp[i] == '/'){
					s.top++;
					s.st[s.top]=exp[i];
					i++;
				}else{
					if(c == '*' || c == '/'){
						res[k]=c;
						k++;
						s.top--;	
					}
					while(s.top!=-1 && (c == '*' || c == '/')){
						res[k]=c;
						k++;
						s.top--;
					}
					s.top++;
					s.st[s.top]=exp[i];
					i++;					
				}
			}			
		}else{
			res[k]=exp[i];
			k++;
			i++;
		}
		cout<<"debug";
	}
	while(s.top!=-1){
		res[k]=exp[i];
		i++;
		k++;
		s.top--;
	}
	res[k]=='\0';
	return res;
} 
int main(void){
	exp=new char[201];
	cout<<"debug";
	cin>>exp;
	
	int l=len(exp);
	stack st;
	char *s=postorder(st,l);
	cout<<s;
	
}
