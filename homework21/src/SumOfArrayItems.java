public class SumOfArrayItems extends Thread {

    public int sum(int start, int finish, int[] array) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            sum = +array[i];
        }
        return sum;
    }
}
