public class Main {

    public static void main(String[] args) {
        int[] array = {1, 345, 65, 87, -23, -1, 67, -4, 0};
        Sequence sequence = new Sequence();

        ByCondition isEven = number -> (number!=0 && number%2==0);

        ByCondition isSumOfFiguresisEven = number -> {
            int sumOfFigures = 0;
            while (number != 0) {
                sumOfFigures += number % 10;
                number = number / 10;
            }
            if (sumOfFigures % 2 == 0 && sumOfFigures!=0) {
                return true;
            } else {
                return false;
            }
        };

        int[] evenArray = sequence.filter(array, isEven);
        int[] evenSumOfFiguresArray = sequence.filter(array, isSumOfFiguresisEven);

        for (int i=0; i<evenArray.length; i++) {
            System.out.print(evenArray[i] + " ");
        }
        System.out.println();
        for (int i=0; i<evenSumOfFiguresArray.length; i++) {
            System.out.print(evenSumOfFiguresArray[i] + " ");
        }

    }
}
