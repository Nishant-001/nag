package com.nagarro.utilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.entities.User;

public class HibernateUtil {

	public Session gethibernateSession() {
		Session sessionHibernate;

		SessionFactory factory;

		factory = new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
		sessionHibernate = factory.openSession();

		return sessionHibernate;
	}

}
