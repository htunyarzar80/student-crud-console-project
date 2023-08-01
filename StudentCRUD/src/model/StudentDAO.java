package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.DBConnection;

public class StudentDAO {
	
	private Connection connection;
	private Statement stmt;
	private PreparedStatement pStmt;
	private ResultSet rs;
	
	//Read R
	public List<Student> getAllStudents(){
		List<Student> studentList = new ArrayList<>();
		connection = DBConnection.getConnection();
		
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from student;");
			
			while (rs.next()) {
				studentList.add(new Student(
						rs.getInt("id"), 
						rs.getString("name"), 
						rs.getString("major"), 
						rs.getString("code"), 
						rs.getDouble("gpa")));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return studentList;
		
	}
	

}
