package com.vx;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.vx.model.Employee;
import com.vx.model.Parking;
import com.vx.model.Department;
import com.vx.model.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

@SpringBootApplication
public class LbmsDemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LbmsDemoApplication.class, args);
//		testStudent(context);
		//TestDept(context);
//		 EntityManager em = context.getBean(EntityManager.class); // ✅ Get EntityManager
//
//	        a

//	        List<Student> students = em.createQuery(
//	                "SELECT s FROM Student s WHERE s.department.depid = :depid", Student.class)
//	                .setParameter("depid", depid)
//	                .getResultList();
//
//	        students.forEach(System.out::println);
			testParking(context);
	        context.close();
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
			em.getTransaction().begin();
			Department obj1 = new Department();
			obj1.setDepname("Computer Science");
			em.persist(obj1);
			
			Student s1 = new Student("Alice", 101, "Delhi", 987654321, "CS",
                    Date.valueOf("2002-05-12"), "alice@mail.com", 8.5, "F", obj1, "Active");

			em.persist(s1);
            em.getTransaction().commit();
			
            System.out.println("Data saved successfully.");
            
           em.close();
           emf.close();
		}
		
		
		public static void testParking(ConfigurableApplicationContext context) {
			EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
			EntityManager em = emf.createEntityManager();
			Parking pkg = new Parking();
			 try {
		            em.getTransaction().begin();

		            // 🅿️ Create a Parking record
		            Parking parking = new Parking();
		            parking.setSlotNum("B1-12");
		            parking.setFloor(1);
		            parking.setIsOccupied(true);
		            parking.setVno("HP01AB0001");
		            parking.setAllocatedTime(Time.valueOf("08:30:00"));

		            em.persist(parking); // Save parking first

		            // 👨‍💼 Create an Employee record
		            Employee employee = new Employee();
		            employee.setEid(1); // You must manually manage eid since no @GeneratedValue
		            employee.setName("Vaibhav Bhardwaj");
		            employee.setEmail("vaibhav@vx.com");
		            employee.setDepartment("IT");
		            employee.setPhoneNumber("9876543210");
		            employee.setDesignation("Backend Developer");
		            employee.setSalary(85000.00);
		            employee.setJoinDate(LocalDate.of(2022, 7, 1));
		            employee.setParking(parking); // Link the parking

		            em.persist(employee); // Save employee

		            em.getTransaction().commit();

		            System.out.println("✅ Test data inserted successfully!");

		        } catch (Exception e) {
		            em.getTransaction().rollback();
		            e.printStackTrace();
		        } finally {
		            em.close();
		            emf.close();
		        }

			
		}
		
	}
	
	

//em.getTransaction().begin();       // Step 1
////Step 2: Create student object
//em.persist(student);              // Step 3
//em.getTransaction().commit();     // Step 4
//em.close();                       // Step 5
