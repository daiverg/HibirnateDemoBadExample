package com.luv2code.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

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
			int theId1 = 1;
			
//			start transaction	
			session.beginTransaction();
			
			Instructor tempInstructor1 = session.get(Instructor.class, theId1);
			System.out.println("my app Instructor: " + tempInstructor1);
			
			
			System.out.println("my app Courses " + tempInstructor1.getCourses());
			
			
//			get Courses for the Instructor
						
			session.getTransaction().commit();
			
			
			session.close();
			
			System.out.println("my app Courses " + tempInstructor1.getCourses());
			
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
