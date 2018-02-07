package pramod.shethe.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("userPass");
		String email = request.getParameter("userEmail");
		String country = request.getParameter("userCountry");
		String z = request.getParameter("id");
		int id = Integer.valueOf(z);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","");
			PreparedStatement stat = con.prepareStatement("INSERT INTO student VALUES(?,?,?,?,?)");
			stat.setInt(1, id);
			stat.setString(2,userName);
			stat.setString(3, password);
			stat.setString(4, email);
			stat.setString(5, country);
			
			int i = stat.executeUpdate();
			if(i>0){
				
				out.print("User is successfully created!!!");
			}
			con.close();
			out.close();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException q){
			q.printStackTrace();
		}
		out.print("Hello,User is created man!!!");
	}

}
