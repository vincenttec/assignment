

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.stream.events.Comment;

public class DatabaseConnection{
	
	private static final Connection conn = null;
	private String dbUrl="jdbc:mysql://localhost:3306/gym";
  private String dbUser="root";
  private String dbPass="";
  private String dbDriver="com.mysql.cj.jdbc.Driver";
public void loadDriver(String dbDriver) {
	  try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
			
			
		}
		return con;
	}
	public String insert(Registerr regis) {
		loadDriver(dbDriver);
		Connection con;
		con= getConnection();
		PreparedStatement ps=null;
		String query ="INSERT INTO registration VALUES(?,?,?,?,?,?,?,?,?,?)";
		
		String message = " registered Successfully";
		
				try {
					ps=con.prepareStatement(query);
					ps.setString(1, null);
					ps.setString(2, regis.getFirst_name());
					ps.setString(3, regis.getLast_name());
					ps.setString(4, regis.getBirthday());
					ps.setString(5, regis.getGender());
					ps.setString(6, regis.getEmail());
					ps.setString(7, regis.getPassword());

					ps.setString(8, regis.getPhone());
					ps.setString(9, regis.getImage());

					
					ps.setString(10, regis.getSubject());
;
					ps.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					message = "not registered";
					message=e.toString();
					e.printStackTrace();
				}
				
	return message;
	}
	
	
	
	
	
	public String inserti1(Comments com) {
		loadDriver(dbDriver);
	Connection con2 = getConnection();
	String query2 ="INSERT INTO comments VALUES(?,?,?,?)";
	
	String message5 = "you commente is received";
	
			try {
				PreparedStatement v=con2.prepareStatement(query2);
				v.setString(1, null);
				v.setString(2,com.getName());
				v.setString(3,com.getEmail());
				v.setString(4,com.getMessage());
			
				v.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				message5 = "comment not registered";
				e.printStackTrace();
			}
			
return message5;
	}

	
	public boolean CheckCredentials(String uname,String passwd) {
		loadDriver(dbDriver);
		Connection con=getConnection();

		String query="SELECT * FROM account WHERE username=? AND password=?";

		PreparedStatement ps=null;
		try {
		ps=con.prepareStatement(query);

		ps.setString(1, uname);
		ps.setString(2, passwd);

		ResultSet rs=ps.executeQuery();

		if(rs.next()) {
		return  true;
		
		}
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		e.toString();
		}

		return false;
		}

//	String sql = "UPDATE account SET password=?, fullname=?, email=? WHERE username=?";
//	 
//	PreparedStatement statement1 = conn.prepareStatement(sql);
//	statement.setString(1, "username");
//	statement1.ser
//	statement.setString(3, "bill.gates@microsoft.com");
//	statement.setString(4, "bill");
//	 
//	int rowsUpdated = statement1.executeUpdate();
//	if (rowsUpdated > 0) {
//	    System.out.println("An existing user was updated successfully!");
//	}

	
	
	
	
	
public String inserti3(Createaccount1 com) {
	loadDriver(dbDriver);
Connection con2 = getConnection();
String query2 ="INSERT INTO account VALUES(?,?,?,?)";

String message3 = "you account created";

		try {
			PreparedStatement v=con2.prepareStatement(query2);
			v.setString(1, null);
			v.setString(2,com.getUsername());
			v.setString(3,com.getEmail());
			v.setString(4,com.getPassword());
		
			v.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message3 = "account not creted";
			e.printStackTrace();
		}
		
return message3;

	}
	public String inserti(Comments comments) {
		// TODO Auto-generated method stub
		return null;
	}	
//	  
//	  
  }

