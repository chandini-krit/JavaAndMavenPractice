package org.example;

class Animal{
    void sound(){
        System.out.println("sound method in animal block");
    }

}
class Dog extends Animal{
    void bark(){
        System.out.println("dog barks");
    }
}
class Cat extends Animal{
    void meow(){
        System.out.println("cat makes meoww sounds");
    }
}
class Puppy extends Dog{
    void weep(){
        System.out.println("Puppy weeps...");
    }
}


public class Inheritance {
    public static void main(String[] args) {
        // single level inheritance
        Dog dog=new Dog();
        dog.sound();
        dog.bark();

        //multilevel inheritance
        Puppy puppy=new Puppy();
        puppy.sound();
        puppy.bark();
        puppy.weep();

        //hierarchical inheritance
        Cat cat = new Cat();
        cat.sound();
        cat.meow();
    }
}
