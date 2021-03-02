package gg.sora.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gg.sora.dao.DAO;

@WebServlet("/serch")
public class serch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAO dao = new DAO();
		dao.sumsearch(request);
		dao.matchl(request);
		dao.ingamenow(request);
	//	request.setAttribute("contentPage", "output.jsp");
	//	request.setAttribute("summonerPage", "match.jsp");
		request.getRequestDispatcher("test.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
