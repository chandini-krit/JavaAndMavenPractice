package org.example;

import java.sql.*;
import java.util.Scanner;
class Student {
    private int id;
    private String name;
    private int section;
    private String course;

    public Student(int id, String name, int section, String course) {
        this.id = id;
        this.name = name;
        this.section=section;
        this.course=course;
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSection() {
        return section;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSection(int section) {
        this.section = section;
    }
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course =course;
    }
    @Override
    public String toString() {
        return "id=" + id + " | name=" + name + " | section=" + section+" | course="+course;
    }
}
class StudentManager {
     private Connection connection;

    public StudentManager() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chandini", "kritter", "kritter");
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Disconnected from the database.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close the database connection.");
            e.printStackTrace();
        }
    }

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        System.out.println("Enter student section: ");
        int section = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter student course: ");
        String course = scanner.nextLine();
        String query = "INSERT INTO students (id, name, section ,course) VALUES (?, ?, ?,?)";
        try  {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setInt(3, section);
            statement.setString(4,course);
            statement.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to add student.");
            e.printStackTrace();
        }
    }

    public void displayStudents() {
        String query = "SELECT * FROM students";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int section = resultSet.getInt("section");
                String course = resultSet.getString("course");
                Student student = new Student(id, name,section,course);
                System.out.println(student);
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch students.");
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        String query = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to delete student.");
            e.printStackTrace();
        }
    }

    public void updateStudent(int id) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new student course: ");
        String course = scanner.nextLine();
        System.out.println("Enter new student section: ");
        int section = Integer.parseInt(scanner.nextLine());

        String query = "UPDATE students SET course = ?, section = ? ,WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, course);
            statement.setInt(2, section);
            statement.setInt(3, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to update student.");
            e.printStackTrace();
        }
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) throws Exception{
        StudentManager studentManager = new StudentManager();
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\nStudent Management System");
                System.out.println("1. Add Student");
                System.out.println("2. Display Students");
                System.out.println("3. Delete Student");
                System.out.println("4. Update Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        studentManager.addStudent();
                        break;
                    case 2:
                        studentManager.displayStudents();
                        break;
                    case 3:
                        System.out.println("Enter student ID to delete: ");
                        int deleteId = Integer.parseInt(scanner.nextLine());
                        studentManager.deleteStudent(deleteId);
                        break;
                    case 4:
                        System.out.println("Enter student ID to update: ");
                        int updateId = Integer.parseInt(scanner.nextLine());
                        studentManager.updateStudent(updateId);
                        break;
                    case 5:
                        studentManager.closeConnection();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}


