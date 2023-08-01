package controller;

import model.StudentDAO;

public class StudentController {
	
	private static StudentDAO studentDAO = new StudentDAO();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		studentDAO.getAllStudents().forEach(System.out :: println);
		

	}

}
