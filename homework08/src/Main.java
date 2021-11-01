import java.util.Scanner;

/*
На вход подается информация о людях в количестве 10 человек (имя - строка, вес - вещественное число).
Считать эти данные в массив объектов.
Вывести в отсортированном по возрастанию веса порядке.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Human[] humans = new Human[10]; //создаем массив указателей на людей

        for (int i=0; i<10; i++) { //создаем объекты людей, на котоорые указывает массив: имя (до 30 символов), ввод, вес (от 0 до 150 включительно кг), ввод.
            humans[i] = new Human();
            humans[i].setName(scanner.nextLine());
            humans[i].setWeight(Integer.parseInt(scanner.nextLine()));
        }
        //сортировка пузырьком
        for (int out = 9; out >= 1; out--) {
            for (int in = 0; in < out; in++) {
                if (humans[in].getWeight() > humans[in+1].getWeight()) {
                    Human temp = humans[in];
                    humans[in] = humans[in+1];
                    humans[in+1] = temp;
                }
            }
        }
        //выводим список имен людей и их вес
        for (int i=0; i<10; i++) {
            System.out.print(humans[i].getName() + " " + humans[i].getWeight());
            System.out.println();
        }
    }
}