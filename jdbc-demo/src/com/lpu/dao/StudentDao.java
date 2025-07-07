package com.lpu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lpu.db.DBConnection;
import com.lpu.model.Student;

public class StudentDao {
    // DAO stands for Data Access Object

    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection()) {
            // try-with-resources ensures automatic closing of the connection

            System.out.println("Connected to database: " + connection);

            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM student");

            while (resultset.next()) {
                int roll = resultset.getInt("roll");
                String name = resultset.getString("name");
                String branch = resultset.getString("branch");
                String phone = resultset.getString("phone");

                Student s = new Student(roll, name, branch, phone);
                list.add(s);
            }

            // Clean-up (not strictly needed due to try-with-resources, but good practice)
            resultset.close();
            statement.close();
            // connection is closed automatically

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public Student findById(int roll) {
    		
        	try (Connection connection = DBConnection.getConnection()){
        		
        	Statement statement = connection.createStatement();
        	ResultSet resultSet = statement.executeQuery("select * from student where roll = "+roll);
        	
        	if((resultSet.next())) {
        		int roll1 = resultSet.getInt("roll");
        		String name = resultSet.getString("name");
        		String branch = resultSet.getString("branch");
        		String phone = resultSet.getString("phone");
        		
        		Student s = new Student(roll1,name,branch,phone);
        		return s;
      
        	}
        	resultSet.close();
        	statement.close();
        	return null;
        	}
    		catch(SQLException e) {
    			e.printStackTrace();
    		}
        	
        	return null;
       }
    
    
    public boolean removeById(int roll) 
//    	pst delete from student where roll = ?
    	
    	{	
        	try (Connection connection = DBConnection.getConnection()){
        	Statement statement = connection.createStatement();
        	int rowsUpdated = statement.executeUpdate("delete from student where roll = " + roll);
    		if(rowsUpdated == 1) {
    			return true;
    		}
    		statement.close();
        	}
    		catch(SQLException e) {
    			e.printStackTrace();
    		}	
        	return false;
    }
    	
    public Student update(Student student) {
    	//update student set name  = ? ,branch = ? ,where roll =? 
    	try(Connection connection = DBConnection.getConnection()){
    		PreparedStatement pst = connection.prepareStatement("update student set name = ?, branch = ?, phone = ?, roll = ?");
    		pst.setString(1, student.getName());
    		pst.setString(2,student.getBranch());
    		pst.setString(3,student.getPhone());
    		pst.setInt(4,student.getRoll());
    		
    		int rowsUpdated = pst.executeUpdate();
    		if(rowsUpdated == 1) {
    			return student;
    		}
    		pst.close();
    	} catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	return null;
    }
    
    public Student add(Student student) 
    {	
    	try (Connection connection = DBConnection.getConnection()){
    	PreparedStatement pst = connection.prepareStatement("INSERT INTO student VALUES (?, ?, ?, ?)");

		pst.setInt(1, student.getRoll());
		pst.setString(2, student.getName());
		pst.setString(3, student.getBranch());
		pst.setString(4, student.getPhone());
		
		int rowsUpdated = pst.executeUpdate();
		if(rowsUpdated == 1) return student;
		else return null;
    	}
    	
		catch(SQLException e) {
			e.printStackTrace();
		}
    	
    	return null;
    }

    public static void main(String[] args) { 
        try {
        	StudentDao  sdao = new StudentDao();
			List<Student> students = sdao.findAll();
			students.forEach(System.out::println);
			
			Student newStudent = new Student(108,"Harsh","CSE","283567876545678");
			sdao.add(newStudent);

			
			System.out.println();
			students = sdao.findAll();
			students.forEach(System.out::println);
			
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
