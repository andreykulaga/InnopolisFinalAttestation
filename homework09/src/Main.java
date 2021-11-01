public class Main {

    public static void main(String[] args) {
        //создаем массив указателей на фигуры
        Figure[] figures = new Figure[5];

        figures[0] = new Figure(0, 0); //создаем фигуру с координатами 0,0
        figures[1] = new Ellipse(10, 10, 1, 2); //создаем эллипс
        figures[2] = new Circle(15, 15, 1); //создаем круг
        figures[3] = new Rectangle(20, 20, 1,2); //создаем прямоугольник
        figures[4] = new Square(25, 25, 1); //создаем квадрат

        //выводим периметры фигур
        for (int i=0; i< figures.length; i++) {
            System.out.println("Периметр фигуры " + figures[i].getClass().getSimpleName() + " " + figures[i].getPerimeter());
        }

    }
}
