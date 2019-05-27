package org.fkit.shoppingApp.servet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fkit.shoppingApp.bean.Book;
import org.fkit.shoppingApp.bean.Order;
import org.fkit.shoppingApp.bean.OrderItem;
import org.fkit.shoppingApp.bean.User;
import org.fkit.shoppingApp.dao.BookDao;
import org.fkit.shoppingApp.dao.OrderDao;
import org.fkit.shoppingApp.dao.OrderItemDao;
import org.fkit.shoppingApp.util.Constant;

/**
 * 进行下订单操作
 */
@WebServlet("/order.action")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//获取书籍id
			String bookId = request.getParameter("bookId");
			//获取购买数量
			String buyNum = request.getParameter("buyNum");
			
			//获取书籍价格
			String price = request.getParameter("price");
			
			//计算书籍的总价格
			double totalPrice = Integer.valueOf(buyNum) * Double.valueOf(price);
			
			//通过 UUID生成一个随机数作为订单编号，UUID生成的随机数是不会重复的 
			String orderNo = UUID.randomUUID().toString();
			
			
			//创建Order 对象保存订单记录 ,先保存订单再保存订单明细
			Order order = new Order();
			order.setMoney(totalPrice);
			order.setOrderNo(orderNo);
			order.setCreateDate(new Date());
			
			
			User sessionUser =  (User)request.getSession().getAttribute(Constant.SESSION_USER);
			
			System.out.println("sessionUser:"+sessionUser);

			//获取用户id
			int userId = sessionUser.getId();
			
			System.out.println("usrId:"+userId);
			order.setUserId(userId);
			
			
			//创建订单明细
			OrderItem item = new OrderItem();
		
			//设置书籍id
			item.setBookId(Integer.valueOf(bookId));
			//设置购买数量
			item.setBuyNum(Integer.valueOf(buyNum));
			
			OrderDao orderDao = new OrderDao();
			
			
			
			//保存订单并获取订单的主键值
			orderDao.save(order,item);
			
			
			
			
			
			
			request.setAttribute("message", "下单成功，请注意查收您的快递！");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("message", e.getMessage());
		}
		
		
		//跳转首页
		request.getRequestDispatcher("/list.action").forward(request, response);
	
	}

}
