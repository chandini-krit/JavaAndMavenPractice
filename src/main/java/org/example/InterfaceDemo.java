package org.example;

interface Shape{
    void sides();
}
interface Draw extends Shape{
    void draw();
}
class Square implements  Shape{
    @Override
    public void sides() {
        System.out.println("Square has four sides");
    }
}
class Triangle implements Shape{
    public void sides() {
        System.out.println("Triangle has three sides");
    }
}

class Pentagon implements Shape,Draw{
    @Override
    public void draw() {
        System.out.println("draw Pentagon");
    }

    @Override
    public void sides() {
        System.out.println("Pentagon has 5 sides");
    }
}
public class InterfaceDemo {
    public static void main(String[] args) {
        Shape triangle = new Triangle();
        Pentagon pentagon = new Pentagon();
        triangle.sides();
        pentagon.sides();
        pentagon.draw();
    }
}
