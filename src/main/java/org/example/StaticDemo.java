package org.example;

import lombok.Getter;
import lombok.Setter;

class StaticA{
    @Getter@Setter private static int count=0;
     static String name;
    public StaticA(String name){
        count++;
        this.name=name;
    }
      static void display(){
        System.out.println("hello!! "+name);
    }
}
public class StaticDemo {
    public static void main(String[] args) {
        StaticA obj1= new StaticA("a");
        StaticA obj2 = new StaticA("b");
        StaticA obj3 = new StaticA("c");
        System.out.println("Count of obj1:"+obj1.getCount());
        System.out.println("Count of obj2:"+obj2.getCount());
        System.out.println("Count of obj3:"+obj3.getCount());
        obj1.display();
    }
}
