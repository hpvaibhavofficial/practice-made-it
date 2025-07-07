package com.lpu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.lpu.db.DBConnection;
import com.lpu.model.Book;

public class Bookdao {
	public List<Book> findAll()
	{	List<Book> list = new ArrayList<>();
	try (Connection connection = DBConnection.getConnection())
	{
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from book");
		while(resultSet.next())
		{
			int bid1 = resultSet.getInt("bid");
			String title = resultSet.getString("title");
			String author = resultSet.getString("author");
			Double price = (Double) resultSet.getObject("price");
			Book s = new Book(bid1, title, author, price);
			list.add(s);
		}
		resultSet.close();
		statement.close();
		return list;
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return null;
	}

	public Book findById(int bid)
	{
		try (Connection connection = DBConnection.getConnection())
		{
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from book where bid = " + bid);
			if(resultSet.next())
			{
				int bid1 = resultSet.getInt("bid");
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				Double price = (Double) resultSet.getObject("price");
				Book s = new Book(bid1, title, author, price);
				return s;
			}
			resultSet.close();
			statement.close();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean removeById(int bid)
	{
		try (Connection connection = DBConnection.getConnection())
		{
			Statement statement = connection.createStatement();
			int rowsUpdated = statement.executeUpdate("delete from book where bid = " + bid);
			if(rowsUpdated == 1)
			{
				return true;
			}
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public Book update(Book book)
	{
		
		try (Connection connection = DBConnection.getConnection())
		{
			PreparedStatement pst = connection.prepareStatement("update book set title = ?, author = ?, price = ? where bid = ? ");
			pst.setString(1,  book.getTitle());
			pst.setString(2, book.getAuthor());
			pst.setDouble(3, book.getPrice());
			pst.setInt(4, book.getBid());
			int rowsUpdated = pst.executeUpdate();
			if(rowsUpdated == 1)
			{
				return book;
			}
			pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public Book add(Book book)
	{
		try(Connection connection= DBConnection.getConnection()) {
			
			PreparedStatement pst = connection.prepareStatement("insert into book values (?, ? ,? ,?)" );
			pst.setInt(1,  book.getBid());
			pst.setString(2,  book.getTitle());
			pst.setString(3,  book.getAuthor());
			pst.setDouble(4,  book.getPrice());
			int rowsUpdated = pst.executeUpdate();
			if(rowsUpdated == 1) return book;
			else return null;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}