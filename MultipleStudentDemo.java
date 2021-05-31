package com.teja.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.teja.hibernate.demo.entity.Student;

public class MultipleStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try
		{
			System.out.println("Creating new object: ");
			Student student1 = new Student("Sri", "Can", "Sri@gmail.com");
			Student student2 = new Student("Muk", "Red", "Muk@gmail.com");
			session.beginTransaction();
			System.out.println("Saving new object: ");
			session.save(student1);
			session.save(student2);
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally
		{
			factory.close();
		}
	}

}
