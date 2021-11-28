public class SumOfDigits extends Thread {
    private int[] array;
    private int start;
    private int finish;
    private int sum;

    public SumOfDigits(int[] array, int start, int finish) {
        this.array = array;
        this.start = start;
        this.finish = finish;
        this.sum = 0;
    }

    public void run() {
        for (int i = start; i <= finish; i++) {
            sum += array[i];
        }
    }

    public int getSum() {
        return sum;
    }
}
