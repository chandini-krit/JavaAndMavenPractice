package org.example;

import lombok.Getter;
import lombok.Setter;

public class SingletonClassExample {
    private static SingletonClassExample obj;
    @Getter @Setter
    private String name;
    private SingletonClassExample(){}

    public static SingletonClassExample getObj() {
        if (obj == null) {
            obj = new SingletonClassExample();
        }
        return obj;
    }
}
class SingletonDemo {
    public static void main(String[] args) {
        SingletonClassExample obj1 = SingletonClassExample.getObj();
        obj1.setName("Chandini");
        SingletonClassExample obj2 = SingletonClassExample.getObj();
        System.out.println(obj2.getName());
    }
}
