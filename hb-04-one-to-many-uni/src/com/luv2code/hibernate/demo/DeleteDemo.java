package com.luv2code.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

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
			
			int theId = 1;

//			start transaction	
			session.beginTransaction();
			System.out.println("Begin transaction");
			
			
//			get object by id
			Instructor tmpInstr = session.get(Instructor.class, theId);
						
//			delete object
			if (tmpInstr != null) {
				session.delete(tmpInstr);
			}
		
						
			
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
