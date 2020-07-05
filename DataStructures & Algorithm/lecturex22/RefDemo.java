package lecturex22;

class Student {
	int rollno;
	String name;

	Student(int rollno, String name) {
		this.rollno = rollno;
		this.name = name;
	}

	@Deprecated
	void show() {

	}

	@Override
	public int hashCode() {
		return 10;
	}

	@Override
	public String toString() {
		return "RollNo is " + rollno + " Name " + name;
	}
}

public class RefDemo {

	public static void main(String[] args) {
		Student ram = new Student(1001, "Ram");
		Student ram2 = new Student(1001, "Ram");
		System.out.println(ram == ram2);
		System.out.println(ram.toString());
		System.out.println(ram2);
		System.out.println(ram.hashCode());
		System.out.println(ram2.hashCode());

		// TODO Auto-generated method stub
		String a = new String("Amit");
//		String b = new String("Amit");
//		System.out.println(a==b);
		System.out.println(a.hashCode());
//		System.out.println(b.hashCode());
//		System.out.println(a.toString());
//		System.out.println(b.toString());

	}

}
