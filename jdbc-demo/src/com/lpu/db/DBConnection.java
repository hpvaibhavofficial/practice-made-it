package com.lpu.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.lpu.dao.Bookdao;
import com.lpu.dao.StudentDao;
import com.lpu.model.Book;
import com.lpu.model.Student;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DBConnection {
	public static Connection getConnection() throws SQLException
	{
		MysqlDataSource ds = new MysqlDataSource();
		ds.setPassword("vvvvvvvv");
		ds.setUser("root");
		ds.setUrl("jdbc:mysql://localhost:3306/lpu25");
		Connection connection = ds.getConnection();
		return connection; 
		
	}
	public static void tableCreateTest(String tableName)
	{
		try(Connection connection = DBConnection.getConnection())
		{
			Statement statement = connection.createStatement();
			boolean resultSetExists = statement.execute("Create table " + tableName + "(tableid int primary key)");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void studentDaoTest()
	{
		try
		{
			StudentDao sdao = new StudentDao();
			List<Student> students = sdao.findAll();
			students.forEach(System.out::println);
			
			Student newStudent = new Student(105, "Nishi", "CSE", "9864838484");
			sdao.add(newStudent);
			
			Student s101 = sdao.findById(101);
			System.out.println("s101 =" + s101);
			
			s101.setName("Mohit");
			sdao.update(s101);
			
			sdao.removeById(102);
			System.out.println();
			students = sdao.findAll();
			students.forEach(System.out::println);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void bookDaoTest()
	{
		try
		{
			Bookdao bdao =new Bookdao();
			//Book bookAdded = bdao.add(new Book(5, "OS" , "S Galvin", 900.0));
			bdao.removeById(3);
			
			Book b1 = bdao.findById(1);
			b1.setTitle("C Programming Basic");
			bdao.update(b1);
			bdao.findAll().forEach(System.out::println);
			
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws SQLException {
		try
		{
//			tableCreateTest("mytable1");
			bookDaoTest();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}