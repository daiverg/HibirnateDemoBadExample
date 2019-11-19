package com.luv2code.hibernate.demo;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForMaryDemo {

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
			
//			get the student from db
//			create more courses
//			add student to courses
//			save
			
			Student tempStudent = session.get(Student.class, 2);
			System.out.println(tempStudent.getCourses());
			
			Course tempCourse1 = new Course("Rubik's Cube");
			Course tempCourse2 = new Course("Game development");
			
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			
		
			
			
						
			
			
			session.getTransaction().commit();
		
						
		}
		finally {
			session.close();
			factory.close();
		}
		
	}

}
