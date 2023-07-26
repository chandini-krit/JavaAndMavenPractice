package org.example;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ObjectMapperExample {
    public static void main(String[] args) throws ClassNotFoundException{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);

        try{
            // reading object from json string
            String json = "{ \"name\" : \"Tom\", \"age\" : 5 , \"dateOfBirth\" : \"2017-05-13\"}";
            People person = objectMapper.readValue(json,People.class);
            System.out.println("Name :"+person.getName());
            System.out.println("Age :"+person.getAge());
            System.out.println("Date of birth :"+person.getDateOfBirth());
            People myObject = new People( );
            myObject.setAge(10);
            myObject.setName("Jimmy");
            String json1 = objectMapper.writeValueAsString(myObject);
            System.out.println(json1);

            File file = new File("/home/chandini/maven/IdeaProjects/mavenPractice/src/main/resources/people.json");
            People[] person2 = objectMapper.readValue(file,People[].class);
            for (People people:person2) {
                System.out.println(people.getAge()+" "+people.getName());
            }

            InputStream input = new FileInputStream("/home/chandini/maven/IdeaProjects/mavenPractice/src/main/resources/people.json");
            SimpleDateFormat date = new SimpleDateFormat("yyyy-mm-dd");
            String json3=objectMapper.writeValueAsString(person);
            System.out.println(json3);

            objectMapper.setDateFormat(date);
            String json4=objectMapper.writeValueAsString(person);
            System.out.println(json4);
//            String json4 = "[{\"name\": \"chandini\",\"age\": 20}, {\"name\": \"raj\",\"age\": 10}]";
            JsonNode peopleJsonNode = objectMapper.readTree(file);
            for (JsonNode peopleNode:peopleJsonNode) {
                System.out.println(peopleNode.get("name")+" "+peopleNode.get("age"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
 class People {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int age;
    @Getter@Setter
    private Date dateOfBirth;
 }