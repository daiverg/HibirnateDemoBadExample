package com.luv2code.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

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
						
//			get Courses for the Instructor
						
			System.out.println("Courses " + tempInstructor1.getCourses());
									
						
			session.getTransaction().commit();
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
