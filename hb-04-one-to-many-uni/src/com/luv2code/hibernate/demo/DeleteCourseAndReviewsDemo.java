package com.luv2code.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class DeleteCourseAndReviewsDemo {

	public static void main(String[] args) {
// create session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();		

//	create session		

		Session session = factory.getCurrentSession();
		
try {
			int theId=14;
//			start transaction
			session.beginTransaction();
			Course tempCourse = session.get(Course.class, theId);
			
			session.delete(tempCourse);
			
			
			session.getTransaction().commit();
			session.close();
						
		}
		finally {
			session.close();
			factory.close();
		}
		
	}

}
