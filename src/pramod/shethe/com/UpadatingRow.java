package pramod.shethe.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpadatingRow extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String mail = request.getParameter("update");
		String id = request.getParameter("id2");
		int id2 = Integer.valueOf(id);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","");
			PreparedStatement stat = con.prepareStatement("UPDATE student SET email=? WHERE id=?");
			
			stat.setString(1,mail);
			stat.setInt(2,id2);
			stat.executeUpdate();
			
			out.print("ID name "+id2+" Email updated");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}

	}

}
