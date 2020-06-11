package jp.co.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.co.service.UpdateService;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//セッションスコープを獲得
		HttpSession session = request.getSession();
		UpdateService ser =new UpdateService();


		String score1 = request.getParameter("score");
		System.out.println(score1);
		String name = (String) session.getAttribute("name");
		int score = Integer.parseInt(score1);
		int plays = ser.selectNumberOfPlays(name);
		plays = plays + 1;

		ser.updateLast(score, name);
		ser.updateNumberOfPlays(plays, name);
		session.setAttribute("scoreLast",ser.tetrisScoreLast(name));

		session.setAttribute("plays", ser.selectNumberOfPlays(name));

		if(score >= ser.tetrisScoreMax(name)) {
			ser.updateMax(score, name);
		}

		session.setAttribute("scoreMax",ser.tetrisScoreMax(name));

		request.getRequestDispatcher("menu.jsp").forward(request, response);



	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
