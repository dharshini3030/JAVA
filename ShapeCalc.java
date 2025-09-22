import java.util.*;

// Abstract class Shape
abstract class Shape {
    int a, b;
    abstract void printArea();
}

// Rectangle class
class Rectangle extends Shape {
    Rectangle(int x, int y) {
        a = x;
        b = y;
    }
    void printArea() {
        System.out.println("AREA OF RECTANGLE: " + (a * b));
    }
}

// Triangle class
class Triangle extends Shape {
    Triangle(int x, int y) {
        a = x;
        b = y;
    }
    void printArea() {
        System.out.println("AREA OF TRIANGLE: " + (0.5 * a * b));
    }
}

// Circle class
class Circle extends Shape {
    Circle(int r) {
        a = r;
    }
    void printArea() {
        System.out.println("AREA OF CIRCLE: " + (3.14 * a * a));
    }
}

// Main class
public class ShapeCalc {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Shape s;

        System.out.println("ENTER LENGTH AND BREADTH:");
        int l = sc.nextInt();
        int b = sc.nextInt();
        s = new Rectangle(l, b);
        s.printArea();

        System.out.println("ENTER BASE AND HEIGHT:");
        int base = sc.nextInt();
        int h = sc.nextInt();
        s = new Triangle(base, h);
        s.printArea();

        System.out.println("ENTER RADIUS:");
        int r = sc.nextInt();
        s = new Circle(r);
        s.printArea();

        sc.close();
    }
}

