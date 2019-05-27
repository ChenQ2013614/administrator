/**
 * 
 */
package org.fkit.shoppingApp.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 亲爱的琼
 * Version 1.0
 */
public class CookieUtils {
	
	
	public static void addCookie(String cookieName,String value,int age,HttpServletRequest request,HttpServletResponse response) {
		
		Cookie  cookie = getCookieByName(cookieName,request);
		if(cookie == null) {
		  
			cookie = new Cookie(cookieName,value);
		}
		//更新Cookie的value值
		cookie.setValue(value);
		//更新Cookie的存活时间
		cookie.setMaxAge(age);
		//设置cookie的作用域      request.getContextPath()： /项目名
		cookie.setPath(request.getContextPath());
		//将cookie响应至客户端|浏览器
		response.addCookie(cookie);
	}
	
	
	
	//根据Cookie名字获取Cookie
    public static Cookie getCookieByName(String cookieName,HttpServletRequest request) {
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null) {
    		for(Cookie cookie : cookies) {
    			if(cookie.getName().equals(cookieName)) {
    				return cookie;
    			}
    		}
    	}
    	return null;
    }



	/**
	 * @param remName
	 * @param request 
	 * @param response
	 */
	public static void removeCookie(String remName, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//先根据cookie名字获取cookie
		Cookie cookie = getCookieByName(remName,request);
		if(cookie !=null) {
			//更新Cookie的存活时间
			cookie.setMaxAge(0);
			//设置cookie的作用域      request.getContextPath()： /项目名
			cookie.setPath(request.getContextPath());
			//将cookie响应至客户端|浏览器
			response.addCookie(cookie);
		}
	}
}
