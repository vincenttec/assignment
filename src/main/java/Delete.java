import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Delete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
//		
//		Connection con=null;
//		Statement st=null;
//		Scanner scanner=null;
//	
//               try{
//            	   
//            	   //load and register driver
//            	   Class.forName("oracle.jdbc.OracleDriver");
//            	   //establish connection between java application and databases
//            	   con=DriverManager.getConnection(dbUrl, dbUser, dbPass);
//            	   
//            	   st=con.createStatement();
//            	   scanner=new Scanner(System.in);
//            	   float range=scanner.nextFloat();
//            	   int rowCount=st.executeUpdate("delete from registration where id="+range);
//            	   System.out.println("the deleted registration"+rowCount);
//            	   
//               }catch (Exception e)
//               {
//                   e.printStackTrace();
//  
//               }
//               finally {
//            	   
//            	try
//            	{
//            	   st.close();
//            	   scanner.close();
//            	   con.close();
//               }
//            	catch (Exception e2)
//            	{
//                    e2.printStackTrace();
//
//            	}
//            	}
//
//	}
//
}}
