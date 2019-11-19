package com.luv2code.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
// create session Factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();		

//	create session		

		Session session = factory.getCurrentSession();
		
try {
			
//			start transaction
			session.beginTransaction();
			
			Course tempCourse = new Course("packman course");
			session.save(tempCourse);
			
			
			Student tempStudent1 = new Student("john","Doe","john@gmail.com");
			Student tempStudent2 = new Student("Susan","Busikov","sbusikov@gmail.com");

			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			
			session.save(tempStudent1);
			session.save(tempStudent2);
			
			session.getTransaction().commit();
		
						
		}
		finally {
			session.close();
			factory.close();
		}
		
	}

}
