package semIV;
import java.util.Scanner;

public class fourEqual {
	static int i=2;
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		while(i!=0)
		{
		i--;
		System.out.println("\nEnter 4 numbers:");
		int n1=sc.nextInt();
		int n2=sc.nextInt();
		int n3=sc.nextInt();
		int n4=sc.nextInt();
		if(n1==n2 && n3==n4 && n2==n3)
		{
			System.out.print("Equal");
		}
		else {
			System.out.print("Not Equal");
		}
		
		}
		sc.close();	
	}
	
}
