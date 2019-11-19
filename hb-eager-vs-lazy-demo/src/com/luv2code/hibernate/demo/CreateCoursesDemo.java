package com.luv2code.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

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
			
//			start transaction
			session.beginTransaction();
			System.out.println("Begin transaction");
			
//			get object from db
			int theId = 2;
			
			Instructor tempInstructor = session.get(Instructor.class, theId);
						
//			create some objects (courses)
			Course tempCourse1 = new Course("Ps gaming guide");
			Course tempCourse2 = new Course("Driver masterclass");

//			add courses to Instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
						
			
//			save object 
			session.save(tempCourse1);
			session.save(tempCourse2);
						
			
			session.getTransaction().commit();
			System.out.println("Done");
			
			
			
			
		}
		finally {
			session.close();
			System.out.println("Session closed");
			factory.close();
		}
		
	}

}
