import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int[] array;
    public static int[] sums;

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


        //считаем целое число элементов на каждый поток
        int digitsPerThread = array.length/threadsCount;
        //создаем массив объектов, которые будут считать
        SumOfDigits[] sumOfDigits = new SumOfDigits[threadsCount];
        //заполняем массив объектами с одинаковым числом элементов для подсчета
        int start = 0;
        int finish = digitsPerThread-1;
        for (int i=0; i < threadsCount-1; i++) {
            sumOfDigits[i] = new SumOfDigits(array, start, finish);
            start = start + digitsPerThread;
            finish = finish + digitsPerThread;
            sumOfDigits[i].start();
        }
        //создаем последний объект массива со всеми оставшимися элементами для подсчета (на случай, если digitsPerThread должно было бы быть не целым)
        sumOfDigits[threadsCount-1] = new SumOfDigits(array, start, array.length-1);
        sumOfDigits[threadsCount-1].start();


        for (int i=0; i<threadsCount; i++) {
            try {
                sumOfDigits[i].join();
            } catch (InterruptedException e) {
                throw new IllegalArgumentException(e);
            }
        }


        for (int i=0; i<threadsCount; i++) {
            sums[i] = sumOfDigits[i].getSum();
        }


        int byThreadSum = 0;
        for (int i=0; i < sums.length; i++) {
            byThreadSum += sums[i];
        }
        System.out.println("Сложение в Main " + realSum);
        System.out.println("Сложение потоками " + byThreadSum);

    }
}
