import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int array[];
    public static int sums[];

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int numbersCount = scanner.nextInt();
        int threadsCount = scanner.nextInt();

        array = new int[numbersCount];
        sums = new int[threadsCount];

        for (int i=0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        int realSum = 0;
        for (int i=0; i < array.length; i++) {
            realSum += array[i];
        }
        System.out.println(realSum);

        Runnable[] tasks = new Runnable[threadsCount];

        for (int i=0; i < threadsCount; i++) {
            int j = 0;
            Runnable task = () -> {
                for (int z = j; z < (j + numbersCount/threadsCount); z++) {
                    sums[i] =+ array[z];
                    j++;
                }
            }
        }

        


        int byThreadSum = 0;
        for (int i=0; i < sums.length; i++) {
            byThreadSum += sums[i];
        }
        System.out.println(byThreadSum);

    }
}
