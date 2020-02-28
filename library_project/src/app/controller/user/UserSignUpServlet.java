package app.controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.bean.User;
import app.repository.UserRepo;

/**
 * Servlet implementation class UserSignUpServlet
 */
@WebServlet("/user/signUp")
public class UserSignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String path = "/WEB-INF/user/signUp.jsp";
    private UserRepo userRepo;
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	this.userRepo = new UserRepo(); 
    }
    public UserSignUpServlet() {
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
		String id = request.getParameter("id");
		String pw = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		
		User u = new User();
		u.setId(id);
		u.setPassword(pw);
		u.setName(name);
		u.setGender(gender);
		
		boolean ok = userRepo.addUser(u);
		
		if(ok) {
			System.out.println("signup ok");
			response.sendRedirect(request.getContextPath()+"/user/main");
		}else {
			System.out.println("signup error");
			doGet(request, response);
		}
		
		
	}

}
