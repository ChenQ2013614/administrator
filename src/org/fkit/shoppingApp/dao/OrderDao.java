/**
 * 
 */
package org.fkit.shoppingApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.fkit.shoppingApp.bean.Book;
import org.fkit.shoppingApp.bean.Order;
import org.fkit.shoppingApp.bean.OrderItem;
import org.fkit.shoppingApp.bean.User;
import org.fkit.shoppingApp.util.ConnectionFactory;

/**
 * @author 亲爱的琼 Version 1.0 
 */
public class OrderDao {

	/**
	 * @param order
	 * @throws SQLException 
	 */
	public void save(Order order,OrderItem item) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			connection = ConnectionFactory.getConnection();
			
			//将提交方式设置为手动提交
			connection.setAutoCommit(false);
			
			//准备sql语句     此处的 ?   我们称之为占位符     Statement不支持占位符     PreparedStatement支持
		   String sql = "insert into tb_order(order_no,cruedate,user_id,money) values(?,?,?,?);";
			
			//准备’集装箱‘
			preparedStatement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			

			//给占位符设定值
			preparedStatement.setString(1, order.getOrderNo());
			preparedStatement.setDate(2, new java.sql.Date(order.getCreateDate().getTime()));
			preparedStatement.setInt(3, order.getUserId());
			preparedStatement.setDouble(4, order.getMoney());
			
			
			
			//执行sql语句
			int num = preparedStatement.executeUpdate();
			
			if(num == 1) {
				//获取主键的值
				ResultSet rs =preparedStatement.getGeneratedKeys();
				rs.next();
				//获取订单主键id值
				Integer orderId = rs.getInt(1);
				//将订单id存放在订单明细中
				item.setOrderId(orderId);
			}
			
			//保存订单明细
			 String itemSql = "insert into tb_item(book_id,order_id,amount) values(?,?,?);";
			 preparedStatement = connection.prepareStatement(itemSql);
			 preparedStatement.setInt(1, item.getBookId());
			 preparedStatement.setInt(2, item.getOrderId());
			 preparedStatement.setInt(3, item.getBuyNum());
			 
			 //保存订单明细
			 preparedStatement.executeUpdate();
			 //提交事务
			 connection.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//回滚
			connection.rollback();
			throw new RuntimeException("订单保存失败！");
		}finally {
				ConnectionFactory.closeConnection(connection, preparedStatement, null);
		}
		
	}

}
