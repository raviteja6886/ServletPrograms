package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kani_sol","root","Ravi@6886");
		return con;
	}
	public static int save(Employee emp) {
		int i=0;
		try {
			Connection con = EmployeeDao.getConnection();
			
			PreparedStatement  st = con.prepareStatement("insert into employee values(?,?,?)");
			
			st.setInt(1, emp.getId());
			st.setString(2, emp.getName());
			st.setInt(3, emp.getSalary());
			i = st.executeUpdate();
			con.close();
			st.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	
	public static List<Employee> getAllEmployees() throws ClassNotFoundException, SQLException{
		
		List<Employee>list =new ArrayList<>();
		Connection con = EmployeeDao.getConnection();
		
		PreparedStatement ps = con.prepareStatement("select * from employee");
		ps.execute();
		ResultSet rs =ps.getResultSet();
		while(rs.next()) {
			Employee emp = new Employee();
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setSalary(rs.getInt(3));
			list.add(emp);
		}
		rs.close();
		ps.close();
		con.close();
		
		return list;
		
	}
	public static int update(Employee e) throws ClassNotFoundException, SQLException {
		int status = 0;
		Connection con = EmployeeDao.getConnection();
		
		PreparedStatement ps  = con.prepareStatement("update employee set employee_Name=?,employee_Salary=? where employee_id=?");
		
		ps.setString(1, e.getName());
		ps.setInt(2, e.getSalary());
		ps.setInt(3, e.getId());
		
		status = ps.executeUpdate();
		
		con.close();
		ps.close();
		return status;
	
	}
	
	public static int delete(int id) throws ClassNotFoundException, SQLException {
		int status=0;
		Connection con = EmployeeDao.getConnection();
		
		PreparedStatement ps =con.prepareStatement("delete from employee where employee_Id=?");
		
		ps.setInt(1, id);
		status = ps.executeUpdate();
		con.close();
		ps.close();
		return status;
	}
	
	public static Employee getEmployeeById(int id) throws ClassNotFoundException, SQLException {
		
		Employee e = new Employee();
		Connection con = EmployeeDao.getConnection();
		
		PreparedStatement ps  = con.prepareStatement("select * from employee where employee_id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setSalary(rs.getInt(3));
		}
		ps.close();
		con.close();
		return e;	
	}
	
	
	
}

