package com.productionDataClientProductionDataMain;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StartByWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException 
    {
		
		
		//RequestDispatcher rd = request.getRequestDispatcher("completed.jsp");
		//rd.forward(request,response);
	 }
}
