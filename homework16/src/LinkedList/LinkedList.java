package LinkedList;

public class LinkedList<T> {

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    public void add(T element) {
        // создаю новый узел
        Node<T> newNode = new Node<>(element);
        if (size == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        last = newNode;
        size++;
    }

    public void addToBegin(T element) {
        Node<T> newNode = new Node<>(element);

        if (size == 0) {
            last = newNode;
        } else {
            newNode.next = first;
        }
        first = newNode;
        size++;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        else {
            if (index == 0) {
                return first.value;
            } else {
                Node<T> newNode = first;
                for (int i=0; i<index; i++) {
                    newNode = newNode.next;
                }
                return newNode.value;
            }
        }
    }
}

