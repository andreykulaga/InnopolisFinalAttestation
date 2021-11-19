package ArrayList;

public class ArrayList<T> {
    private static final int DEFAULT_SIZE = 10;

    private T[] elements;
    private int size;

    public ArrayList() {
        this.elements = (T[])new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    /**
     * Добавляет элемент в конец списка
     * @param element добавляемый элемент
     */
    public void add(T element) {
        // если массив уже заполнен
        if (isFullArray()) {
            resize();
        }

        this.elements[size] = element;
        size++;
    }

    private void resize() {
        // запоминаем старый массив
        T[] oldElements = this.elements;
        // создаем новый массив, который в полтора раза больше предыдущего
        this.elements = (T[])new Object[oldElements.length + oldElements.length / 2];
        // копируем все элементы из старого массива в новый
        for (int i = 0; i < size; i++) {
            this.elements[i] = oldElements[i];
        }
    }

    private boolean isFullArray() {
        return size == elements.length;
    }

    /**
     * Получить элемент по индексу
     * @param index индекс искомого элемента
     * @return элемент под заданным индексом
     */
    public T get(int index) {
        if (isCorrectIndex(index)) {
            return elements[index];
        } else {
            return null;
        }
    }

    private boolean isCorrectIndex(int index) {
        return index >= 0 && index < size;
    }

    public void clear() {
        this.size = 0;
    }

    /**
     * Удаление элемента по индексу
     *
     * 45, 78, 10, 17, 89, 16, size = 6
     * removeAt(3)
     * 45, 78, 10, 89, 16, size = 5
     * @param index
     */
    public void removeAt(int index) {
        for (int i=index; i<(size-1); i++) {
            this.elements[i] = this.elements[i+1];
        }
        size--;
    }
}
