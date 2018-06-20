import java.util.Scanner;
class Student{
	Integer roll_no;
	String name;
	Student(int roll_no,String name){
		this.roll_no=roll_no;
		this.name=name;
	}
	 public boolean equals(Object obj){
	 	Student st = (Student)obj;		
		if(roll_no.equals(st.roll_no) && name.equals(st.name)){
			return true;
		}
		return false;
	}
	public String toString(){
		return roll_no + " " + name;
	}

	public int hashCode(){
		return	roll_no;
	}
}
class Main{
	public static void main(String[] args){
		HashSet<String> set = new HashSet(1000);
		System.out.println(set.put("kamlesh"));
		System.out.println(set.put("kamlesh"));
	}
}
