import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        LinkedListDummyHead<Integer> linkedListDummyHead=new LinkedListDummyHead<Integer>();
        for (int i=0;i<5;i++){
            linkedListDummyHead.insertFirst(i);
            System.out.println(linkedListDummyHead);
        }
        linkedListDummyHead.insert(2,777);
        System.out.println(linkedListDummyHead);
        linkedListDummyHead.delete(2);
        System.out.println(linkedListDummyHead);
        linkedListDummyHead.deleteLast();
        System.out.println(linkedListDummyHead);

    }



}

