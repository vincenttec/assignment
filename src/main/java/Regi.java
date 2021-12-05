

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Regi
 */
@WebServlet("/Regi")
public class Regi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Regi() {
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
		String first_name =request.getParameter("first_name");
		String last_name =request.getParameter("last_name");
		String birthday =request.getParameter("birthday");
		String gender =request.getParameter("gender");
		String email =request.getParameter("email");
		String password =request.getParameter("password");

		int phone =Integer.parseInt(request.getParameter("phone"));
		String subject =request.getParameter("subject");

		
		Registerr regis =new Registerr(first_name,last_name,birthday,gender,email,password,subject,phone);
	
		
		DatabaseConnection dbcon = new DatabaseConnection();
		String results3 = dbcon.insert(regis);
		response.getWriter().print(results3);
	}
	}


