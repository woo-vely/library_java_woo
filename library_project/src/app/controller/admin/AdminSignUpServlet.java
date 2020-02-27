package app.controller.admin;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.bean.Admin;
import app.repository.AdminRepo;

/**
 * Servlet implementation class AdminSignUpServlet
 */
@WebServlet("/admin/signUp")
public class AdminSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 String path = "/WEB-INF/admin/signUp.jsp";
	 private AdminRepo repo;

    /**
     * @see HttpServlet#HttpServlet()
     */
	 @Override
		public void init() throws ServletException {
			super.init();
			this.repo = new AdminRepo(); 
	 }
	 public AdminSignUpServlet() {
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
		Admin admin = new Admin();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		
		System.out.println(birth);
		
		admin.setId(id);
		admin.setPassword(pw);
		admin.setName(name);
		admin.setBirth(birth);
		
		boolean success = repo.addAdmin(admin);
		
		if(success) {
			//성공하면 1. 세션만들기 2. 메인페이지로 돌아가기
			HttpSession session = request.getSession();
			response.sendRedirect(request.getContextPath()+"/admin/main");
			System.out.println("성공");
		}else {
			System.out.println("실패");
			doGet(request, response);
		}
	}

}
