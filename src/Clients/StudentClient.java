package Clients;

import Interfaces.IStudentService;
import Serializebles.Student;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class StudentClient {
    public static void main(String[] args) {
        try {
            IStudentService service = (IStudentService) Naming.lookup("rmi://localhost:1102/StudentService");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Add Student");
                System.out.println("2. Delete Student");
                System.out.println("3. List Students");
                System.out.println("0. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter student age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter student courses (comma separated): ");
                        String coursesInput = scanner.nextLine();
                        List<String> courses = List.of(coursesInput.split(","));
                        Student student = new Student(name, age, courses);
                        service.addStudent(student);
                        System.out.println("Student added successfully.");
                        break;
                    case 2:
                        System.out.print("Enter student name to delete: ");
                        String nameToDelete = scanner.nextLine();
                        service.deleteStudent(nameToDelete);
                        System.out.println("Student deleted successfully.");
                        break;
                    case 3:
                        List<Student> students = service.listStudents();
                        for (Student s : students) {
                            System.out.println("Name: " + s.getName() + ", Age: " + s.getAge() + ", Courses: " + s.getCourses());
                        }
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}