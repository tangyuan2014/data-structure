public class LinkedList<E> {


    /**Class Node
     * public makes LinkedList can access Node;
     */
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

    /**
     * define linkedlist
     */
    private Node head;
    private int size;

    public LinkedList(){
        head =null;
        size=0;
    }

    public int getSize (){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    /**
     * insert node as head
     * @param e
     */
    public void insertFirst(E e){
        Node node=new Node(e);
        node.next=head;
        head=node;
        //head=new Node(e,head);
        size++;
    }

    /**
     * insert e into definite index
     */

    public void insert(int index,E e){
        if(index<0||index>size){
            throw new IllegalArgumentException("");
        }
        if (index==0)
            insertFirst(e);
        else{
            Node prev=head;
            for (int i=0;i<index-1;i++){
                prev=prev.next;
            }
            Node node=new Node(e);
            node.next=prev.next;
            prev.next=node;
            //prev.next=new Node(e,prev.next);
            size++;
        }
    }

    public void insertLat(E e){
        insert(size,e);
    }





}
