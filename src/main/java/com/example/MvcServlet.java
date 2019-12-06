package com.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MvcServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String coffeeType = request.getParameter("type");
		int coffeeCount = Integer.parseInt(request.getParameter("count"));
		CoffeeSalesModel model = new CoffeeSalesModel();
		model.setCount(coffeeCount);
		model.setType(coffeeType);
		request.setAttribute("count", coffeeCount);
		request.setAttribute("type", coffeeType);
		request.setAttribute("total", model.getCost());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/coffeePurchase.jsp");
		dispatcher.forward(request, response);
	}
}
