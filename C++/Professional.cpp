#define NULL 0
#define MAX_NODE 1000
#define MAX_DIRECTORY 1000
class File{
public:
	int id; //id of current file or directory
	int p_id; //id of parent of current file of directory
	int c_id; // i of first children
	int o_size; //orifinal size
	int c_size;//current size
	File *f_next;
	File *g_next;
	File()
	{
		id = p_id = c_id = o_size = c_size = -1;
		f_next = NULL;
		g_next = NULL;
	}
	void fillInfo(int id,int p_id,int size){
		this->id = id;
		this->p_id = p_id;
		this->o_size = this->c_size = size;
		this->c_id = -1;
		this->f_next = NULL;
		this->g_next = NULL;
	}
};
class Node{
public:
	int key;
	File *value;
	Node *n_next;
	Node *g_next;
	Node(){
		this->key = -1;
		this->value = NULL;
		this->n_next = NULL;
		this->g_next = NULL;
	}
	void fillInfo(int key,File *value){
		this->key = key;
		this->value = value;
		this->n_next = NULL;
		this->g_next = NULL;
	}
};
Node *g_node[MAX_NODE];
File *g_file[MAX_DIRECTORY];
Node *node_head = NULL;
File *file_head = NULL;
void initPool(){
	g_node[0] = new Node();
	for(int i=1;i<MAX_NODE;i++){
		g_node[i] = new Node();
		g_node[i-1]->g_next = g_node[i];
	}
	node_head = g_node[0];
	g_file[0] = new File();
	for(int i=1;i<MAX_DIRECTORY;i++){
		g_file[i] = new File();
		g_file[i-1]->g_next = g_file[i];
	}
	file_head = g_file[0];
}
File* getFile(){
	File *ret = file_head;
	file_head = file_head->g_next;
	return ret;
}
void removeFile(File *file){
	file->fillInfo(-1,-1,-1);
	file->g_next = file_head;
	file_head = file;
}
Node* getNode(){
	Node *ret = node_head;
	node_head = node_head->g_next;
	return ret;
}
void removeNode(Node *node){
	if(node->value!=NULL){
		removeFile(node->value);
	}
	node->fillInfo(-1,NULL);
	node->g_next = node_head;
	node_head = node;
}
class HashMap{
	int size;
	Node **node;
	HashMap(int size){
		this->size = size;
		node = new Node*[size];
		for(int i=0;i<size;i++)
			node[i]=NULL;
	}
	int put(int id,N)
};
int main(){
	return 0;
}