package org.example;

import com.opencsv.CSVReader;
import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvException;
import lombok.Getter;
import lombok.Setter;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderExample {
    public static void main(String[] args) throws IOException, CsvException {

        CSVReader reader = new CSVReader(new FileReader("/home/chandini/maven/IdeaProjects/mavenPractice/src/main/resources/emps.csv"));
        List<Employee> emps = new ArrayList<Employee>();
        String[] record=null;
        while ((record=reader.readNext())!=null){

            Employee emp = new Employee();
            emp.setId(Integer.parseInt(record[0]));
            emp.setName(record[1]);
            emp.setAge(Integer.parseInt(record[2]));
            emp.setCountry(record[3]);
            emps.add(emp);
        }
        System.out.println(emps);

        reader.close();
    }
}
 class Employee {

    @Getter@Setter
    private int id;
    @Setter@Getter
    private String name;
    @Setter@Getter
    private int age;
    @Setter@Getter
    private String country;
    public Employee(){}
    public Employee(int id,String name,int age,String country){
        this.age=age;
        this.id=id;
        this.name=name;
        this.country=country;
    }
    @Override
    public String toString() {
        return "{" + id + "::" + name + "::" + age + "::" + country + "}";
    }
}