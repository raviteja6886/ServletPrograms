package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		try {
			Employee e = EmployeeDao.getEmployeeById(id);
			
			out.print("<html><body>");
			out.print("<h1 align:center>Update Employee</h1>");
			out.print("<form action='updateData2' method='post'>");  
	        out.print("<table>");  
	        out.print("<tr><td>Employee Id :</td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
	        out.print("<tr><td>Employee Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
	        out.print("<tr><td>Employee Salary:</td><td><input type='text' name='sal' value='"+e.getSalary()+"'/></td></tr>");
	        out.print("<tr><td><input type='submit' value='update'/></td></tr>");
	        out.print("</table>");  
	        out.print("</form>"); 
	        out.print("</body></html>");
	        
	          
	        out.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		
		
	}
		

}
