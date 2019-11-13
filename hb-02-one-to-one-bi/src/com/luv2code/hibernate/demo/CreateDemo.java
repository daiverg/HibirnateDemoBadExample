package com.luv2code.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {
// create session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();		

//	create session		

		Session session = factory.getCurrentSession();
		
		try {
//			create the object
			Instructor tempInstructor = new Instructor("madhu", "duble", "duble@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail(
					"http://www/luv2code.com",
					"Guitar!!!"
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
			
			
			
			session.close();
			System.out.println("Session closed");
		}
		finally {
			factory.close();
		}
		
	}

}
