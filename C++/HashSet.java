class MapNode<T>{
	T key;
	MapNode<T> next;
	MapNode(T node){
		key = node;
		next = null;
	}
}
public class HashSet<T>{
	int size;
	MapNode<T> map[];
	HashSet(int size){
		this.size = size;
		map = new MapNode[size];
		for(int i=0;i<size;i++)
			map[i]=null;
	}
	HashSet(){
		this.size = 1000;
		map = new MapNode[size];
		for(int i=0;i<size;i++)
			map[i]=null;		
	}
	boolean put(T node){
		int key = (node.hashCode()%size + size)%size;				
			MapNode<T> temp = map[key];
			while(temp!=null){;
				if(temp.key.equals(node)){
					return false;
				}
				temp = temp.next;
			}
			temp = map[key];
			map[key] = new MapNode<T>(node);
			map[key].next=temp;
			return true;
	}
	T get(T node){
		int key = (node.hashCode()%size + size)%size;
		MapNode<T> temp = map[key];
		while(temp!=null){
			if(temp.key.equals(node)){
				return temp.key;
			}
			temp = temp.next;
		}
		return null;		
	}
	boolean remove(T node){
		int key = (node.hashCode()%size + size)%size;
		MapNode<T> temp = map[key];
		MapNode<T> pre = null;
		while(temp!=null){
			if(temp.key.equals(node)){
				break;
			}
			pre = temp;
			temp = temp.next;
		}
		if(temp!=null){
			if(pre==null){
				map[key]=map[key].next;
			}else{
				pre.next=pre.next.next;
			}
			return true;
		}
		return false;
	}
}