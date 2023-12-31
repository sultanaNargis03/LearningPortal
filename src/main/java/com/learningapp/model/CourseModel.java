package com.learningapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseModel 
{
	private Integer id;
	private String courseName;
	private double price;
	private String instructor;
	private int []row;
	private ResultSet rs=null;
	private Connection connect=null;
	private PreparedStatement pstmt=null;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	

	@Override
	public String toString() {
		return "CourseModel [id=" + id + ", courseName=" + courseName + ", price=" + price + ", instructor="
				+ instructor + "]";
	}
	public int[] insertCourse()
	{
		try 
		{
			connect=JdbcUtility.getDbConnection();
			String query="INSERT INTO courseportal (id,coursename,price,instructor)"
					+ "VALUES(?,?,?,?)";
			if(connect!=null)
				pstmt=connect.prepareStatement(query);
			if(pstmt!=null)
			{
				pstmt.setInt(1, 2);
				pstmt.setString(2, "Java");
				pstmt.setDouble(3, 10_000);
				pstmt.setString(4, "Hyder Abbas");
				pstmt.addBatch();
				
				pstmt.setInt(1, 3);
				pstmt.setString(2, "Spring Boot");
				pstmt.setDouble(3, 10_000);
				pstmt.setString(4, "Hyder Abbas");
				pstmt.addBatch();
				
				row=pstmt.executeBatch();
			}
			return row;
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				JdbcUtility.closeResource(connect, pstmt,rs);
				
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
		}
		return row;
		
	}
	public List<CourseModel> readCourse()
	{
		List<CourseModel> courses = new ArrayList<>();
		
		try 
		{
			connect=JdbcUtility.getDbConnection();
			String query="select * from courseportal";
			if(connect!=null)
				pstmt=connect.prepareStatement(query);
			if(pstmt!=null)
			{
				 rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				CourseModel cm=new CourseModel();
				cm.setId(rs.getInt("id"));
				cm.setCourseName(rs.getString("coursename"));
				cm.setPrice(rs.getDouble("price"));
				cm.setInstructor(rs.getString("instructor"));
				
				courses.add(cm);
				
			}
			}
			
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				JdbcUtility.closeResource(connect, pstmt,rs);
				
			} catch (SQLException e) 
			{
				
				e.printStackTrace();
			}
			
		}
		return courses;
		
	}
	public void deleteCourse()
	{
		
	}
	public void updateCourse()
	{
		
	}
	
}
