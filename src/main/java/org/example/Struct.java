package org.example;

import lombok.Getter;
import lombok.Setter;

public class Struct {
    @Getter @Setter
    private int value1;
    @Getter@Setter
    private String value2;
    // parameterised constructor
    public Struct(int value1,String value2){
        this.value1=value1;
        this.value2=value2;
    }
}
class StructDemo{
    public static void main(String[] args) {
        // struct object can access and modify struct members
        Struct struct = new Struct(10,"hi");
        System.out.println(struct.getValue2());
        struct.setValue2("hello");
        System.out.println(struct.getValue2());
    }
}