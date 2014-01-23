package uk.ac.dundee.computing.aec.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ac.dundee.computing.aec.stores.*;

/**
 * Servlet implementation class TestURL
 */
@WebServlet({ "/TestURL", "/TestURL/*" })
public class TestURL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestURL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		URLStorage urlBean=new URLStorage();
		urlBean.setUrl(request.getRequestURI());
		request.setAttribute("urlBean", urlBean);
	    RequestDispatcher rd=request.getRequestDispatcher("/DisplayURL.jsp");
		rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url=request.getParameter("url");
		URLStorage urlBean=new URLStorage();
		urlBean.setUrl(url);
		request.setAttribute("urlBean", urlBean);
	    RequestDispatcher rd=request.getRequestDispatcher("/DisplayURL.jsp");
		rd.forward(request,response);
	}

}
