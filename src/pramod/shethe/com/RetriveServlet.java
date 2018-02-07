package pramod.shethe.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RetriveServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doget(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	 
	 response.setContentType("text/html");
	 PrintWriter out = response.getWriter();
	 
	String a = request.getParameter("id");
	 int id = Integer.valueOf(a);
	 
	 try {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","");
		 PreparedStatement stat = con.prepareStatement("SELECT * FROM student WHERE id=?");
		stat.setInt(1, id);
		
		out.print("<table width=50% border=1>");  
		out.print("<caption>Result:</caption>");  
		  
		ResultSet rs = stat.executeQuery();
		
		ResultSetMetaData rm = rs.getMetaData();
		int total = rm.getColumnCount();
		out.print("<tr>");
		for (int i=0;i<total;i++){
			out.print("<th>"+rm.getColumnName(i)+"<th>");
		}
		out.print("</tr>");
		
		while(rs.next())  
		{  
		out.print("<tr><td>"
		+rs.getInt(1)+"</td><td>"+
				rs.getString(2)+"</td><td>"+
		rs.getString(3)+"</td><td>"
				+rs.getString(4)+"</td><td>"+
		rs.getString(5)+"</td></tr>");  
		                  
		}  
		  
		out.print("</table>");  
		
	} catch (ClassNotFoundException e) 
	{
		e.printStackTrace();
	}catch (SQLException e)
	 {
		e.printStackTrace();
	}
 }
}
