package Shapes;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ListIterator;


public class ShapesTest {

    Shape Rectangle;
    Shape Circle;
    Shape Triangle;

    interface Shape {
        double getArea();
        double getPerimeter();
    }

    class Rectangle implements Shape {
        double width = 0, length = 0;

        public Rectangle() {
            this(1, 1);
        }

        public Rectangle(double width, double length) {
            this.length =length;
            this.width =width;

        }

        @Override
        public double getArea() {
            return this.width * length;
        }

        @Override
        public double getPerimeter() {
            // P = 2(w + l)
            return this.width * length;
        }
    }

    class Circle implements Shape {
        double radius = 0;
        final double pi = Math.PI;

        public Circle() {
            this(1);
        }

        public Circle(double radius) {
            this.radius =radius;
        }

        @Override
        public double getArea() {

            return
                    this.pi * radius * radius;
        }

        public double getPerimeter() {

            return this.pi * 2 * radius;

        }
    }

    class Triangle implements Shape {
        private final double a, b, c;

        public Triangle() {
            this(1, 1, 1);
        }

        public Triangle(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public double getArea() {

            double s = (a + b + c) / 2;
            return Math.sqrt(s * (s - a) * (s - b) * (s - c));
        }

        @Override
        public double getPerimeter() {
            // P = a + b + c
            return this.a + b + c;
        }
    }

    public void testShapes() {
        ArrayList<Shape> shapes = new ArrayList<>();
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        Shape rectangle = new Rectangle(5,8);
        shapes.add(rectangle);
        Shape circle = new Circle(4);
        shapes.add(circle);
        Shape triangle = new Triangle(4,6,3);
        shapes.add(triangle);


        System.out.println("\n");
        ListIterator<Shape> iterator = shapes.listIterator();
        while (iterator.hasNext()) {
            Shape shape = iterator.next();
        //for (Shape shape:shapes){
            System.out.println(shape.getClass().getSimpleName() + " area: " + df.format(shape.getArea()));
            System.out.println(shape.getClass().getSimpleName() + " perimeter " + df.format(shape.getPerimeter()));
        }

    }

    public static void main(String[] args) {


        ShapesTest ts = new ShapesTest();
        ts.testShapes();
    }
}