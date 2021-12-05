

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Addimage
 */
@WebServlet("/Addimage")
@MultipartConfig(maxFileSize = 16177215)
public class Addimage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    





	  public Addimage() {
	      super();
	      // TODO Auto-generated constructor stub
	  }


 
	private String url="jdbc:mysql://localhost:3306/gym";
	 private  String user="root";
  private  String pass="";
  private String drivename="com.mysql.cj.jdbc.Driver";
       
    /**
     * @see HttpServlet#HttpServlet()
     */


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 InputStream inputStream = null; 
	        Part filePart = request.getPart("image");
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	        }
	    
		String name = request.getParameter("bname");
		String title=request.getParameter("title");
		String author = request.getParameter("author");
		String category=request.getParameter("category");
		
		String first_name=request.getParameter("first_name");
		String last_name= request.getParameter("last_name");
		String birthday = request.getParameter("birthday");
		String gender=request.getParameter("gender");

		String email=request.getParameter("email");
		String password= request.getParameter("password");
		String  phone=request.getParameter("phone");

		String image= request.getParameter("image");
		String subject = request.getParameter("subject");




		
		
		
		
		
		//Book book = new Book(name,title,author,category,"");
	       
        Connection conn = null; // connection to the database
        String message = "New Book Not Added";  // message will be sent back to client
		  try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		       conn = DriverManager.getConnection(url,user,pass);
		       String sql = "insert into registration (id,F_name,L_name,Birthdates,Gender,email,password,phone,photo,subject) values (?,?,?,?,?,?,?,?,?,?)";
	            PreparedStatement stmt = conn.prepareStatement(sql);
//	            statement.setString(1, null);
//	            statement.setString(2, name);
//	            statement.setString(3, title);
//	            statement.setString(4, author);
//	            statement.setString(5, category);
	           // statement.setString(6, email);
	        	stmt.setString(1, null);
	    		stmt.setString(2, request.getParameter("first_name"));
	    		stmt.setString(3, request.getParameter("last_name"));
	    		stmt.setString(4, request.getParameter("birthday"));
	    		stmt.setString(5, request.getParameter("gender"));

	    		stmt.setString(6, request.getParameter("email"));
	    		stmt.setString(7, request.getParameter("password"));
	    		stmt.setString(8, request.getParameter("phone"));

	    		//stmt.setString(9, request.getParameter("image"));
	    		stmt.setString(10, request.getParameter("subject"));

	            
	            
	            if (inputStream != null) {
	                // fetches input stream of the upload file for the blob column
		        	  stmt.setBlob(9, inputStream);
	            }
	            if(stmt.executeUpdate()>0) {
	            	   message = "New CUSTOMER Added Well";
	            }
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = e.toString();
		}
  
   request.setAttribute("errorMessage", message );
   RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);  
	}

}

















