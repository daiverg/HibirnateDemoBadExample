package com.luv2code.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

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
//			create the object
			Instructor tempInstructor = new Instructor("Susan", "Public", "spublic@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail(
					"http://www/luv2code.com",
					"Gamers"
					);
			
//			associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
//			start transaction
			session.beginTransaction();
			System.out.println("Begin transaction");
			
//			save object (instructor)
//			this will also save the detail object
//			because of CascadeType.all
			System.out.println("Saving to data base object : " + tempInstructor.toString());
			session.save(tempInstructor);
						
			
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
