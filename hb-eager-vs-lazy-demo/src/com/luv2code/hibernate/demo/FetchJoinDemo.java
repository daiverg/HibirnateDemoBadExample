package com.luv2code.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
// create session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();		

//	create session		

		Session session = factory.getCurrentSession();
		
		try {
			int theId = 1;
			
//			start transaction	
			session.beginTransaction();
			
			
//			option with hibernate HQL
			Query<Instructor> query = session.createQuery(
					"select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+ "where i.id=:theInstructorId",
					Instructor.class
					);
					
//			set parameter on query
			query.setParameter("theInstructorId", theId);
			
//			execute query and get object
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("my app " + tempInstructor.getFirstName());
			
		
						
			session.getTransaction().commit();
			session.close();
			
			
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
			
		}
		finally {
			session.close();
			factory.close();
		}
		
	}

}
