package jp.co.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

				//文字化け防止
				request.setCharacterEncoding("UTF-8");
				//id、passをjspから取得
				String name = request.getParameter("nameId");
				String pass = request.getParameter("pass");
				//セッションスコープを獲得
				HttpSession session = request.getSession();

				LoginService ser = new LoginService();

				if(name ==null || name.isEmpty() || pass == null || pass.isEmpty()) {
					request.setAttribute("IdPass", "名前とパスワードは必須です");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}else if(ser.roginCheck(name, pass) == 1) {
					session.setAttribute("name",name);
					session.setAttribute("plays",ser.selectNumberOfPlays(name));
					session.setAttribute("scoreMax",ser.tetrisScoreMax(name));
					session.setAttribute("scoreLast",ser.tetrisScoreLast(name));
					request.getRequestDispatcher("menu.jsp").forward(request, response);
				}else {
					request.setAttribute("IdPass", "名前かパスワードが違います");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}

	}

}
