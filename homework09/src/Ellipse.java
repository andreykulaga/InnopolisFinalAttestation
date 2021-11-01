public class Ellipse extends Figure {
    protected double radius1; //protected чтобы был доступ к переменной у метода Circle
    private double radius2;



    public Ellipse(double x, double y, double radius1, double radius2) {
        super(x, y);
        this.radius1 = radius1;
        this.radius2 = radius2;
    }

    public double getPerimeter() {
        //формула периметра эллипса
        return Math.PI * (radius1+radius2) * (1 + (3 * (((radius1-radius2)*(radius1-radius2))/((radius1+radius2)*(radius1+radius2))) / (10 + Math.sqrt(4 - 3*(((radius1-radius2)*(radius1-radius2))/((radius1+radius2)*(radius1+radius2)))))));
    }
}
