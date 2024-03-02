package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		try {
			List<Employee>list = EmployeeDao.getAllEmployees();
			
			pw.print("<h1>Employees List</h1>");
			
			pw.print("<table border='1' width='100%'><tr>");
			pw.print("<th>Emp_Id</th><th>Emp_Name</th>"
					+"<th>Emp_Salary</th>"
					+ "<th>Edit</th><th>delete</th></tr>");
			for(Employee e : list) {
				
				pw.print("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td>"
						+"<td>"+e.getSalary()+"</td><td><a href='updateData?id="+e.getId()+"'>update</a></td>"+"<td><a href='deleteData?id="+e.getId()+"'>delete</a>");
				
			}
			pw.print("</table><br>");
			pw.print("<a href='index.html'>Add New Employee</a>");
			
		} catch (ClassNotFoundException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		pw.close();
		
	}

}
