package com.nagarro.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nagarro.entities.Product;
import com.nagarro.utilities.HibernateUtil1;

@MultipartConfig(maxFileSize = 500 * 1024)
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;


	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Part img = request.getPart("image");

		String fileName = extractFileName(img);

		String title = request.getParameter("title");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int size = Integer.parseInt(request.getParameter("size"));

		Product product = new Product();
		product.setTitle_c(title);
		product.setQuantity_c(quantity);
		product.setSize_c(size);
		product.setImagePath_c(fileName);

		HibernateUtil1 hu = new HibernateUtil1();
		Session sessionHibernate1 = hu.gethibernateSession1();

		Transaction tx = sessionHibernate1.beginTransaction();
		sessionHibernate1.save(product);
		tx.commit();

		HttpSession session = request.getSession();
		String hql = "from Product";
		Query query = sessionHibernate1.createQuery(hql);
		List<Product> productList = query.getResultList();
		session.setAttribute("productList", productList);

		response.sendRedirect("PMT.jsp");

	}
}
