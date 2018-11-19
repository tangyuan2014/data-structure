import I.Queue;

public class LinkedListQueue<E> implements Queue<E> {

    private class Node{
        public E e;
        public Node next;

        public Node(E e,Node next){
            this.e=e;
            this.next=next;
        }

        public Node(E e){
            this (e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString (){
            return e.toString();
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue(){
        head=null;
        tail=null;
        size=0;
    }

    @Override
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public void enqueue(E e){
        if(tail==null){
            tail=new Node(e);
            head=tail;
        }else{
        Node node=new Node(e);
        tail.next=node;
        tail=tail.next;
        }
        size++;
    }

    @Override
    public E dequeue(){
        if(size==0){
            throw new IllegalArgumentException();
        }
        Node ret=head;
        head=head.next;
        ret.next=null;
        if(head==null){
            tail=null;
        }
        size--;
        return ret.e;
    }
    @Override
    public E getFront(){
        if(head==null){
            throw new IllegalArgumentException();
        }
        return head.e;
    }
}
