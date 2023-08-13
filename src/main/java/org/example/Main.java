package org.example;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        HashSet<Course> courses = new HashSet<>();
        for(int i = 1; i < 47; i++){
                Course course = session.get(Course.class, i);
                courses.add(course);
        }

        courses.forEach(course ->
                System.out.println("Наименование курса: " + course.getName()
                        + " - количество студентов: " + course.getStudentsCount()));


        sessionFactory.close();
    }
}