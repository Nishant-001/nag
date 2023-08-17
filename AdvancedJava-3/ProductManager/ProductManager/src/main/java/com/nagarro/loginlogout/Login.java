package com.nagarro.loginlogout;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.nagarro.entities.Product;
import com.nagarro.entities.User;
import com.nagarro.utilities.HibernateUtil;
import com.nagarro.utilities.HibernateUtil1;





public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hiiiiii");
		String uname = request.getParameter("name");
		String pass = request.getParameter("password");

		HibernateUtil hu = new HibernateUtil();
		Session sessionHibernate = hu.gethibernateSession();

		String hql = "from User WHERE Username = :uN";

		Query query = sessionHibernate.createQuery(hql);
		query.setParameter("uN", uname);
		User user = (User) query.uniqueResult();

		if (user == null) {
//			user does not exist
//			System.out.println("Username Doesnot Exists!");
			response.sendRedirect("index.jsp");
		} else {
			if (user.getPassword().equals(pass)) {
				HibernateUtil1 hu1 = new HibernateUtil1();
				Session sessionHibernate1 = hu1.gethibernateSession1();
				HttpSession session = request.getSession();
				String hql1 = "from Product";
				Query query1 = sessionHibernate1.createQuery(hql1);
				List<Product> output = query1.getResultList();
				session.setAttribute("username", uname);
				session.setAttribute("productList", output);
				response.sendRedirect("PMT.jsp");
			} else {
				response.sendRedirect("index.jsp");
			}
		}
	}

}
