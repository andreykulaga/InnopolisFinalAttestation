public class Ellipse extends Figure implements Movable {
    protected double radius1;
    protected double radius2;

    public Ellipse(double x, double y, double radius1, double radius2) {
        super(x, y);
        this.radius1 = radius1;
        this.radius2 = radius2;
    }

    public double getPerimeter() {
        return 3.141592653589793D * (this.radius1 + this.radius2) * (1.0D + 3.0D * ((this.radius1 - this.radius2) * (this.radius1 - this.radius2) / ((this.radius1 + this.radius2) * (this.radius1 + this.radius2))) / (10.0D + Math.sqrt(4.0D - 3.0D * ((this.radius1 - this.radius2) * (this.radius1 - this.radius2) / ((this.radius1 + this.radius2) * (this.radius1 + this.radius2))))));
    }

    @Override
    public void changeCoordinates(double x1, double y1) {
        x += x1;
        y += y1;
    }
}