package com.urlShorten;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

public class UrlShortenServlet extends HttpServlet {
	public void init(){
		
		String urls[] = new String[100];
	}

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, java.io.IOException{
		doGet(req, res);
	}
	
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, java.io.IOException{
		String reqURI = req.getRequestURI();
		String indexURI = "/index.jsp";
		String rdURL = "/index.jsp";
		
	//	System.out.println("reqURI-------------------------------: " + reqURI);
		
		if(!indexURI.equals(reqURI)){
			rdURL = URLShortener.getInstance().expandURL(URLShortener.getInstance().getDomain()+reqURI);
			
		}else{
			
		}

		res.sendRedirect(rdURL);
	}

}
