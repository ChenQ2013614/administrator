package org.fkit.shoppingApp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.fkit.shoppingApp.bean.User;
import org.fkit.shoppingApp.dao.UserDao;
import org.fkit.shoppingApp.util.Constant;
import org.fkit.shoppingApp.util.CookieUtils;

/**
 * 登录拦截器
 * 如果用户没有登录那么不能进入首页，不能进行删除等等一系列操作
 */
@WebFilter("*.action")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//从session中获取用户信息
		User user = (User)((HttpServletRequest)request).getSession().getAttribute(Constant.SESSION_USER);
		if(user == null) {
			
			//session中没有用户信息，继续判断 Cookie中是否存在用户的信息（账号以及密码）
			Cookie cookie = CookieUtils.getCookieByName(Constant.REM_NAME, (HttpServletRequest)request);
			if(cookie == null) {
				//说明session没有用户信息，并且Cookie中也没有用户信息
				request.setAttribute("message", "您尚未登录，或登录已超时！");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else {
				//从Cookie中取出用户的信息
				String userInfo = cookie.getValue();
				//获取账号以及密码
				String[] infos = userInfo.split("_");
				
				UserDao userDao = new UserDao();
				
				User u = userDao.getUserByNameAndPass(infos[0], infos[1]);
				if(u!=null) {
					//说明cookie存在用户信息，并且该信息还是有效的
					
					//将用户信息存放在session
					((HttpServletRequest)request).getSession().setAttribute(Constant.SESSION_USER,u);
					
					chain.doFilter(request, response); //放行
				}else {
					request.setAttribute("message", "您尚未登录，或登录已超时！");
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				}
			}
			
			
			
			//request.setAttribute("message", "您尚未登录，或登录已超时！");
			
			//跳转至登录页面
			//request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else {
			// pass the request along the filter chain
			chain.doFilter(request, response); //放行
		}

		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
