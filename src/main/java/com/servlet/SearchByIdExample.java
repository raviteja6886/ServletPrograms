package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchByIdExample extends HttpServlet {

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			Connection con =EmployeeDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employee where employee_id=?");
			ps.setInt(1, id);
		
			ps.execute();
			ResultSet rs = ps.getResultSet();
			
			if(rs.next()) {
				pw.print("<table><tr><th>EmployeeId</th><th>EmployeeName</th><th>EmployeeSalary</th></tr>");
				pw.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td></tr>");
				pw.print("</table>");
			
			}else {
				pw.print("<h1>Data is not found...incorrect id</h1>");
			}
			
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.close();
	}
}
