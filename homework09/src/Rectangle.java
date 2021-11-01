public class Rectangle extends Figure {
    protected double a; //сторона прямоугольника, protected чтобы был доступ у метода квадрата
    private double b;

    public Rectangle(double x, double y, double a, double b) {
        super(x, y);
        this.a = a;
        this.b = b;
    }

    public double getPerimeter() {
        return 2*a + 2*b;
    }
}
