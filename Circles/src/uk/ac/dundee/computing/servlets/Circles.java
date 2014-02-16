package uk.ac.dundee.computing.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ac.dundee.computing.stores.*;

import java.util.*;
/**
 * Servlet implementation class Circles
 */
@WebServlet("/Circles")
public class Circles extends HttpServlet {
	private static final long serialVersionUID = 1L;
    LinkedList<Circle> ccl= new LinkedList();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Circles() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		Circle cc=new Circle();
		cc.create(10, 20, 5);
		ccl.add(cc);
		cc=new Circle();
		cc.create(60, 30, 9);
		ccl.add(cc);
		cc=new Circle();
		cc.create(70, 60, 4);
		ccl.add(cc);
		cc=new Circle();
		cc.create(100, 30, 9);
		ccl.add(cc);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("Data", ccl);
		RequestDispatcher rdjson=request.getRequestDispatcher("/RenderJson");
		rdjson.forward(request,response);
	}

}
