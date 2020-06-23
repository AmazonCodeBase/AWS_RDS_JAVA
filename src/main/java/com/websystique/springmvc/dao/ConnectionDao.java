package com.websystique.springmvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.websystique.springmvc.model.User;

public class ConnectionDao {
	Connection con = null;
	public Connection RetriveConnection() {
	try { 
		System.out.println("connection done");
		Class.forName("org.postgresql.Driver");  
		con=DriverManager.getConnection(  
		"jdbc:postgresql://java-application.cqgqd1oplv07.ap-south-1.rds.amazonaws.com:5432/test","post","javawebapp");
		}catch(Exception e){
		System.out.println("connection error");
		System.out.println(e);}
	return con;  
	}
	
	public List<User> getUserList(Connection conn){
		if(conn == null) {
			conn = RetriveConnection();
		}
		List<User> userList = new ArrayList<>();
		try {
		Statement stmt=conn.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from userinfo");  
		while(rs.next())  {
			User user = new User();
			user.setId(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setAddress(rs.getString(3));
			user.setEmail(rs.getString(4));
			userList.add(user);
		}
		System.out.println("list is: "+userList.size());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userList;
		//con.close();  
		
	}

}
