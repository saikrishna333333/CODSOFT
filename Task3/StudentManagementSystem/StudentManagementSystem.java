package StudentManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String DateOfBirth;
    private String gender;
    private String grade;

    public Student(String name, int rollNumber,String DateOfBirth,String gender, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.DateOfBirth=DateOfBirth;
        this.gender=gender;
        this.grade = grade;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getDateOfBirth() {
		return DateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNumber=" + rollNumber + ", DateOfBirth=" + DateOfBirth + ", gender="
				+ gender + ", grade=" + grade + "]";
	}
    
}//end of POJO class

class StudentOperations {
    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent() {
    	try {
    		 System.out.print("Enter student name: ");
    	        String name = scanner.nextLine();

    	        System.out.print("Enter roll number: ");
    	        int rollNumber = Integer.parseInt(scanner.nextLine());
    	        
    	        System.out.print("Enter dateofbirth: ");
    	        String dateofbirth = scanner.nextLine();
    	        
    	        System.out.print("Enter gender: ");
    	        String gender = scanner.nextLine();

    	        System.out.print("Enter grade: ");
    	        String grade = scanner.nextLine();
    	        

    	        Student student = new Student(name, rollNumber,dateofbirth,gender, grade);
    	        students.add(student);

    	        System.out.println("Student added successfully!");
    	  	
    	}
    	catch(Exception e) {
    		System.out.println("please enter valid data");
    	}
         }

    public void removeStudent() {
    	try {
    		System.out.print("Enter roll number of the student to remove: ");
            int rollNumber = Integer.parseInt(scanner.nextLine());

            for (Student student : students) {
                if (student.getRollNumber() == rollNumber) {
                    students.remove(student);
                    System.out.println("Student removed successfully!");
                    return;
                }
            }

            System.out.println("Student not found with the given roll number.");
        }//end of try
    	catch(Exception e){
        	System.out.println("please enter valid roll number");
        }	
    	}//end of remove studentMethod()
        
    public void searchStudent() {
    	try {
        System.out.print("Enter roll number of the student to search: ");
        int rollNumber = Integer.parseInt(scanner.nextLine());

        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("Student found:");
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found with the given roll number.");
        }
    	catch(Exception e) {
    		System.out.println("please enter valid roll number");
    	}
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            System.out.println("List of students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public void run() {
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }
}




public class StudentManagementSystem {

	public static void main(String[] args) {
		StudentOperations system = new StudentOperations();
        system.run();
	}

}
