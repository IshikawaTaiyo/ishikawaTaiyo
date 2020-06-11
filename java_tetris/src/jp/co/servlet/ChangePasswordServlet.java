package jp.co.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.service.ChangePasswordService;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
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
		String pass = request.getParameter("pass");
		String newPass = request.getParameter("newPass");

		//セッションスコープを獲得
		HttpSession session = request.getSession();
		String setSelectPssword = (String) session.getAttribute("setSelectPssword");
		String name = (String) session.getAttribute("name");

		ChangePasswordService ser = new ChangePasswordService();

		if((pass == null || pass.isEmpty()) || (newPass == null || newPass.isEmpty())) {
			request.setAttribute("notPassword", "現在のパスワードと新しいパスワードが入力されていません");
			request.getRequestDispatcher("pass.jsp").forward(request, response);
		}else if(!(pass.equals(setSelectPssword))) {
			request.setAttribute("notPassword", "現在のパスワードが違います");
			request.getRequestDispatcher("pass.jsp").forward(request, response);
		}else if(pass.equals(setSelectPssword)) {
			ser.updatePassword(newPass, name);
			request.getRequestDispatcher("passResult.jsp").forward(request, response);
		}

	}

}
