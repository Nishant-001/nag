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

@MultipartConfig(maxFileSize = 1024*500)
public class EditProduct extends HttpServlet {
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
		HibernateUtil1 hu1 = new HibernateUtil1();
		Session sessionHibernate1 = hu1.gethibernateSession1();

		Long id = Long.parseLong(request.getParameter("id"));

		String title = request.getParameter("title");
		int size = Integer.parseInt(request.getParameter("size"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Part img = request.getPart("image");
		String fileName = extractFileName(img);

		Transaction tx = sessionHibernate1.beginTransaction();
		// String hql = "From Product WHERE Id =:c";
		String hql1 = "UPDATE Product SET title_c = :title, size_c = :size, quantity_c = :quantity, imagePath_c = :imgPath WHERE id = :id";
		Query query1 = sessionHibernate1.createQuery(hql1);
		query1.setParameter("id", id);

		query1.setParameter("title", title);
		query1.setParameter("size", size);
		query1.setParameter("quantity", quantity);
		query1.setParameter("imgPath", fileName);
		query1.executeUpdate();

		tx.commit();

		hql1 = "from Product";
		query1 = sessionHibernate1.createQuery(hql1);
		List<Product> list = query1.getResultList();
		HttpSession session = request.getSession();
		session.setAttribute("productList", list);

		response.sendRedirect("PMT.jsp");
	}

}
