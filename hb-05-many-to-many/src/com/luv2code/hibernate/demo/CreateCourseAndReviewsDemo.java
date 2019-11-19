package com.luv2code.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;

public class CreateCourseAndReviewsDemo {

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
			
//			start transaction
			session.beginTransaction();
			Course tempCourse = new Course("packman course");
			
			tempCourse.addReview(new Review("great course...."));
			tempCourse.addReview(new Review("1great course1...."));
			tempCourse.addReview(new Review("2great course2...."));
			
			
			session.save(tempCourse);			
			
			session.getTransaction().commit();
		
						
		}
		finally {
			session.close();
			factory.close();
		}
		
	}

}
