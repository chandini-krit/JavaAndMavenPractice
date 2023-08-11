package org.example;

import org.example.thrift.Person;

public class StructThriftExample {
    public static void main(String[] args) {
        Person person = new Person();
        person.setEmail("chandinichowdary1323@gmail.com");
        person.setName("chandini");
        person.setId(1);
        System.out.println(person);

    }
}
