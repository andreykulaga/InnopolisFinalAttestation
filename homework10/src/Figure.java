public abstract class Figure {
    protected double x;
    protected double y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getPerimeter() {
        return 0.0;
    }
}
