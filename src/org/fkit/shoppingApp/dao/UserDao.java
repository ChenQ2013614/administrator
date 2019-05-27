/**
 * 
 */
package org.fkit.shoppingApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.fkit.shoppingApp.bean.User;
import org.fkit.shoppingApp.util.ConnectionFactory;

/**
 * @author 亲爱的琼
 * Version 1.0
 */
public class UserDao {
	

	
	//进行登录
	public  User getUserByNameAndPass(String name,String pass){
		
		
	
	
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try{
			 //获取连接
			connection = ConnectionFactory.getConnection();
			
			
			//准备sql语句     此处的 ?   我们称之为占位符     Statement不支持占位符     PreparedStatement支持
			String sql = "select * from tb_user where loginname = ? and  password = ?";
			// 准备’集装箱‘
			preparedStatement = connection.prepareStatement(sql);			

			//给占位符设定值
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, pass);
			
			System.out.println("sql:"+sql);
			
			
			rs = preparedStatement.executeQuery();
			
			if(rs.next()) {
				//将用户的信息封装好，再返回
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setLoginName(name);
				user.setPassword(pass);
				user.setRealName(rs.getString("username"));
				return user;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, rs);
		}
		
		return null;
	}


	/**
	 * @param loginName
	 * @param password
	 * @param realName
	 * 用户注册
	 */
	public void save(String loginName, String password, String realName) {
		// TODO Auto-generated method stub


		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			connection = ConnectionFactory.getConnection();
			
			//准备sql语句     此处的 ?   我们称之为占位符     Statement不支持占位符     PreparedStatement支持
			String sql = "insert into tb_user(loginname,PASSWORD,username) values(?,?,?);";
			
			//准备’集装箱‘
			preparedStatement = connection.prepareStatement(sql);
			

			//给占位符设定值
			preparedStatement.setString(1, loginName);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3, realName);
			
			
			//执行sql语句
			preparedStatement.executeUpdate();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
				ConnectionFactory.closeConnection(connection, preparedStatement, null);
			
		
		}
		
		
	}

}
