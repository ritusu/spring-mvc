package com.lti.training1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lti.exception.DataAccessException;
import com.lti.training.*;
public class ProductDao {
	
	
	public List<Product> fetchProducts(int from,int to) throws DataAccessException{
			
			Connection conn=null;
			PreparedStatement stmt=null;
			ResultSet rs=null;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
				String sql="SELECT outer.* FROM (SELECT ROWNUM rn, inner.*FROM (  SELECT e.* FROM tbl_product e ) inner) outer WHERE outer.rn >= ? AND outer.rn < ? order by id";
				stmt=conn.prepareStatement(sql);
				stmt.setInt(1,from);
				stmt.setInt(2,to);
				rs=stmt.executeQuery();
				
				List<Product> products = new ArrayList<Product>();
				while(rs.next()) {
					Product p =new Product();
					p.setId(rs.getInt(2));
					p.setName(rs.getString(3));
					p.setPrice(rs.getDouble(4));
					p.setQuantity(rs.getInt(5));
					products.add(p);
					}
				return products;
			}
			catch(ClassNotFoundException e) {
				throw new DataAccessException("Unable to load the JDBC driver");
			}
			catch(SQLException e) {
				throw new DataAccessException("Problem while fetching products from database",e);
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





