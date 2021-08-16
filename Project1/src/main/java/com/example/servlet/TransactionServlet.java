package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.service.TransfService;
import com.example.service.TransfServiceImpl;


@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/new-transaction" })
public class TransactionServlet extends HttpServlet{

	TransfService transfService = new TransfServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fromAccount = req.getParameter("fromAccount");
		String toAccount = req.getParameter("toAccount");
		double amount = Double.parseDouble(req.getParameter("amount"));
		
		transfService.txr(fromAccount, toAccount, amount);

		resp.sendRedirect("history");
	}
	
}
