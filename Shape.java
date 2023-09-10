package semIV;

abstract class Shape {
    protected int width;
    protected int height;

    public Shape(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public abstract void printArea();
}

class Rectangle extends Shape {
    public Rectangle(int width, int height) {
        super(width, height);
    }

    public void printArea() {
        int area = width * height;
        System.out.println("Rectangle area: " + area);
    }
}

class Triangle extends Shape {
    public Triangle(int width, int height) {
        super(width, height);
    }

    public void printArea() {
        double area = 0.5 * width * height;
        System.out.println("Triangle area: " + area);
    }
}

class Circle extends Shape {
    public Circle(int radius) {
        super(radius, radius);
    }

    public void printArea() {
        double area = Math.PI * width * width;
        System.out.println("Circle area: " + area);
    }
}

class Output {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(10, 5);
        rectangle.printArea();

        Shape triangle = new Triangle(6, 8);
        triangle.printArea();

        Shape circle = new Circle(5);
        circle.printArea();
    }
}
