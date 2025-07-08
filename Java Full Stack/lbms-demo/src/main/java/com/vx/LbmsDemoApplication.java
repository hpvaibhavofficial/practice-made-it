package com.vx;

import java.sql.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.vx.model.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@SpringBootApplication
public class LbmsDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LbmsDemoApplication.class, args);
		testStudent(context);
	}
	
	public static void testStudent(ConfigurableApplicationContext context) {
		EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();
//		em.getTransaction().begin();
//		Student st = new Student(12218284,"Vaibhav Bhardwaj",90,"Bilaspur, Himachal Pradesh",3912,"CSE",Date.valueOf("2025-02-10"),"vaibhav.12218284@gmail.com",8.4,"Male","CSE","Active");
//		em.persist(st);
//		em.getTransaction().commit();
//		
		        em.getTransaction().begin();
//		       Student student = new Student("Ananya", 103, "Mumbai", 987654300, "IT", java.sql.Date.valueOf("2001-12-12"), "ananya@example.com", 8.9, "Female", dept, "Active");
		        Student s = em.find(Student.class,12210001);
		        s.setName("Anamikaa");
		        s.setAddress("Hamirpur");
		        s.setDob(java.sql.Date.valueOf("2005-03-03"));
		        
		        em.persist(s);
		        em.getTransaction().commit();

		        em.close();
		        emf.close();
		    }
		
		public static void TestDept(ConfigurableApplicationContext context) {
			EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
			EntityManager em = emf.createEntityManager();
			
		}
		
		

	}
	








//em.getTransaction().begin();       // Step 1
////Step 2: Create student object
//em.persist(student);              // Step 3
//em.getTransaction().commit();     // Step 4
//em.close();                       // Step 5
