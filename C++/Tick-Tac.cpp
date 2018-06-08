#include <iostream>
#include <stdlib.h>
#include <time.h>   
#include <vector> 
using namespace std;
#define COMPUTER 'X'
#define PLAYER   'O'
class Box;
//class Player;
class Cell;
class Move;
/****************** class Move *****************/
class Move{
public:
	Move(int r,int c,char ch);
	int getRow();
	int getColumn();
	char getSymbol();
	void printMove();
private:
	int m_r,m_c;
	char m_ch;
};
void Move::printMove(){
	cout<<"row = "<<m_r<<" column = "<<m_c<<" symbol = "<<m_ch<<endl;
}
Move::Move(int r,int c,char ch){
	m_r = r;
	m_c = c;
	m_ch = ch;
}
int Move::getRow(){
	return m_r;
}
int Move::getColumn(){
	return m_c;
}
char Move::getSymbol(){
	return m_ch;
}
/**************** end  class Move ***********/

/**************** class Player ***************/
/*
class Player{
public:
	Player();
private:
	char *name;
};
*/
/************ end class Player *************/

/**************** class Cell ***************/
class Cell{
public:
	Cell(char ch);
	char getSymbol();
	void putSymbol(char ch);
private:
	char m_ch;
};
Cell::Cell(char ch){
	m_ch = ch;
}
char Cell::getSymbol(){
	return m_ch;
}
void Cell::putSymbol(char ch){
	m_ch = ch;
}

/**************** end class Cell ***************/

class Box{
public:
	Box();
	Box(int size);
	void printBox();
	bool playMove(Move move);
	void revertMove(Move move);
	int  getSize();
	bool isWin();
	char getSymbol(int r,int c);
private:
	vector< vector<Cell> > box;
	int m_size;
};
Box::Box(){
	Box(size);
}
Box::Box(int size){
	m_size=size;
	for(int i=0;i<m_size;i++){
		box.push_back(vector<Cell>());
		for(int j=0;j<m_size;j++){
			box.back().push_back(Cell('-'));
		}
	}
};
void Box::printBox(){
	for(int i=0;i<m_size;i++){
		for(int j=0;j<m_size;j++){
			cout<<box[i][j].getSymbol()<<"  ";
		}
		cout<<endl;
	}
	cout<<endl;
}
int Box::getSize(){
	return m_size;
}
bool Box::playMove(Move move){
	if(box[move.getRow()][move.getColumn()].getSymbol()!='-'){
		cout<<" Not valid move "<<endl;
		return false;
	}
	else{
		box[move.getRow()][move.getColumn()].putSymbol(move.getSymbol());
		return true;
	}
}
char Box::getSymbol(int r,int c){
	return box[r][c].getSymbol();
}

void Box::revertMove(Move move){
	box[move.getRow()][move.getColumn()].putSymbol('-');
}

bool Box::isWin(){	
	char ch = box[0][0].getSymbol();
	bool win = true;
	for(int i=0;i<m_size;i++){
		if(box[0][i].getSymbol() != ch || ch == '-'){
			win = false;
			break;
		}			
	}
	if(win){
		return win;
	}
	
	win = true;
	for(int i=0;i<m_size;i++){
		if(box[i][0].getSymbol() != ch || ch == '-'){
			win = false;
			break;
		}			
	}
	if(win){
		return win;
	}
	win = true;
	ch = box[m_size-1][m_size-1].getSymbol();
	for(int i=m_size-1;i>=0;i--){
		if(box[m_size-1][i].getSymbol() != ch || ch == '-'){
			win = false;
			break;
		}			
	}
	if(win){
		return win;
	}
	win = true;
	for(int i=m_size-1;i>=0;i--){
		if(box[i][m_size-1].getSymbol() != ch || ch == '-'){
			win = false;
			break;
		}			
	}
	if(win){
		return win;
	}	
	win = true;	
	ch = box[m_size / 2][m_size / 2].getSymbol();
	int r = 0,c = 0;
	for(int i=0;i<m_size;i++){
		if(box[r][c].getSymbol() != ch || ch == '-'){
			win = false;
			break;
		}
		r++;
		c++;
	}
	if(win){
		return win;
	}
	win = true;
	r = 0;
	c = m_size-1;
	for(int i=0;i<m_size;i++){
		if(box[r][c].getSymbol() != ch || ch == '-'){
			win = false;
			break;
		}
		r++;
		c--;
	}
	if(win){
		return win;
	}
	win = true;
	for(int i=0;i<m_size;i++){
		if(box[i][1].getSymbol() != ch || ch == '-'){
			win = false;
			break;
		}			
	}
	if(win){
		return win;
	}
	win = true;
	for(int i=0;i<m_size;i++){
		if(box[1][i].getSymbol() != ch || ch == '-'){
			win = false;
			break;
		}			
	}		
	return win;		
}

class Tick_Tac{
public:
	Tick_Tac(int size);
	Box *box;
	bool playMove(Move move);
	void revertMove(Move move);
	void printBox();
	int  getSize();
	Move getNextMove(char ch,int count);
    char revertSymbol(char ch);
    int playGame(char ch,int count);
private:
};
int Tick_Tac::playGame(char ch,int count){	
	if(box->isWin()){
		if(ch == PLAYER){			
			return -100;
		}else{
			return 100;
		}
	}
	bool draw = true;
	int result = -100000;
	bool isComputer = false;
	if(ch == COMPUTER){
		isComputer = true;
		result = 100000;
	}
	for(int i=0;i<getSize();i++){
		for(int j=0;j<getSize();j++){
			if(box->getSymbol(i,j)=='-'){
				draw = false;
				playMove(Move(i,j,ch));			
				if(isComputer){
					int r = playGame(revertSymbol(ch),count);					
					if(r < result){
						result = r;
					}
				}else{
					int r = playGame(revertSymbol(ch),count);
					if(r > result){
						result = r;
					}
				}
				revertMove(Move(i,j,ch));				
			}
		}
	}
	if(draw){
		return 0;
	}
	return result;
}
char Tick_Tac::revertSymbol(char ch){
	return (ch == PLAYER)?COMPUTER:PLAYER;
}
Tick_Tac::Tick_Tac(int size){
	box = new Box(size);
}
bool Tick_Tac::playMove(Move move){
	return box->playMove(move);
}
void Tick_Tac::revertMove(Move move){
	box->revertMove(move);
}
void Tick_Tac::printBox(){
	box->printBox();
}
int Tick_Tac::getSize(){
	box->getSize();
}
Move Tick_Tac::getNextMove(char ch,int count){
	int ret = -100000;
	int draw,win,lose;
	draw=win=lose=0;
	vector<Move> drawList;
	vector<Move> winList;
	vector<Move> loseList;
	bool isComputer = false;
	if(ch == COMPUTER){
		isComputer = true;
		ret = 100000;
	}
	int t = 0;
	int r = -1,c = -1;
	for(int i=0;i<getSize();i++){
		for(int j=0;j<getSize();j++){
			if(box->getSymbol(i,j)=='-'){
				playMove(Move(i,j,ch));									
				int result = playGame(revertSymbol(ch),count);						
				if(isComputer){
					if(result == -100){
						winList.push_back(Move(i,j,ch));
						win++;
					}else if(result == 0){
						drawList.push_back(Move(i,j,ch));
						draw++;
					}else if(result == 100){
						loseList.push_back(Move(i,j,ch));
						lose++;
					}else{
						cout<<"This is not possible something went wrong"<<endl;
					}
				}else{
					if(result == 100){
						winList.push_back(Move(i,j,ch));
						win++;
					}else if(result == 0){
						drawList.push_back(Move(i,j,ch));
						draw++;
					}else if(result == -100){
						loseList.push_back(Move(i,j,ch));
						lose++;
					}else{
						cout<<"This is not possible something went wrong"<<endl;
					}					
				}
				revertMove(Move(i,j,ch));
			}
		}
	}
	srand (time(NULL));
	if(win>0){
		int index = rand()%win;		
		return winList[index];
	}else if(draw>0){
		int index = rand()%draw;		
		return drawList[index];
	}else if(lose>0){
		int index = rand()%lose;
		return loseList[index];		
	}else{
		cout<<"This is not possible something went wrong"<<endl;
		return Move(-1,-1,'-');
	}	
}

int main(){
	Tick_Tac tick_tack = Tick_Tac(3);
	tick_tack.printBox();
	char ch = COMPUTER;
	int count = 1;
	bool noPlayer = true;
	bool result = false;
	while(true){		
		if(!noPlayer && ch == PLAYER){
			int r,c;
			cout<<"enter row and column ";
			cin>>r>>c;
			while(!tick_tack.playMove(Move(r,c,ch))){
				cout<<"enter row and column ";
				cin>>r>>c;
			}
			ch = COMPUTER;
			tick_tack.printBox();
		}
		else{
			Move move = tick_tack.getNextMove(ch,count);	
			tick_tack.playMove(move);				
			tick_tack.printBox();				
			ch = tick_tack.revertSymbol(ch);
		}
		count++;
		if(tick_tack.box->isWin()){
			result = true;
			if(ch == PLAYER){
				cout<<"Computer Win "<<endl;
			}else{
				cout<<"Player Win "<<endl;
			}
			break;
		}
		if(count>tick_tack.getSize() * tick_tack.getSize()){
			cout<<"Match draw"<<endl;
			break;
		}
	}
	tick_tack.printBox();
}