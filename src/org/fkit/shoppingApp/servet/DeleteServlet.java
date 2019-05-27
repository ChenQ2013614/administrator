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

/**
 * 删除书籍信息
 */
@WebServlet("/delete.action")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
			if(bookId == null || bookId.equals("")) {
				request.setAttribute("message", "删除失败！");	
			}else {
				BookDao bookDao = new BookDao();
				//根据书籍id删除书籍信息
				bookDao.deleteBookById(Integer.valueOf(bookId));
				request.setAttribute("message", "删除成功!！");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("message", "删除失败！");
		}
		
		
		//跳转首页
		request.getRequestDispatcher("/list.action").forward(request, response);
	
	}

}
