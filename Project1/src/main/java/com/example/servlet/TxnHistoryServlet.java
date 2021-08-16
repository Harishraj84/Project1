package com.example.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.entity.Txn;
import com.example.repository.TxnRepo;
import com.example.repository.TxnRepoImpl;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = { "/history" })
public class TxnHistoryServlet extends HttpServlet{

	
	private TxnRepo transactionRepository = new TxnRepoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Txn> trans = transactionRepository.getTxn();
		req.setAttribute("trans", trans);
		req.getRequestDispatcher("history.jsp").forward(req, resp);
	}
	
}