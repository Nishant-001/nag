package com.nagarro.utilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.entities.Product;

public class HibernateUtil1 {
	
	public Session gethibernateSession1() {
		
		Session sessionHibernate1;
		SessionFactory factory;

		factory = new Configuration().configure().addAnnotatedClass(Product.class).buildSessionFactory();
		sessionHibernate1 = factory.openSession();

		return sessionHibernate1;
	}

}