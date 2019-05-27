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
 * @author 罗春龙
 * Version 1.0
 * 2018年10月12日
 *  连接工厂
 */
public class ConnectionFactory {
	
	static DataSource basicDataSource = new BasicDataSource();
	//对数据库连接池进行初始化
	/*static {

		//设置驱动信息
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		//设置连接的地址
		basicDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/bookapp");
		//指定数据连接的账号
		basicDataSource.setUsername("root");
		//指定数据库连接密码
		basicDataSource.setPassword("123");
		
		//设置最大连接数
		basicDataSource.setMaxActive(3);
		
		//设置连接保存数
		basicDataSource.setMaxIdle(3);
		
		//设置最大等待时间   单位毫秒
		basicDataSource.setMaxWait(5000);
	}*/
	
	static {
       try {
    	   Context initCtx = new InitialContext();
    	   //java:/comp/env  代表Tomcat 容器的前缀        不同的JNDI容器前缀不一样
   		  // Context envCtx = (Context) initCtx.lookup("java:/comp/env");
   		   //jdbc/bookApp  被检索的资源的名称
   		  // basicDataSource = (DataSource)envCtx.lookup("jdbc/bookApp");
   		   
   		   
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
