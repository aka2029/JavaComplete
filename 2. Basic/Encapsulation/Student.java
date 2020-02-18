public class Student {
    // variable declarations
    private int id; 
    private String name; 
    private String gender = "male";
	
	public String getName() {
	   return name;
	}
	
	public void setName(String name) {
	   this.name = name;
	}
	
	// Constructors
	public Student(int id, String name, String gender) {
	    this.id = id;
		this.name = name;
		this.gender = gender;
	}
	
    // method definitions
    public boolean updateProfile(String name) {
       this.name = name;
       return true;
    }
}