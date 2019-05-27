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
 * 展示书籍明细
 */
@WebServlet("/detail.action")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取书籍id
		String bookId = request.getParameter("bookId");
		
		
		BookDao bookDao = new BookDao();
		
		//根据书籍id获取书籍信息
		Book book = bookDao.getBookById(Integer.valueOf(bookId));
		
		//将书籍信息存储在request中
		request.setAttribute("book", book);
		//跳转至展示书籍明细的页面
		request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(request, response);
	}

}
