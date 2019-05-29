package com.logout;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutAction extends HttpServlet {
    public LogoutAction(){
        super();
    }
    public void destroy(){
        super.destroy();
    }
    public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //PrintWriter out = response.getWriter();
        String path= request.getContextPath();
        String action_flag=request.getParameter("action_flag");

        //boolean flag=service.Login(params);
        if(action_flag.equals("logout")){
            request.getSession().removeAttribute("username");
            response.sendRedirect(path+"/index.jsp");
        }
    }
    public void init() throws ServletException{

    }
}
