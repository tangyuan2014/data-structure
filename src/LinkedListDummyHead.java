public class LinkedListDummyHead<E> {

    /**
     * Class Node
     * public makes LinkedList can access Node;
     */
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /**
     * define linkedlist
     */
    private Node dummyHead;
    private int size;

    public LinkedListDummyHead() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * insert node as head
     *
     * @param e
     */
    public void insertFirst(E e) {
        insert(0, e);
    }

    /**
     * insert e into definite index
     */

    public void insert(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
        //prev.next=new Node(e,prev.next);
        size++;
    }

    public void insertLat(E e) {
        insert(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("");
        }
        Node node = dummyHead.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLat() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("");
        }

        Node node = dummyHead.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
            node.e = e;
        }
    }

    public boolean contains(E e) {
        Node node = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (node.e.equals(e)) {
                return true;
            }
            node = node.next;
        }
        /**while(node!=null){
         * if(node.e.equals(e))
         * {
         return true;
         }
         node=node.next;
         }
         */
        return false;
    }

    public E delete(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node del = prev.next;
        prev.next = del.next;
        del.next = null;
        size--;
        return del.e;
    }

    public E deleteFirst() {
        return delete(0);
    }

    public E deleteLast() {
        return delete(size - 1);
    }

    public String toString() {

        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur.toString() + "->");
            cur = cur.next;
        }
        //for(Node cur=dummyHead.next;cur!=null;cur=cur.next)
        //res.append(cur+"->");
        res.append("null");
        return res.toString();
    }

}
