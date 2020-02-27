package app.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.bean.Admin;
import app.repository.AdminRepo;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String path = "/WEB-INF/admin/login.jsp";
    private AdminRepo repo;
    /**
     * @see HttpServlet#HttpServlet()
     */
    @Override
    public void init() throws ServletException {
    	super.init();
    	repo = new AdminRepo();
    }
    public AdminLoginServlet() {
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
		String pw = request.getParameter("pw");
		
		admin.setId(id);
		admin.setPassword(pw);
		
		boolean success = repo.loginAdmin(admin);
		if(success) {
			HttpSession session = request.getSession();
			response.sendRedirect(request.getContextPath()+"/admin/main");
		}else {
			doGet(request, response);
		}
	}

}
