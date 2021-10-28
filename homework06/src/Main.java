package com.company;

public class Main {
    /**
     * Возвращает индекс числа в массиве. Если числа в массиве нет, возвращает -1.
     * @param number число, чей индекс нужно вернуть
     * @param array массив
     * @return индекс первого совпадения элемента массива с числом
     */
    public static int getIndexFromArray(int number, int[] array) {
        int index = -1;
        for (int i=0; i < array.length; i++) {
            if (array[i] == number) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void moveToLeft(int[] array) {
        /* Процедура перемещает все значимые элементы влево, заполнив нулевые.
        Для этого создаем идентичный временный массив и счетчик копирования;
        Делаем цикл проверки является ли элемент временного массива не нулем и копируем его в первоначальный масив;
        Внутри цикла считаем счетчик копирования, чтобы указывать индекс вновь добавляемым элементам;
        */

        int[] temparray = array; //временный массив
        int j = 0; //счетчик копирования из временного массива в обрабатываемый
        for (int i=0; i < (temparray.length); i++) {
            if (temparray[i] != 0) { //если элемент временного массива не равен нулю, копируем его в обрабатываемый массив и добавляем к счетчику переносов 1
                array[j] = temparray[i];
                j++;
            }
        }
        /*
        после последнего копирования элементов к счетчику была прибавлена 1
        и если счетчик остался меньше длинны массива, значит оставшиеся элементы нужно обнулить
         */
        if (j< array.length) {
            for (int i = j; i < array.length; i++) {
                array[i] = 0;
            }
        }
    }

    // проверка метода и процедуры
    public static void main(String[] args) {
	int[] a = {23, 56, 0, 78, 0, 0, 34, 56, 0, 89};
    int n = 56;
    System.out.println(getIndexFromArray(n, a));
    moveToLeft(a);
    for (int i: a) {
        System.out.print(i + " ");
    }
    }
}
