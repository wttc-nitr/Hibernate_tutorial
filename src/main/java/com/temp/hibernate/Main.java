package com.temp.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        // create hibernate configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        // let configuration know that there is an entity Song
        configuration.addAnnotatedClass(Song.class);
        // create session factory to manage Session. SessionFactory is an heavy object, don't create it multiple times. causes performance issues
        // you can create multiple times if let's say you've different db (so different username, password, url etc).
        // you can create multiple Session though.
        // SessionFactory is immutable
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();) {
            // initialize the session object
            Session session = sessionFactory.openSession();

            Song song1 = new Song();
            song1.setSongId(13);
            song1.setSongName("Bink's sake");
            song1.setSongArtist("Brook");

            session.beginTransaction();
            session.persist(song1);
            session.getTransaction().commit();

            session.close();

            System.out.println("song saved...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}