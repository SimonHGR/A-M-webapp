package com.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
	throws IOException {
		System.out.println("You called my webpage!!!");
		String query = request.getQueryString();
		Map<String, String[]> paramMap = request.getParameterMap();
		Set<String> keys = paramMap.keySet();

		PrintWriter output = new PrintWriter(response.getWriter());
		
		output.println("<HTML><BODY>");
		output.println("<H1>V6 What time is it?</H1>");
		output.println("<P>" + LocalDateTime.now());
		output.println("<P>Query string is: " + query);
		output.println("<table>");
		for (String key : keys) {
			System.out.println("InLoop: key is " + key);
			output.println("<tr><td>" + key + "</td><td>" + paramMap.get(key)[0] + "</td></tr>");
		}
		output.println("</table>");
		output.println("</BODY></HTML>");
	}

}
