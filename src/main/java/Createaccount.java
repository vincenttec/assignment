

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Createaccount
 */
@WebServlet("/Createaccount")
public class Createaccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Createaccount() {
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
		String username =request.getParameter("username");
		String email =request.getParameter("email");
		String password =request.getParameter("password");

		
		
		Createaccount1 create =new Createaccount1 (username,email,password);
	
		
		DatabaseConnection dbcon = new DatabaseConnection();
		String results3 = dbcon.inserti3(create);
		response.getWriter().print(results3);
		String message="account created";
		  request.setAttribute("errorMessage", message );
		   RequestDispatcher rd = request.getRequestDispatcher("ff.jsp");
		        rd.forward(request, response); 
	}

	}


