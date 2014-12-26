package controller;

import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;

import model.UserBean;

public class LoginControl extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
		
        
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        PrintWriter r=response.getWriter();
        RequestDispatcher dispatcher = null;
        
        HttpSession session = request.getSession(true);
        
        //model.UserBean bean = new model.UserBean();
        UserBean bean = new UserBean();

        bean.setUserName(request.getParameter("userName"));
        bean.setPassword(request.getParameter("password"));
        String error = "";
        
        if(!bean.checkValid().equals("valid")) {
            error = bean.checkValid();
            request.setAttribute("error", error);
            dispatcher = request.getRequestDispatcher("/index");
            dispatcher.forward(request, response);
        }
        else {
            session.setAttribute("bean", bean);
            response.sendRedirect("/mvc-project/home");
        }

    }
}