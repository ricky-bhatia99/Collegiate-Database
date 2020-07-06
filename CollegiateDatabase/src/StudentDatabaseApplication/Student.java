package StudentDatabaseApplication;

import java.util.Scanner;

public class Student {
	private String firstName;
	private String fName;
	private String lName;
	private String lastName;
	private int studYear;
	private String studID;
	private String courses = "";
	private double tuitionBal = 0.0;
	private static double courseCost = 350.00;
	private static int id = 1000;
	
	//Constructor prompt user to enter student name and year
	public Student()
	{
		Scanner scan1 = new Scanner(System.in);
		System.out.print("Enter student's first name: ");
		this.firstName = scan1.nextLine();
		System.out.print("Enter student's last name: ");
		this.lastName = scan1.nextLine();
		System.out.println();
		System.out.print("Class Levels:\n1 - Freshmen\n2 - Sophomore\n3 - Junior\n4 - Senior or beyond\n\nInput student's class level: ");
		this.studYear = scan1.nextInt();
		System.out.println();
		
		
		generateStudID();
		
		fName = firstName.substring(0,1).toUpperCase()+firstName.substring(1,firstName.length());
		lName = lastName.substring(0,1).toUpperCase()+lastName.substring(1,lastName.length());
			
	}
	
	//Generate ID
	private void generateStudID()
	{
		id++;
		this.studID = this.studYear + "" + id + this.studYear * 2;
		
	}
	
	//Enroll in courses
	public void courseEnroll()
	{
		//Student can enroll in no more than 6 courses..//7 if Senior
		int size = 0;
		if (studYear >= 4)
		{
			System.out.println("Enroll up to 7 classes");
			System.out.println();
			for (int i = 0; i < 7; i++)
			{
				System.out.print("Enter course to enroll (Q/q- quit): ");
				Scanner scan1 = new Scanner(System.in);
				String course = scan1.nextLine();
				if(!course.equals("Q") && !course.equals("q"))
				{
					courses += "\n     " + course;
					tuitionBal += courseCost;
					size++;
				}
				else
				{
					break;
				}
			} 
		}
		else
		{
			System.out.println("Enroll up to 6 classes");
			System.out.println();
			for (int i = 0; i < 6; i++)
			{
				System.out.print("Enter course to enroll (Q/q- quit): ");
				Scanner scan1 = new Scanner(System.in);
				String course1 = scan1.nextLine();
				if(!course1.equals("Q") && !course1.equals("q"))
				{
					courses += "\n     " + course1;
					tuitionBal += courseCost;
					size++;
				}
				else
				{
					break;
				}
			} 
		}
		
		System.out.println();
		System.out.println("Enrolled in " + size + " courses");

		System.out.println();

		
	}
	
	//View balance
	public void viewBal()
	{
		System.out.printf("Balance due: $%.2f%n", tuitionBal);
	}
	
	
	//Pay tuition
	public void payable()
	{
		viewBal();
		double payment = 0;
		System.out.print("Enter payment amount: ");
		Scanner scan1 = new Scanner(System.in);
		payment = scan1.nextDouble(); 
		if (payment <= tuitionBal)
		{
			tuitionBal = tuitionBal - payment;
			System.out.printf("\nPayment made: $%.2f%n", payment);
		}
		else
		{
			System.out.println("\nError: invalid amount. Payment exceeds tuition balance.");
			do
			{
				System.out.print("\nEnter a valid payment amount: ");
				Scanner scan2 = new Scanner(System.in);
				payment = scan2.nextDouble();
				
				int placeholder = 0;
				while(payment > tuitionBal && placeholder == 0)
				{
					System.out.println("Error: invalid amount. Payment exceeds tuition balance.");
					placeholder++;
				}
			}while(payment > tuitionBal);
			
			tuitionBal = tuitionBal - payment;
			System.out.printf("\nPayment made: $%.2f%n", payment);
		}

		System.out.println();
		
	}
	
	
	//Show status
	public String studentStatus()
	{
		return "\n\nName: " + fName + " " + lName + 
				"\nID #: " + studID +
				"\nGrade level" + studYear +
				"\n\nCourses enrolled in:  " + courses +
				String.format("\n\nRemaining student balance: $%.2f%n", tuitionBal); 
	}
	
	
	
	
	
	
	
	
}
