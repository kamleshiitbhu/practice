class Main{
	int req[];
	int p[][];
	int head;
	int tail;
	void init(int track_size){
		req=new int[track_size];
		p=new int[track_size][4];
		for(int i=0;i<track_size;i++){
			p[track_size][0]=-1;
			p[track_size][1]=-1;
			p[track_size][2]=-1;
			p[track_size][3]=0;
		}
	}
	void request(int r){
		req[tail]=r;
		if(tail	==	track_size	-	1){
			tail=0;
		}else{
			tail++;
		}
	}
	int fcfs(){
		
	}
	public static void main(String[] args){

	}
}