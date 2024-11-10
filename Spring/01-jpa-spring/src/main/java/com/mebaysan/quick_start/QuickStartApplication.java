package com.mebaysan.quick_start;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mebaysan.quick_start.dao.StudentDAO;
import com.mebaysan.quick_start.entity.Student;

@SpringBootApplication
public class QuickStartApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickStartApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			try {
				// createStudent(studentDAO);
				// createMultipleStudents(studentDAO);
				// getStudent(studentDAO, 1);
				// getStudent(studentDAO, 0);
				// countStudents(studentDAO);
				// filterStudents(studentDAO, "baysan");
				// updateStudent(studentDAO, 45);
				deleteStudent(studentDAO, 45);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student student1 = new Student("John", "Doe", "mail1@mebaysan.com");
		Student student2 = new Student("Jane", "Doe", "mail2@baysansoft.com");
		Student student3 = new Student("Jack", "Doe", "mail3@mail.com");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		System.out.println("Saved multiple students.");
	}

	private void createStudent(StudentDAO studentDAO) {
		Student newStudent = new Student("Enes", "Baysan", "mail@example.com");
		studentDAO.save(newStudent);
		System.out.println(String.format("Saved student. Generated id: %s", newStudent.getId()));
	}

	private void getStudent(StudentDAO studentDAO, int id) {
		Student student = studentDAO.fetchById(id);
		System.out.println(String.format("Fetched student: %s", student));
	}

	private void countStudents(StudentDAO studentDAO) {
		int count = studentDAO.count();
		System.out.println(String.format("Number of students: %s", count));
	}

	private void filterStudents(StudentDAO studentDAO, String email) {
		List<Student> students = studentDAO.filterLikeEmail(email);
		System.out.println(String.format("There are %s students with email like %s", students.size(), email));
		System.out.println("Students:");
		students.forEach(System.out::println);
	}

	private void updateStudent(StudentDAO studentDAO, int id) throws Exception {
		Student student = studentDAO.fetchById(id);
		if (student == null) {
			throw new Exception("Student not found.");
		}
		System.out.println("Student before update: " + student);
		student.setFirstName("Updated " + student.getFirstName());
		student.setLastName("Updated " + student.getLastName());
		student.setEmail("updated." + student.getEmail());
		studentDAO.update(student);
		System.out.println("Student after update: " + student);
	}

	private void deleteStudent(StudentDAO studentDAO, int id) throws Exception {
		Student student = studentDAO.fetchById(id);
		if (student == null) {
			throw new Exception("Student not found.");
		}
		studentDAO.deleteById(id);
		System.out.println("Student deleted.");
	}

}
