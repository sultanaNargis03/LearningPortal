package com.learningapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtility 
{
	static
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}
	public static Connection getDbConnection() throws SQLException
	{
		String url="jdbc:mysql://localhost:3306/teluskodb";
		String user="root";
		String password="root";
		return DriverManager.getConnection(url, user, password);
	}
	public static void closeResource(Connection connect,Statement stmt,ResultSet rs) throws SQLException
	{
		if(connect!=null)
			connect.close();
		if(stmt!=null)
			stmt.close();
		if(rs!=null)
			rs.close();
	}
}
