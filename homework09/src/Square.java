public class Square extends Rectangle {
    public Square(double x, double y, double a) {
        super(x, y, a, a);
    }

    public double getPerimeter() {
        return a*4;
    }
}
