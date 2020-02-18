public class Student {
    // variable declarations	
	private static int studentCount;
	
	private static int idInitializer = 1000;
    private final int id; 
    private String name; 
    private String gender = "male";
	
	public String getName() {
	   return name;
	}
	
	public void setName(String name) {
	   this.name = name;
	}
	
	public static int getStudentCount() {
	    return studentCount;
	}
	
	// Constructors
	public Student(String name, String gender) {
	    this.name = name;
		this.gender = gender;
		
		id = ++idInitializer;
		studentCount++;
		System.out.println("ID of " + name + " is " + id);
	}
	
    // method definitions
    public boolean updateProfile(String name) {
	   this.name = name;
       return true;
    }
}