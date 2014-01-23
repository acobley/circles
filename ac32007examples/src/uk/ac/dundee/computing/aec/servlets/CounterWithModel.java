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
 * Servlet implementation class CounterWithModel
 */
@WebServlet("/CounterWithModel")
public class CounterWithModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounterWithModel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    RequestDispatcher rd=request.getRequestDispatcher("/DisplayCount.jsp");
	    CountStore Store=new CountStore();
		synchronized(this) { // Must Synchronise
			Store.incrementCounter();
		}
		URLStorage urlBean=new URLStorage();
		urlBean.setUrl(""+Store.getCounter());
		request.setAttribute("urlBean", urlBean);  
		rd.forward(request,response);  
	}
}

