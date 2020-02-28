package app.controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.bean.Book;
import app.repository.BookRepo;

/**
 * Servlet implementation class UserBookSearchServlet
 */
@WebServlet("/user/bookSearch")
public class UserBookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String path = "/WEB-INF/user/search.jsp";
    private BookRepo bookRepo;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    @Override
    public void init() throws ServletException {
    	super.init();
    	this.bookRepo = new BookRepo();
    }
    public UserBookSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		String bSearch = request.getParameter("bookSearch");
		
		if(type.equals("title")) {
			Book b = bookRepo.searchBookByTitle(bSearch);
			
			
		}
		if(type.equals("auth")) {
			List<Book> list = bookRepo.searchBookAuth(bSearch);
			request.setAttribute("bSearchResult", list);
		}
		if(type.equals("publ")) {
			List<Book> list = bookRepo.searchBookByPubl(bSearch);
		}
		if(type.equals("pyb")) {
			List<Book> list = bookRepo.searchBookByPyb(bSearch);
			
			
		}
		
	}

}













