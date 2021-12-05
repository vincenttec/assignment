

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Image
 */
@MultipartConfig( maxFileSize= 16177215)

@WebServlet("/Image")
public class Image extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Image() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		System.out.println("ind do post method i add servlet");
		Part filePart=request.getPart("image");
		String imageFileStringName=filePart.getSubmittedFileName();
		System.out.println("selected image file name :"+imageFileStringName);


		String uploadPath="C:/Users/Administrator/eclipse-workspace/assignment/src/main/webapp/images/"+imageFileStringName;
		System.out.println("Upload path :"+uploadPath);

		try {
		FileOutputStream fos=new FileOutputStream(uploadPath);
		InputStream is=filePart.getInputStream();
		byte[] data=new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();
		}catch(Exception e) {
		e.printStackTrace();
		}

		Connection connection=null;

		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/gym","root","");
		PreparedStatement stmt;
		String query="insert into registration (F_ame,L_name,Birthdates,Gender,email,password,phone,image,subject) values (?,?,?,?,?,?,?,?,?,?)";
		stmt=connection.prepareStatement(query);
		stmt.setString(1, request.getParameter("first_name"));
		stmt.setString(2, request.getParameter("last_name"));
		stmt.setString(3, request.getParameter("Birthdates"));
		stmt.setString(4, request.getParameter("Gender"));

		stmt.setString(5, request.getParameter("email"));
		stmt.setString(6, request.getParameter("password"));
		stmt.setString(7, request.getParameter("phone"));

		stmt.setString(8,imageFileStringName);
		stmt.setString(9, request.getParameter("subject"));




		int rows=stmt.executeUpdate();

		if(rows>0) {
		System.out.println("the product is registered successfuly");
		response.sendRedirect("view.jsp");
		}
		else {
		System.out.println("oops");
		}
		} catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
		e.toString();
		}
	}

}
