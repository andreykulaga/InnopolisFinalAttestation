public class Main {

    public static void main(String[] args) {
        //создаем массив указателей на элипсы (фигуры, которые можно двигать)
        Ellipse[] ellipses = new Ellipse[2];

        ellipses[0] = new Ellipse(10, 10, 1, 2); //создаем эллипс
        ellipses[1] = new Circle(15, 15, 1); //создаем круг



        //задаем перемещение каждой фигуры в начало координат
        ellipses[0].changeCoordinates(-10, -10);
        ellipses[1].changeCoordinates(-15, -15);

        //проверяем координаты фигур
        System.out.println("координаты элипса:");
        System.out.println(ellipses[0].getX() + " " + ellipses[0].getY());
        System.out.println("координаты элипса:");
        System.out.println(ellipses[0].getX() + " " + ellipses[0].getY());
    }
}
