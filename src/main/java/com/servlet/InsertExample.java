package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertExample extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		/*
		 * try { Class.forName("com.mysql.cj.jdbc.Driver"); Connection con =
		 * DriverManager.getConnection("jdbc:mysql://localhost:3306/kani_sol","root",
		 * "Ravi@6886");
		 * 
		 * PreparedStatement ps =
		 * con.prepareStatement("insert into employee values(?,?,?)");
		 * 
		 * //int id = Integer.parseInt(req.getParameter("id")); // String name =
		 * req.getParameter("name"); //int sal =
		 * Integer.parseInt(req.getParameter("sal"));
		 * 
		 * ps.setInt(1, id); ps.setString(2, name); ps.setInt(3,sal);
		 * 
		 * ps.setInt(1, Integer.parseInt(req.getParameter("id"))); ps.setString(2,
		 * req.getParameter("name"));
		 * ps.setInt(3,Integer.parseInt(req.getParameter("sal")));
		 * 
		 * ps.executeUpdate(); PrintWriter pw =res.getWriter();
		 * pw.print("<h1>Data inserted Successfully.......</h1>");
		 * 
		 * ps.close(); con.close();
		 * 
		 * } catch(SQLException | ClassNotFoundException e) { e.printStackTrace(); }
		 */
		res.setContentType("text/html");
		Employee emp = new Employee();
		int id =Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		int salary =Integer.parseInt(req.getParameter("sal"));
		
		emp.setId(id);
		emp.setName(name);
		emp.setSalary(salary);
		
		int i=EmployeeDao.save(emp);
		PrintWriter pw =res.getWriter();
		
		if(i>0) {
			pw.print("<p>Data inserted successfully<p>");
			req.getRequestDispatcher("index.html").include(req, res);
			
		}
		else {
			pw.print("please insert data  properly");
		}
		
		
		
		
		
	}

}
