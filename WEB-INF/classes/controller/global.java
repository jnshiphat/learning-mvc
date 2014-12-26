package controller;

import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;


public class global extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		PrintWriter r=response.getWriter();
		r.println("Global Controller Demo");
        System.out.println("***global controller class");
		String url=request.getRequestURL().toString();
		System.out.println(url);
		System.out.println(url.contains("login"));
		if(url.contains("login"))// && request.getParameter("isAuthorized")
		{	
			//boolean isAuthorized=true;
			//request.setParameter("isAuthorized",isAuthorized);
			RequestDispatcher dispatcher = null;
            System.out.println("dispatching to login controller->");
    		dispatcher = request.getRequestDispatcher("/login/controller");
			dispatcher.forward(request, response);
		}
    	
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	doGet(request, response);
    }
}