package jp.co.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.service.SelectService2;

/**
 * Servlet implementation class SelectServlet2
 */
@WebServlet("/SelectServlet2")
public class SelectServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet2() {
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

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("userName");

		//セッションスコープを獲得
		HttpSession session = request.getSession();

		SelectService2 ser =new SelectService2();

		if(name == null || name.isEmpty()) {
			request.setAttribute("notUser", "名前が入力されていません。");
			request.getRequestDispatcher("select.jsp").forward(request, response);
		}else if(ser.searchUserSize(name) == 0) {
			request.setAttribute("notUser", "そのユーザーはありません。");
			request.getRequestDispatcher("select.jsp").forward(request, response);
		}else {
			request.setAttribute("numberSearch", ser.searchUserSize(name));
			session.setAttribute("searchUser", ser.searchUser(name));

			request.getRequestDispatcher("searchUser.jsp").forward(request, response);

		}

	}

}
