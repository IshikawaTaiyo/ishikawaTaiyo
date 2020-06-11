package jp.co.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.service.InsertService;


/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
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

		InsertService ser = new InsertService();

		if(!(ser.Duplication(name) == 0)) {
			request.setAttribute("Duplication", "名前が重複しています。");
			request.getRequestDispatcher("insert.jsp").forward(request, response);
			return;
		}else if(name == null || name.isEmpty()) {
			request.setAttribute("userName", "名前は必須です");
			request.getRequestDispatcher("insert.jsp").forward(request, response);
			return;
		}else if(pass == null || pass.isEmpty()) {
			request.setAttribute("password", "passwordは必須です");
			request.getRequestDispatcher("insert.jsp").forward(request, response);
			return;
		}

		ser.insert(name, pass);

		session.setAttribute("user_name", name);
		request.getRequestDispatcher("insertResult.jsp").forward(request, response);
	}

}
