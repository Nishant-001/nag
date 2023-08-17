package com.nagarro.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nagarro.entities.Product;
import com.nagarro.utilities.HibernateUtil1;



public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HibernateUtil1 hu1 = new HibernateUtil1();
		Session sessionHibernate1 = hu1.gethibernateSession1();
		
		HttpSession session = request.getSession();
		long id = Long.parseLong(request.getParameter("id"));
		
		Transaction tx = sessionHibernate1.beginTransaction();
		String hql = "DELETE FROM Product WHERE id= :Id " ;
		Query q = sessionHibernate1.createQuery(hql);
		q.setParameter("Id", id);
		q.executeUpdate();
		tx.commit();
		
		hql = "FROM Product";
		Query q1 = sessionHibernate1.createQuery(hql);
		List<Product> output = q1.getResultList();
		
		session.setAttribute("productList", output );
		response.sendRedirect("PMT.jsp");
		
	}

}
