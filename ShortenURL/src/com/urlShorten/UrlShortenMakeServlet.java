package com.urlShorten;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

public class UrlShortenMakeServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, java.io.IOException{
		doGet(req, res);
	}

	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, java.io.IOException{
		
		String oriUrl = req.getParameter("origin_url");
		//System.out.println("oriUrl==============================: "+ oriUrl );
		String rst;
		
		rst = URLShortener.getInstance().shortenURL(oriUrl);
		//값 반환
		req.setAttribute("resurl", rst);
		req.setAttribute("oriurl", oriUrl);

		//System.out.println("rst==============================: "+ rst );
		
		RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
		rd.forward(req, res);
	}

}
