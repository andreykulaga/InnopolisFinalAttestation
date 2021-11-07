public class Circle extends Ellipse {
    public Circle(double x, double y, double radius) {
        super(x, y, radius, radius);
    }

    public double getPerimeter() {
        return 6.283185307179586D * this.radius1;
    }
}