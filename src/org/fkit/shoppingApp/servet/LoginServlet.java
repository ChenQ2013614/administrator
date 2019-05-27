package org.fkit.shoppingApp.servet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.fkit.shoppingApp.bean.User;
import org.fkit.shoppingApp.dao.UserDao;
import org.fkit.shoppingApp.util.Constant;
import org.fkit.shoppingApp.util.CookieUtils;

/**
 * 处理用户登录请求
 */
@WebServlet("/userLogin")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			//获取用户的请求参数
			String userName = request.getParameter("userName");
			String password = request.getParameter("pass");
			
			String rem = request.getParameter("rem");
			
			//是否需要记住一周
			if("checked".equals(rem)) {
				CookieUtils.addCookie(Constant.REM_NAME, userName+"_"+password, 7*24*60*60, request, response);
			}
			
			//创建UserDao 对象
			UserDao userDao = new UserDao();
			
			User user = userDao.getUserByNameAndPass(userName, password);
			
			if(user != null) {
				//将用户的信息
				request.getSession().setAttribute(Constant.SESSION_USER, user);
				//跳转至首页
				request.getRequestDispatcher("/list.action").forward(request, response);
			}else {
				//跳转至登录页面
				request.setAttribute("message", "您输入的账号或密码跑到火星去了，请核实！");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			request.setAttribute("message", "登录失败！");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
		
		
	}

}
