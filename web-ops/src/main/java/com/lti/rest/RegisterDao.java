package com.lti.rest;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.lti.entity.Register;
public class RegisterDao {

	public void save(Register register){
	Connection conn=null;
	 java.sql.PreparedStatement stmt = null;
	
	
	try {
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("dev-db.properties");
		Properties dbprops = new Properties();
		dbprops.load(is);
		
		Class.forName(dbprops.getProperty("driver"));
		
		conn=DriverManager.getConnection(dbprops.getProperty("url"),
				                                                       dbprops.getProperty("user"),
				                                                       dbprops.getProperty("pass"));
		String sql="insert into tbl_1 values(?,?,?,?)";
		stmt=conn.prepareStatement(sql);
		
		stmt.setString(1,register.getName());
		stmt.setString(2,register.getEmail());
	
		stmt.setString(3, register.getUsername());
		stmt.setString(4, register.getPassword());
		stmt.executeUpdate();
		
}
    catch(ClassNotFoundException e) {
		System.out.println("driver not found");
	}
	catch(SQLException e) {
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			conn.close();
		}
	 catch(Exception e) {
		 
	 }
	
}

}

}
