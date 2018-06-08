#include<iostream>
using namespace std;
int findTime(int D,int H,int M){
	int result=0;
	int currDay,currHour,currMin;
	if(D==11){
		if(H==11){
			if(M>11)
				result=M-11;
		}
		else if(H>11){
			result=result+49;
			currHour=12;
			while(currHour<H){
				result=result+60;
				currHour++;
			}
			result=result+M;
		}
		else
			result=-1;
	}else{
		result=result+49+12*60;
		currDay=12;
		while(currDay<D){
			result=result+24*60;
			currDay++;
		}
		result=result+H*60+M;
	}
	return result;
}
int main(){
	cout<<"Enter Day, Hour and Minutes By space separated"<<endl;
	int D,H,M;
	cin>>D>>H>>M;
	int result=findTime(D,H,M);
	cout<<"result = "<<result<<endl;
}