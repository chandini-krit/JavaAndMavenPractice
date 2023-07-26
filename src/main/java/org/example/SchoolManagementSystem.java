package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
abstract class Person {
    protected int id;
    protected String name;
    protected String course;

    public Person(int id, String name,String course) {
        this.id = id;
        this.name = name;
        this.course=course;
    }

}



public class SchoolManagementSystem {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();

        // Read data from CSV file and create objects
        try (BufferedReader reader = new BufferedReader(new FileReader("data.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                int id = Integer.parseInt(data[0]);
                String name = data[1];

            /*    if (type.equals("Student")) {
                    people.add(new Student(id, name, age));
                } else if (type.equals("Teacher")) {
                    String department = data[4];
                    people.add(new Teacher(id, name, age, department));
                }

             */
            }
        } catch (IOException e) {
            System.out.println("Failed to read CSV file.");
            e.printStackTrace();
        }

    }
}