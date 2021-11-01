public class Circle extends Ellipse {
    public Circle(double x, double y, double radius) {
        super(x, y, radius, radius);
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius1;
    }
}
