package org.example.module8_Shape;

public class Demo {
    public static void main(String[] args) {
        PrinterShapeName printer = new PrinterShapeName();

        printer.printShapeName(new Trapezoid()); // should be Trapezoid
        printer.printShapeName(new RightTriangle()); // should be Right triangle
        printer.printShapeName(new Ellipse()); // should be Ellipse
    }
}