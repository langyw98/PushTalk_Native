package org.pushtalk4native.server.web.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class NormalBaseServlet extends HttpServlet {
    private static final long serialVersionUID = 1138134467003532522L;
    private static final Logger LOG = LoggerFactory.getLogger(NormalBaseServlet.class);

	public abstract void process(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		process(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		process(request, response);
	}
	
    protected void responseError(HttpServletResponse response, String s) throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.getWriter().println("<h3>" + s + "</h3>");
    }

    protected void responseContent(HttpServletResponse response, String s) throws IOException {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(s);
    }
    
    
}
