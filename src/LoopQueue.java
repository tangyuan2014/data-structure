import I.Queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            reSize(2 * getCapacity());
        }
        data[tail] = e;

        tail = (tail + 1) % data.length;
        size++;

    }

    @Override
    public E dequeue() {
        if (front == tail) {
            throw new IllegalArgumentException("wrong");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            reSize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LoopQueue: front [");
        for (int i = 0; i < size; i++) {
            res.append(data[(i + front) % data.length]);
            if (i != size - 1) {
                res.append(",");
            }
            /**
             * for (int i = front; i !=tail; (i+1)/data.length) {
             *             res.append(data[i]);
             *             if ((i+1)/data.length!=tail) {
             *                 res.append(",");
             *             }
             */
        }
        res.append("] tail");
        return res.toString();
    }

    private void reSize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }


}
