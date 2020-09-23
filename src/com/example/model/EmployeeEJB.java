package com.example.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 * Session Bean implementation class EmployeeEJB
 */
@Stateless
public class EmployeeEJB {
	Connection con=null;
	PreparedStatement pstmt=null;
	@Resource(name="jdbc/mydb")
	DataSource ds;
	
	public EmployeeEJB() {
		
	}
	@PostConstruct
	public void init() {
		try {
			con = ds.getConnection();
			//System.out.println(ds);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public String insert(Employee e) {
    	String query = "insert into employees(id, name, salary) values(?,?,?)";
    	try {
    		pstmt=con.prepareStatement(query);
    		pstmt.setInt(1, e.getId());
    		pstmt.setString(2, e.getName());
    		pstmt.setDouble(3, e.getSalary());
    		pstmt.executeUpdate();
    	}catch(Exception ex) {
    		System.out.println(ex);
    	}
    	//insertion
    	return("registered");
    }
    public boolean update(Employee e) {
    	String query = "Update employees set salary=?,name=? where id=?";
		try {
			pstmt=con.prepareStatement(query);
		}catch(Exception ex) {
			System.out.println("Error2"+ex);
		}
    	try {
//    		pstmt.setInt(1, e.getId());
    		pstmt.setDouble(1, e.getSalary());
    		pstmt.setString(2, e.getName());
    		pstmt.setInt(3,  e.getId());
    		System.out.println(pstmt);
    		if(pstmt.executeUpdate()==1) {
    			return true;
    		}
    	}catch(Exception ex) {
    		System.out.println(ex);
    	}
    	//insertion
    	return false;
    }
    public Employee find(int id) {
    	StringBuilder result=new StringBuilder();
    	Employee emp = new Employee(0, null, 0);
    	try {
    		PreparedStatement pstm=con.prepareStatement("select * from employees where id=?");
    		pstm.setInt(1, id);
			ResultSet rs=pstm.executeQuery();
			if(rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getDouble("salary"));
			}
    	}catch(Exception ex) {
    		System.out.println(ex);
    	}
    	return emp;
    }
    public boolean delete(int id) {
    	StringBuilder result=new StringBuilder();
    	try {
    		PreparedStatement pstm=con.prepareStatement("delete from employees where id=?");
    		pstm.setInt(1, id);
			if (pstm.executeUpdate()==1) {
				return true;
			}
    	}catch(Exception ex) {
    		System.out.println(ex);
    	}
    	//insertion
    	return false;
    }
}
