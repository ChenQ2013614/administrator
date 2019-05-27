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
 * 用户退出
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//将用户的信息从session中清除或者直接让session失效
		request.getSession().invalidate();
		
		//将用户信息从Cookie中清掉
		CookieUtils.removeCookie(Constant.REM_NAME,request,response);
		
		//跳转至登录页面
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
		
	}

}
