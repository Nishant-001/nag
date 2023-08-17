package com.training.parser;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.training.model.TShirt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
import java.io.FileReader;

public class ReadCSV {
    private final File[] files;
    private final SessionFactory factory;

    public ReadCSV(File[] files) {
        this.files = files;
        factory = new Configuration().configure()
                .addAnnotatedClass(TShirt.class).buildSessionFactory();
    }

    public void importData() {
        for (File file : files) {
            try {
                CSVParser parser = new CSVParserBuilder().withSeparator('|').build();
                CSVReader reader = new CSVReaderBuilder(new FileReader(file)).
                        withCSVParser(parser).withSkipLines(1).build();

                String[] line;
                while ((line = reader.readNext()) != null) {
                    Session session = factory.openSession();
                    session.beginTransaction();

                    TShirt tShirt = session.get(TShirt.class, line[0]);
                    if (tShirt == null) {
                        TShirt tshirt = new TShirt(line[0], line[1], line[2], line[3], line[4],
                                Float.parseFloat(line[5]), Float.parseFloat(line[6]), line[7]);
                        session.save(tshirt);
                        session.getTransaction().commit();
                    }
                    session.close();
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        factory.close();
    }

}
