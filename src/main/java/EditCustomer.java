

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditCustomer
 */
@WebServlet("/EditCustomer")
public class EditCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	  private String dbDriver="com.mysql.cj.jdbc.Driver";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		String id=request.getParameter("id");
		String first_name=request.getParameter("first_name");
		String last_name=request.getParameter("last_name");
		String birthday=request.getParameter("birthday");
		String gender=request.getParameter("gender");
		String email=request.getParameter("email");
		String password=request.getParameter("password");

		String phone=request.getParameter("phone");
		String subject=request.getParameter("subject");
				DatabaseConnection dbcon = new DatabaseConnection();
				dbcon.loadDriver(dbDriver);
				Connection con = dbcon.getConnection();
				String query="UPDATE registration SET F_name='"+first_name+"',L_name='"+last_name+"',Birthdates='"+birthday+"',Gender='"+gender+"',email='"+email+"',password='"+password+"',phone='"+phone+"',subject='"+subject+"' WHERE id="+id;		
				String mess="updated successfull";
				try {
					PreparedStatement vi= con.prepareStatement(query);
					vi.executeUpdate();
				} catch (SQLException e) {
					mess="not successfull";
					// TODO Auto-generated catch block
					mess=e.toString();
					e.printStackTrace();
				}
				response.getWriter().print(mess);
				
				
				
	}

		
		
		
		
}
