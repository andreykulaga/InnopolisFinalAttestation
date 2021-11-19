package LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(34);
        list.add(120);
        list.add(-10);
        list.add(11);
        list.add(50);
        list.add(100);
        list.add(99);

        list.addToBegin(77);
        list.addToBegin(88);
        list.addToBegin(99);

        System.out.println(list.get(0));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(10));

    }
}

