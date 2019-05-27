/**
 * 
 */
package org.fkit.shoppingApp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;


/**
 * @author 亲爱的琼
 * Version 1.0
 */
public class ConnectionFactory {
	
	static DataSource basicDataSource = new BasicDataSource();
	
	static {
       try {
    	   Context initCtx = new InitialContext();
    	   
   		   
    	   basicDataSource = (DataSource)initCtx.lookup("java:/comp/env/jdbc/bookApp");
   		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

	}
	
	
	//获取连接
	public static Connection getConnection() {
		try {

			return basicDataSource.getConnection();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}

	/**
	 * @param connection
	 * @param preparedStatement
	 * @param rs
	 * 关闭连接
	 */
	public static void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet rs) {
		// TODO Auto-generated method stub
		try {
			if(rs!=null) {
				rs.close();
			}
			
			if(preparedStatement !=null) {
				preparedStatement.close();
			}
			
			if(connection !=null) {
				connection.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	

}
