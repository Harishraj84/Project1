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
import com.example.service.TransfService;
import com.example.service.TransfServiceImpl;

@WebServlet(urlPatterns = { "/limitt" })
public class TxnLimit extends HttpServlet{

	private TxnRepo transactionRepository = new TxnRepoImpl();
	static String account;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int limit1=Integer.parseInt(req.getParameter("limit1"));
	account = req.getParameter("account");
	List<Txn> txns = transactionRepository.getTxn(TxnLimit.account,limit1);
	req.setAttribute("trans", txns);
	req.getRequestDispatcher("history.jsp").forward(req,resp);
	}
	
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		
//		List<Txn> trans = transactionRepository.getTxn();
//		req.setAttribute("trans", trans);
////		resp.sendRedirect("limitt.jsp");
//		req.getRequestDispatcher("limitt.jsp").forward(req, resp);
//	}
	
}
