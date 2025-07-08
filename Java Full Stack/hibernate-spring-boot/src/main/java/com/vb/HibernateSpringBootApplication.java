package com.vb;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.vb.algo.PasswordAlgo;
import com.vb.model.Department;
import com.vb.model.Employee;
import com.vb.model.Faculty;
import com.vb.model.Parking;
import com.vb.model.Person;
import com.vb.model.Project;
import com.vb.model.Student;
import com.vb.model.Student2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;

@SpringBootApplication
public class HibernateSpringBootApplication {

    private final PasswordAlgo passwordAlgo;

    HibernateSpringBootApplication(PasswordAlgo passwordAlgo) {
        this.passwordAlgo = passwordAlgo;
    }

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(HibernateSpringBootApplication.class, args);
//		PasswordAlgo algo = context.getBean(PasswordAlgo.class);
//		String rev = algo.encrypt("ThisPass@34");
//		System.out.println(rev);
//
//				String[] beans = context.getBeanDefinitionNames();
//				for(String beanName : beans)
//					System.out.println(beanName);ww
//				
//				testStudent(context);
//				testProject(context);
				//testParking(context);
//				testEmployeeDept(context);
				//testSingleTable(context);
		testCustomQuery(context);
	}
	
	public static void testEmployeeDept(ConfigurableApplicationContext context)
	{
		EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();
		Employee employee = em.find(Employee.class,1108);
		Department medept = employee.getDepartment();
		System.out.println(employee);
		Department department = em.find(Department.class,1);
		System.out.println();
		System.out.println("working in "+department.getName());
		department.getEmployees().forEach(System.out::println);
		
		em.getTransaction().begin();
		Employee emp = new Employee();
		emp.setDesignation("SE");
		emp.setMgrid(1099);
		emp.setEmpid(1022);
		emp.setName("Dipesh Jangra");
		emp.setDepartment(medept);
		em.persist(emp);
		em.getTransaction().commit();		
		
		
		
		
		
		
		
		
		
	}
	
	public static void testProject(ConfigurableApplicationContext context)
	{
		EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Project p1 = new Project(0,"Indigo", Date.valueOf("2020-05-05"), Date.valueOf("2026-08-07"), 4500000.0);
		Project p2 = new Project(0,"SBI", Date.valueOf("2023-05-05"), Date.valueOf("2025-08-07"), 8500000.0);
		em.persist(p1);
		em.persist(p2);
		em.getTransaction().commit();
		

	}
	public static void testParking(ConfigurableApplicationContext context)
	{
		EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();
		try
		{
//			em.getTransaction().begin();
//
//			Parking p1 =new Parking();p1.setFloor(1); p1.setPlace(12);
//			Parking p2 =new Parking();p1.setFloor(1); p1.setPlace(13);
//
//			em.persist(p1);
//			em.persist(p2);
			
			Parking parking = em.find(Parking.class,1109);
			System.out.println(parking);
		}
		catch(Exception e)
		{
			//em.getTransaction().rollback();
			e.printStackTrace();
		}
		finally
		{
//			em.getTransaction().commit();
		}
	}
	public static void testStudent(ConfigurableApplicationContext context)
	{
		// dataSource, entityManagerFactory
		EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();
		Student student = em.find(Student.class, 112 );

		//		student.setSname("Nishi Sachdeva");
		em.getTransaction().begin(); 
		//		em.remove(student);
		System.out.println(student);
		Integer marks = 81;
		Date dob = Date.valueOf("2001-08-08");
		//		Student s =new Student(112, "Amit Gupta", "CSE", "1212458785",dob, marks);
		//		em.persist(s);

		Query query = em.createQuery("select s from Student s");
		query.getResultList().forEach(System.out::println);
		em.getTransaction().commit();
		em.close();
		

	}

	public static void testSingleTable(ConfigurableApplicationContext context)
	{
		EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Person p1 =new Person(0,"Rajan Manocha", "9865548798");
		Student2 s = new Student2(0, "Pratyush", "8798658744", 11025,"CSE");
		Faculty f = new Faculty(0, "Dinesh", "9865872020", null, null);
		em.persist(f);
		em.persist(s);
		em.persist(p1);
		em.getTransaction().commit();
	}
	
	public static void testCustomQuery(ConfigurableApplicationContext context) {
		EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
		EntityManager em = emf.createEntityManager();
		
		 Query query2 = em.createQuery("select p ,p.employee.name from Parking p where p.employee.name = :name");
		 query2.setParameter("name","kritika");
		 query2.getResultList().forEach(System.out::println);
		
//		Query query = em.createQuery("select e from Employee e where e.name = :name");
//		query.setParameter("name", "Kalyan");
//		query.getResultList().forEach(System.out::println);
//		
//		Query nativeQuery = em.createNativeQuery("Select * from issue,book where issue.bid = book.bid");
//		List<Object[]> resList =nativeQuery.getResultList() ;
//		resList.forEach(ar -> System.out.println(Arrays.toString(ar)));
	}
	
}
	
	
	
	
	
	
	
	
	