package StudentDatabaseApplication;

import java.util.Scanner;

public class DatabaseApp {

	public static void main(String[] args) {
		
		//Ask how many students 'n' to add
		System.out.print("Enter amount of students to enroll: ");
		Scanner scan1 = new Scanner(System.in);
		int totalStudents = scan1.nextInt();
		Student[] Students = new Student[totalStudents];
		System.out.println();
		
		
		//Create n number of students
		for (int i = 0; i < totalStudents; i++)
		{
			Students[i] = new Student();
			System.out.println();
			Students[i].courseEnroll();
			Students[i].payable();
			System.out.println(Students[i].studentStatus());
			System.out.println("-------------------------------------");
		}
	}

}
