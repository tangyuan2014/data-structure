import I.Stack;

/**
 *
 */

public class ArrayStack<E> implements Stack<E> {

    private Arr<E> array;

    public ArrayStack(int capacity) {
        array = new Arr<E>(capacity);
    }

    public ArrayStack() {
        array = new Arr<E>();
    }

    public int getSize() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    public void push(E e) {
        array.addLast(e);
    }

    public E pop() {
        return array.deleteLast();
    }

    public E peek() {
        return array.getLast();
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("I.Stack");
        res.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }
}
