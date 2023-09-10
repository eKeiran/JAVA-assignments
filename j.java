package semIV;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class j {
	
	public static void main(String[] args)
	{
	try
	{
	
	//Load driver	
	Class.forName("com.mysql.jdbc.Driver");
	System.out.println("Driver Loaded");
	//2. create the connection
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","Chinmay@123");
	System.out.println("Connection Established");
	//update data in database
	String query = "delete from student where city = ?";
	PreparedStatement preparedStmt = conn.prepareStatement(query);
    preparedStmt.setString(1,"Pune");
    preparedStmt.executeUpdate();
    conn.close();
  }
  catch (Exception e)
  {
    System.err.println("Got an exception! ");
    System.err.println(e.getMessage());
  }
}

}