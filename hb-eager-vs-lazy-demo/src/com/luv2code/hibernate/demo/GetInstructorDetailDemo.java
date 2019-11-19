package com.luv2code.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

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
			int id = 223;
//			start transaction	
			session.beginTransaction();
			System.out.println("Begin transaction");
			
//			get instructor detail
			InstructorDetail instDet = session.get(InstructorDetail.class, id);
			
						
			System.out.println("instructor detail : " + instDet);
//			print associated instructor
			System.out.println("assosiated info : " + instDet.getInstructor());
			
						
			session.getTransaction().commit();
			System.out.println("Done");
						
			
			System.out.println("Session closed");
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
