package ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(33);
        numbers.add(15);
        numbers.add(11);
        numbers.add(89);
        numbers.add(17);
        numbers.add(21);
        numbers.add(89);
        numbers.add(123);
        numbers.add(321);

        numbers.removeAt(2);

        System.out.println(numbers.get(2));



    }
}

