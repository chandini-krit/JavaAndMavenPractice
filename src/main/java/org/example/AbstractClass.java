package org.example;

import lombok.Getter;
import lombok.Setter;

abstract class Family {
    @Getter@Setter
    private String name;
    @Getter@Setter private int age;

    public Family(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void Relation(String name);

    public void Native() {
        System.out.println("from India");
    }

}

class Father extends Family {
    public Father(String name, int age){
        super(name,age);
    }

    @Override
    public void Relation(String name) {
        System.out.println(name+" is father");
    }
}

class Mother extends Family {
    public Mother(String name,int age){
        super(name,age);
    }

    public void Relation(String name) {
        System.out.println(name+" is mother");
    }
}

public class AbstractClass {
    public static void main(String[] args) {
        Family mother = new Mother("Riya",30);
        mother.Relation(mother.getName());
        mother.Native();

        Father father = new Father("Shyam",32);
        father.Relation(father.getName());
        father.Native();
    }
}
