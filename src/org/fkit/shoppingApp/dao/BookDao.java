/**
 * 
 */
package org.fkit.shoppingApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.fkit.shoppingApp.bean.Book;
import org.fkit.shoppingApp.bean.User;
import org.fkit.shoppingApp.util.ConnectionFactory;

/**
 * @author 罗春龙 Version 1.0 2018年10月11日 持久层，该持久层与书籍表交互
 */
public class BookDao {

	/**
	 * @return
	 */
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {
			//从连接工厂中获取连接
			connection = ConnectionFactory.getConnection();
		
			
			// 准备sql语句 此处的 ? 我们称之为占位符 Statement不支持占位符 PreparedStatement支持
			String sql = "select * from tb_book";
			// 准备’集装箱‘
			preparedStatement = connection.prepareStatement(sql);
		
			//进行查询并获取结果集
			rs = preparedStatement.executeQuery();
			
            //遍历结果集并封装的数据
			List<Book> books = new ArrayList<>();
		
			while (rs.next()) {
				Book book = new Book();
				
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getDouble("price"));
				book.setAuthor(rs.getString("author"));
				book.setImage(rs.getString("image"));
				
				books.add(book);
				
			}
			
			return books;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//关闭连接
			ConnectionFactory.closeConnection(connection,preparedStatement,rs);
		
		}

		return null;
	}

	/**
	 * @param 根据书籍id获取书籍详细信息
	 * @return
	 */
	public Book getBookById(Integer id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		try {

			 //获取连接
			connection = ConnectionFactory.getConnection();
			
			// 准备sql语句 此处的 ? 我们称之为占位符 Statement不支持占位符 PreparedStatement支持
			String sql = "select * from tb_book where id = ?";
			// 准备’集装箱‘
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
		
			//进行查询并获取结果集
			rs = preparedStatement.executeQuery();
			
          
		
			if (rs.next()) {
				Book book = new Book();
				
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getDouble("price"));
				book.setAuthor(rs.getString("author"));
				book.setImage(rs.getString("image"));
				book.setRemark(rs.getString("remark"));
				book.setPublication(rs.getString("publication"));
				book.setPublicationdate(rs.getDate("publicationdate"));
				
				return book;
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//关闭连接
			ConnectionFactory.closeConnection(connection, preparedStatement, rs);
		
		}

		return null;
	}

	/**
	 * @param 根据书籍id删除书籍信息
	 */
	public void deleteBookById(Integer id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {

			 //获取连接
			connection = ConnectionFactory.getConnection();
			
			
			// 准备sql语句 此处的 ? 我们称之为占位符 Statement不支持占位符 PreparedStatement支持
			String sql = "delete from tb_book where id = ?";
			// 准备’集装箱‘
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
		
			//执行删除动作
			preparedStatement.executeUpdate();
			
          
		
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			ConnectionFactory.closeConnection(connection, preparedStatement, null);
		
		}

	}

}
