import java.util.Scanner;

/*
На вход подается информация о людях в количестве 10 человек (имя - строка, вес - вещественное число).
Считать эти данные в массив объектов.
Вывести в отсортированном по возрастанию веса порядке.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in)
        Human[] humans = new Human[10];

        for (i=0; i<10; i++) {
            humans[i] = new Human();
            humans[i].setName(scanner.nextLine());
            humans[i].setWeight(scanner.nextInt());
        }



        for (i=0; i<10; i++) {
            System.out.print(humans[i].getName() + " " + humans[i].getWeight());
            System.out.println;
        }
    }
}