#include <iostream>
using namespace std;
class GenericType{
public:
	virtual int hashCode()=0;
	virtual bool equals(GenericType *obj)=0;
	virtual ~GenericType(){
	//	cout<<"calling GenericType destructor"<<endl;
	}
};
class Student:public GenericType{
public:
	int id;
	Student(int id){
		this->id = id;
	}
	int hashCode(){
		return id;
	}
	bool equals(GenericType *obj){
		Student *st = (Student*)obj;
		return (st->id == id);
	}
	void toString(){		
		cout<<"Student id = "<<id<<endl;
	}
	~Student(){
		//cout<<"calling Student destructor"<<endl;
	}
};
class Node{
public:
	GenericType *value;
	Node *next;
	Node(GenericType *value){
		this->value = value;
		this->next = 0;
	}
	~Node(){
		if(value!=0)
			delete value;
	}
};
class HashMap{
private:
	int size;
	Node **node;
public:
	HashMap(int size){
		this->size = size;
		node = new Node*[size];
		for(int i=0;i<size;i++)
			node[i]=0;
	}
	bool put(GenericType *obj){
		int index = (obj->hashCode()%size + size)%size;
		Node *temp=node[index];
		while(temp!=0){
			if(temp->value->equals(obj)){
				temp->value = obj;
				return false;
			}
			temp = temp->next;
		}
		temp = new Node(obj);
		temp->next = node[index];
		node[index] = temp;
		return true;
	}
	GenericType* get(int id){
		Student *st  = new Student(id);
		int index = (st->hashCode()%size + size)%size;
		Node *temp = node[index];
		while(temp!=0){
			if(temp->value->equals(st)){
				return temp->value;
			}
			temp = temp->next;
		}
		return 0;
	}
	bool remove(int id){
		Student *st  = new Student(id);
		int index = (st->hashCode()%size + size)%size;
		Node *temp = node[index];
		Node *pre = 0;
		while(temp!=0){
			if(temp->value->equals(st)){
				break;
			}
			pre = temp;
			temp = temp->next;
		}
		if(temp!=0){
			if(pre == 0){
				node[index] = node[index]->next;
			}else{
				pre->next = temp->next;
			}
			delete temp;
		}
	}
};
class File:public GenericType{
public:
	int id;
	int pid;
	long o_size;
	long c_size;
	File(int id,int pid,int size){
		this->id = id;
		this->pid = pid;
		this->o_size = this->c_size = size;
	}
	int hashCode(){
		return id;
	}
	bool equals(GenericType *obj){
		File *file = (File*)obj;
		return (file->id == id);
	}
};
HashMap *map = new HashMap(1000);
HashMap *listMap = new HashMap(1000);
class List:public GenericType{
public:
	int id;
	List *next;
	List(int id){
		this->id = id;
		this->next = 0;
	}
	~List(){
		
	}
	int hashCode(){
		File *file = (File*)map->get(id);
		return file->id;
	}
	bool equals(GenericType *obj){
		return true;
	}	
};
int total_size = 0;
int total_file = 0;

void increaseSize(int id,int size){
	File *file = (File*)map->get(id);
	int pid = file->pid;
	total_size = total_size + size;
	while(pid!=-1){
		file = (File*)map->get(pid);
		file->c_size = file->c_size + size;
		pid = file->pid;
	}
}
int put(int id,int pid,int size){
	File *file = new File(id,pid,size);
	map->put(file);
	List *list = listMap->get(id);
	if(list==0){
		listMap->put(new List(id));
	}else{
		List *temp = new List(id);
		temp->next = list->next;
		list->next = temp;
	}
	list->put(list);
	list
	if(size>0){
		increaseSize(id,size);
	}
	file = (File*)map->get(pid);
	return file->c_size;
}
void infectFile(int id,int size)
{
	file = (File*)map->get(pid);
	if(file->o_size>0){
		increaseSize(file->id,size);
	}else{
		List *list = listMap->get(id);
		while(list!=0){
			infectFile(list->id);
			list = list->next;
		}
	}
}
void removeFile(int id)
{
	File *file = (File*)map->get(id);
	if(file->o_size>0){
		increaseSize(id,file->c_size);
		List *list = listMap->get(id);
		List *pre=0;
		while(list!=0){
			if(list->id==id)
				break;
			pre = list;
			list = list->next;
		}
		if(pre==0){
			if(list->next==0)
				mapNode->remove(id);
			else{
				list->id = list->next->id;
				pre = list;
				list = list->next;
				pre->next = list->next;
				delete list;
			}
		}else{
				pre->next = list->next;
				delete list;			
		}
		map->remove(id);
	}else
	{
		List *list = listMap->get(id);
		List *pre=0;
		while(list!=0){
			if(list->id==id)
				break;
			pre = list;
			list = list->next;
		}
		if(pre==0){
			if(list->next==0)
				mapNode->remove(id);
			else{
				list->id = list->next->id;
				pre = list;
				list = list->next;
				pre->next = list->next;
				removeFile();
			}
		}else{
				pre->next = list->next;
				
	}
}
int main(){
	Student *st = new Student(10);
	map->put(st);
	
}