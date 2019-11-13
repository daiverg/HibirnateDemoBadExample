package com.luv2code.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			int id = 4;
//			start transaction	
			session.beginTransaction();
			System.out.println("Begin transaction");
			
//			get instructor detail
			InstructorDetail instDet = session.get(InstructorDetail.class, id);
			
//			remove the associated object reference
//			break bi-directional link
			instDet.getInstructor().setInstructorDetail(null);
			
			session.delete(instDet);			
			
						
			session.getTransaction().commit();
			System.out.println("Done");
						
			
			
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
