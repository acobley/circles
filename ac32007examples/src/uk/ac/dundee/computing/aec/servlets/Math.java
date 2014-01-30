package uk.ac.dundee.computing.aec.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.ac.dundee.computing.aec.lib.*;
/**
 * Servlet implementation class Math
 */
@WebServlet({ "/Math", "/Math/*" })
public class Math extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap CommandsMap = new HashMap();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Math() {
        super();
        // TODO Auto-generated constructor stub
   
        // TODO Auto-generated constructor stub
        CommandsMap.put("Mult",1);
        CommandsMap.put("Div",2);
        CommandsMap.put("Add",3);
        CommandsMap.put("Sub",4);
        CommandsMap.put("Root",5);
        CommandsMap.put("Pow",6);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Convertors ut = new Convertors();
		String args[]=ut.SplitRequestPath(request);
		response.setContentType("text/html");
		//We are expecting /Math/Math/mult/1/2 or
		// /Math/Math/root/24
		PrintWriter out=null;
		out =	new PrintWriter(response.getOutputStream());
		
		if (args.length <3){
			error("Warning too few args",out);
			
			return;
			
		}
		int command;
		try{
		   command =(Integer)CommandsMap.get(args[2]);
		}catch(Exception et){
			error("Bad Operator",out);
			return;
		}
		System.out.println("Cammand"+command);
		float x;
		float y;
		try{
		   x=Float.parseFloat(args[3]);
		   y=Float.parseFloat(args[4]);
		}catch(Exception et){
			error("Bad numbers in calc",out);
			return;			
		}
		switch (command){
		   case 1: mult(x,y,out);
		          break;
		   case 2: div(x,y,out);
	          break;
		   case 3: add(x,y,out);
	          break;
		   case 4: sub(x,y,out);
	          break;
		   case 5: root(x,out);
	          break;
		   case 6: power(x,y,out);
	          break;   
		   default: error("Bad Operator",out);
		}
	}

	private void mult(float x, float y, PrintWriter out ){
		
		float result=x*y;
		out.println("<h1>Result</h1>");
		out.println("<h2>"+result+"</h2>");
		out.close();
	}
	
private void div(float x, float y, PrintWriter out ){
		
		float result=x/y;
		out.println("<h1>Result</h1>");
		out.println("<h2>"+result+"</h2>");
		out.close();
	}
	private void error(String mess, PrintWriter out){
		out.println("<h1>You have a na error in your input</h1>");
		out.println("<h2>"+mess+"</h2>");
		out.close();
		return;
	}
	
private void add(float x, float y, PrintWriter out ){
		
		float result=x+y;
		out.println("<h1>Result</h1>");
		out.println("<h2>"+result+"</h2>");
		out.close();
	}
private void sub(float x, float y, PrintWriter out ){
	
	float result=x-y;
	out.println("<h1>Result</h1>");
	out.println("<h2>"+result+"</h2>");
	out.close();
}

private void power(float x, float y, PrintWriter out ){

	double result=java.lang.Math.pow((double)x,(double)y);
	out.println("<h1>Result</h1>");
	out.println("<h2>"+result+"</h2>");
	out.close();
}

private void root(float x, PrintWriter out ){
	
	double result = java.lang.Math.sqrt((double)x);
	out.println("<h1>Result</h1>");
	out.println("<h2>"+result+"</h2>");
	out.close();
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
