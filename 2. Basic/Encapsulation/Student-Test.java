class StudentTest {
    
	public static void main(String[] args) {
	    //int[] studentIds = new int[] {1001, 1002, 1003};
	
	    // Creating first student object and setting its state
	    Student student1 = new Student("joan", "male");
		
		// Creating second student object and setting its state
		Student student2 = new Student("raj", "male");
		
		// Creating third student object and setting its state
		Student student3 = new Student("anita", "female");
		
		// Print each students name
		System.out.println("Name of student1: " + student1.getName());
		System.out.println("Name of student2: " + student2.getName());
		System.out.println("Name of student3: " + student3.getName());
		
		student1.setName("john");
		System.out.println("Updated name of student1: " + student1.getName());
		
		System.out.println("# students created so far: " + Student.getStudentCount());
	}
}