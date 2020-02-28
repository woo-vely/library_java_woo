package app.controller.admin;

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
 * Servlet implementation class AdminBookManageServlet
 */
@WebServlet("/admin/bookManage")
public class AdminBookManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String path = "/WEB-INF/admin/bookManage.jsp";  
	private BookRepo repo;
    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init() throws ServletException {
		super.init();
		repo = new BookRepo();
	}
    public AdminBookManageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); response.setContentType("text/html; charset=UTF-8");
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8"); response.setContentType("text/html; charset=UTF-8");
		
		String type = request.getParameter("type");
		String bSearch = request.getParameter("bookSearch");
		
		
		
		System.out.println("type: "+type);
		
		//도서 검색
		if(type.equals("lib_idid")) {
			Book b = repo.searchBookByID(bSearch);
			
			if(b!=null) {
				request.setAttribute("bSearchResult", b);
				request.getRequestDispatcher(path).forward(request, response);
				System.out.println("search ok");
			}else {
				request.setAttribute("message", "해당 도서가 없습니다.");
				System.out.println("result no");
				request.getRequestDispatcher(path).forward(request, response);
				System.out.println("search no");
			}
		}
		if(type.equals("title")) {
			Book b = repo.searchBookByTitle(bSearch);
			
			if(b!=null) {
				request.setAttribute("bSearchResultList", b);
				request.getRequestDispatcher(path).forward(request, response);
				System.out.println("search ok");
			}else {
				request.setAttribute("message", "해당 도서가 없습니다.");
				System.out.println("result no");
				request.getRequestDispatcher(path).forward(request, response);
				System.out.println("search no");
			}
		}
		
		//도서 추가
		if(type.equals("insertBook")) {
			
			String lib_idid = request.getParameter("lib_idid");
			String title = request.getParameter("title");
			String auth = request.getParameter("auth");
			String publ = request.getParameter("publ");
			String pyb = request.getParameter("pyb");
			String call_no = request.getParameter("call_no");
			int brch_code = Integer.parseInt(request.getParameter("brch_code"));
			
			System.out.println("type ok");
	
			Book ibook = new Book();
			ibook.setLib_idid(lib_idid);
			ibook.setTitle(title);
			ibook.setAuth(auth);
			ibook.setPubl(publ);
			ibook.setPyb(pyb);
			ibook.setCall_no(call_no);
			ibook.setBrch_code(brch_code);
			
			boolean insert = repo.insertBook(ibook);
			
			if(insert) {
				System.out.println("book insert ok");
				response.sendRedirect(request.getContextPath()+"/admin/bookManage");
			}else {
				System.out.println("book insert error");
				doGet(request,response);
			}
		}
		
		
	
		
	}

}

















