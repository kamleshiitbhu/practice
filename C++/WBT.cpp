#include <stdio.h>
#include <malloc.h>
#include <string.h>
#include <iostream>
#include <fstream>
#include <cstring>
#include <cstddef>

using namespace std ;
#define  NVME_SFR_BASE (char*)malloc(100)
bool pauseController(){
	return true;
}
bool resumeController(){
	return true;
}
class Global{
private:
	static Global *global;
public:
	static Global* getInstance(){
		if(global == NULL){
			global = new Global();
		}
		return global;
	}
	void showOption(){
		printf("1. Enter for reset\n");
		printf("2. Enter for load state\n");
		printf("3. Enter for WBT\n");
		printf("4. Enter for Exit\n");
	}
};
class WBT{
private:
	static WBT *wbt;
public:
	static WBT* getInstance(){
		if(wbt == NULL){
			wbt = new WBT();
		}
		return wbt;
	}
	void changeBytes(){
		while(!pauseController());
		char *start;
		char *value;
		size_t length;
		int temp;
		printf("Enter base address in decimal: ");
		scanf("%d",&temp);
		start=(char*)(temp + NVME_SFR_BASE);
		printf("Enter No. of bytes you want to change in decimal: ");
		scanf("%d",&temp);	
		length = (size_t)temp;
		printf("Enter data till %d length\n",temp);
		value = (char*)malloc(length+1);
		for(size_t i=0;i<=length;i++){
			scanf("%c",&value[i]);
		}
		value++;
		memcpy(start,value,length);
		printf("data copied successfully\n");		
		printf("data after copy\n");
		for (int i = 0; i < length; i++){
			printf("%c",start[i]);
		}
		printf("\n\n\n");	
		while(!resumeController());	
	}
	void changeBit(void *start,int value){

	}
	void readFile(){
		ifstream inFile;
		ofstream outFile;
		size_t size = 0; // here

		inFile.open( "read.bat", ios::in|ios::binary|ios::ate );
		char* oData = 0;
		
		inFile.seekg(0, ios::end); // set the pointer to the end
		size = inFile.tellg() ; // get the length of the file
		//cout << "Size of file: " << size;
		inFile.seekg(0, ios::beg); // set the pointer to the beginning

		oData = new char[ size+1 ]; //  for the '\0'
		inFile.read( oData, size );
		oData[size] = '\0' ; // set '\0' 
		//cout << " oData size: " << strlen(oData) << "\n";
		outFile.open( "write.txt", ios::out|ios::binary|ios::ate );
		outFile.write( oData, size );
		//for ( size_t i = 0; i < strlen(oData); i++ )
		//{
		//	cout <<oData[i];
		//}
		outFile.close();
  		inFile.close();
		cout << "\n\n";
	}
	void showOption(){
		printf("0. Enter for previous menu\n");		
		printf("1. Enter for change SFR\n");
		printf("2. Enter for change single bit\n");
	}
};
Global* Global::global=NULL;
WBT* WBT::wbt=NULL;
int main(){
	WBT *wbt=WBT::getInstance();
	Global *global=Global::getInstance();
	global->showOption();
	int op=-1;
	while(1){
		printf("Enter any option for Global control\n");
		scanf("%d",&op);
		switch(op){
			case 1:
				printf("Feature is not supported yet\n");
				break;
			case 2:
				printf("Feature is not supported yet\n");
				break;
			case 3:
			    wbt->showOption();
				while(op!=0){
					printf("Enter any option for WBT\n");
					scanf("%d",&op);
					switch(op){
						case 1:
							wbt->readFile();
							break;
						case 2:
							printf("Feature is not supported yet\n");
							break;
						case 0:							
							break;							
						default:
							printf("Enter any valid option\n");					
					}					
				}
				break;
				case 4:
					printf("Bye Bye!!\n");
					return 0;
				default:
					printf("Enter any valid option\n");				

		}
	}
}