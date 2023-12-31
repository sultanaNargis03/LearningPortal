package com.learningapp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Model 
{
	private int id;
	private String userName;
	private String city;
	private String country;
	private String password;
	private int row;
	private ResultSet rs;
	private Connection connect=null;
	private PreparedStatement pstmt=null;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRow() 
	{
		return row;
	}
	public void setRow(int row) 
	{
		this.row = row;
	}
	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	public String getCity() 
	{
		return city;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}
	public String getCountry() 
	{
		return country;
	}
	public void setCountry(String country) 
	{
		this.country = country;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	
	public int register()
	{
		try 
		{
			connect=JdbcUtility.getDbConnection();
			String query="INSERT INTO studentportal (id,username,city,country,password)"
					+ "VALUES(?,?,?,?,?)";
			if(connect!=null)
				pstmt=connect.prepareStatement(query);
			if(pstmt!=null)
			{
				pstmt.setInt(1, id);
				pstmt.setString(2, userName);
				pstmt.setString(3, city);
				pstmt.setString(4, country);
				pstmt.setString(5, password);
				
				row=pstmt.executeUpdate();
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
		return row;
	}
	
	public void login()
	{
		try 
		{
			connect=JdbcUtility.getDbConnection();
			String query="SELECT username,password where username=?";
			if(connect!=null)
				pstmt=connect.prepareStatement(query);
			if(pstmt!=null)
			{
				
				pstmt.setString(1, userName);
				rs=pstmt.executeQuery();
				while(rs.next())
				{
					userName=rs.getString("username");
					password=rs.getString("password");
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
	}
	
	
	
	
	@Override
	public String toString() {
		return "Model [userName=" + userName + ", city=" + city + ", country=" + country + ", password=" + password
				+ "]";
	}
	
	
}
