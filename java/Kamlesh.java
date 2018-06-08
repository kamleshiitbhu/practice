import java.util.*;
class Column{
	String columnname;
	String type;
	boolean require;
	boolean repeat;
	Column(){
		
	}
	boolean isValid(Object column,HashMap<String,Schema> map) {
		try {
			if(type.equals("String")) {
				String s = (String)column;
			}else if(type.equals("Integer")) {
				Integer c =(Integer)column;
			}else if(type.equals("Boolean")) {
				Boolean b = (Boolean)column;
			}else if(type.equals("Character")) {
				Character ch = (Character)column;
			}else if(type.equals("Date")) {
				
			}else {
				if(!map.get(type).isValid(column,map)) {
					return false;
				}
			}
		}catch (ClassCastException e) {
			return false;
		}
		return true;
	}
	
}
class Date{
	String date;
	boolean isValid() {
		String s[] = date.split("/");
		if(s.length!=3)
			return false;
		int d,m,y;
		try {
			d = Integer.parseInt(s[0]);
			m = Integer.parseInt(s[1]);
			y = Integer.parseInt(s[3]);
		}catch (NumberFormatException e) {
			return false;
		}
		if(d<1 || d>30)
			return false;
		if(m<1 || m>12)
			return false;
		if(y<1)
			return false;
		return true;
	}
}
class Schema{
	ArrayList<Column> list;
	String name;
	Schema(Scanner sc,String name)
	{
		list = new ArrayList<>();
	}
	boolean isValid(Object column,HashMap<String, Schema> sh) {
		HashMap<String,Object> map = (HashMap<String, Object>)column;
		for(int i=0;i<list.size();i++) {
			Column c = list.get(i);
			if(!c.isValid(map.get(c.type),sh)) {
				return false;
			}
		}
		return true;
	}
}
public class Flipkart{
	static boolean isValid(Object column,HashMap<String, Schema> sh,String type) {
		if(!sh.get(type).isValid(column, sh)) {
			return false;
		}
		return false;
	}
	public static void main(String[] args) {
		Object obj= ""; 
	}
}