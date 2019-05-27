package org.fkit.shoppingApp.servet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fkit.shoppingApp.bean.Book;
import org.fkit.shoppingApp.dao.BookDao;
import org.fkit.shoppingApp.dao.UserDao;

/**
 * 用户注册
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			
			//获取登录名
			String loginName = request.getParameter("loginName");
			//获取密码
			String password = request.getParameter("pass");
			//获取真实姓名
			String realName = request.getParameter("realName");
			
			
			//调用userDao
			UserDao userDao = new UserDao();
			
			//保存数据至数据库    --   保存之前应该先判断账号是否存在 ，账号应该是唯一
			userDao.save(loginName,password,realName);
			
			request.setAttribute("message", "注册成功！");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("message", "注册失败！");
		}
		
		
		//跳转登录页面
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	
	}

}
