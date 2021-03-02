package gg.sora.controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gg.sora.dao.timelineDAO;
@WebServlet("/matchtimeline")
public class matchtimeline extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	timelineDAO dao = new timelineDAO();
	dao.timeline(request);
	request.getRequestDispatcher("test4.jsp").forward(request, response);

	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
