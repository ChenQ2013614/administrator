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
 * 展示首页商品信息
 */
@WebServlet("/list.action")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BookDao bookDao = new BookDao();
		
		//获取所有的书籍信息
		List<Book> books = bookDao.getAllBook();
		
		//将书籍信息存储在request中
		request.setAttribute("books", books);
		//跳转至首页
		request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request, response);
	}

}
