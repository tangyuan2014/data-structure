/**
 * 时间复杂度分析
 * o(1),o(n),o(lgn)
 * o代表算法的运行时间与输入数据的关系
 * o(n)代表时间与输入数据个数n呈线性关系
 * 当n趋近与无穷时，o为渐进时间复杂度；
 * 考虑最坏情况
 */

public class Arr<E> {

    private E[] data;
    private int size;

    public Arr(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Arr() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addLast(E e) {
        insert(size, e);
    }

    public void addFirst(E e) {
        insert(0, e);
    }

    public void insert(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("illegal");
        }
        if (size == data.length) {
            resize(2*data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public E get(int index) {
        if (index > size - 1 || index < 0) {
            throw new IllegalArgumentException("WRONG");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if (index > size - 1 || index < 0) {
            throw new IllegalArgumentException("WRONG");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public E delete(int index) {
        if (index > size - 1 || index < 0) {
            throw new IllegalArgumentException("wrong");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        if(size==data.length/4&&data.length/2!=0){
            resize(data.length/2);
        }
        return ret;
    }

    public E deleteFirst() {
       return delete(0);
    }

    public E deleteLast(){
        return delete(size);
    }

    public void removeElement(E e){
        int index=find(e);
        if(index!=-1){
            delete(index);
        }
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size-1);
    }




    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array Size=%d,capacity=%d\n", size, data));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i < size - 1) {
                res.append(",");
            }
        }
        res.append("]");
        return res.toString();
    }

    private void resize(int newCapacity){
        E[] newData=(E[]) new Object [newCapacity];
        for(int i=0;i<size;i++){
            newData[i]=data[i];
        }
        data=newData;
    }
}
