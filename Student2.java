package semIV;
import java.util.Scanner;
public class Student2 {
	static Scanner sc = new Scanner(System.in);
	int rollno;
	long mobno;
	static int i=1, j=1;
	String name, cls, email;
	
	void getData() {

		System.out.println("STUDENT " +i+":");
		++i;
		System.out.println("Enter name of student:");
		name=sc.nextLine();
		System.out.println("Enter roll no:");
		rollno=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter class:");
		cls=sc.nextLine();
		System.out.println("Enter mobile no:");
		mobno=sc.nextLong();
		sc.nextLine();
		System.out.println("Enter email");
		email=sc.nextLine();
		System.out.println();
		
		
	}
	void printData() 
	{   

		System.out.println("STUDENT " +j+":");
		System.out.println("Name of student:" + name);
		System.out.println("Roll Number of student:" + rollno);
		System.out.println("Class of student:" + cls);
		System.out.println("Mobile Number of student:" + mobno);
		System.out.println("Email of student:" + email);
		System.out.println();
		j++;
	}
	
	public static void main(String args[]) {
	Student2 s1 = new Student2();
	Student2 s2 = new Student2();
	s1.getData();
	s2.getData();
	s1.printData();
	s2.printData();
	sc.close();
	
	}	
}
