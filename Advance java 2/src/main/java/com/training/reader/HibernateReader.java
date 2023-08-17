package com.training.reader;

import com.training.model.TShirt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.jetbrains.annotations.NotNull;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.util.List;


public class HibernateReader {
    private final TShirt tshirt;
    private final String sortingOrder;
    Logger logger = Logger.getLogger(HibernateReader.class.getName());

    public HibernateReader(TShirt tShirt, String sortingOrder) {
        this.tshirt = tShirt;
        this.sortingOrder = sortingOrder;
    }

    public void sortingTShirt() {
        SessionFactory factory = new Configuration().configure().
                addAnnotatedClass(TShirt.class).buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();
        String color = tshirt.getColour();
        String gender = tshirt.getGender();
        String size = tshirt.getSize();
        Query query = null;

        if ("rating".equalsIgnoreCase(sortingOrder)) {
            query = session.createQuery("from TShirt where colour = :color and " +
                    "gender = :gender and size = :size order by rating desc");
        } else if ("price".equalsIgnoreCase(sortingOrder) || ("both").equalsIgnoreCase(sortingOrder)) {
            query = session.createQuery("from TShirt where colour = :color and " +
                    "gender = :gender and size = :size order by price asc");
        } else {
            logger.log(Level.INFO, " Please Enter A Valid Input");
        }

        if (query != null) {
            query.setParameter("color", color);
            query.setParameter("gender", gender);
            query.setParameter("size", size);

            List<TShirt> TShirtList = query.getResultList();

            showTShirt(TShirtList);
        }

        session.getTransaction().commit();
        session.close();
        factory.close();
    }

    public void showTShirt(@NotNull List<TShirt> sortedList) {
        if (sortedList.size() > 0) {
            int no = 1;
            for (TShirt shirt : sortedList) {
                System.out.println("----------------T-Shirt " + no + "----------------");
                System.out.println("Id: " + shirt.getId());
                System.out.println("Name: " + shirt.getName());
                System.out.println("Colour: " + shirt.getColour());
                System.out.println("Gender: " + shirt.getGender());
                System.out.println("Size: " + shirt.getSize());
                System.out.println("Price: " + shirt.getPrice());
                System.out.println("Rating: " + shirt.getRating());
                System.out.println("Availability: " + shirt.getAvailability());
                no++;
            }
        }else {
            logger.log(Level.INFO, " TShirt not Available");
        }
    }
}
