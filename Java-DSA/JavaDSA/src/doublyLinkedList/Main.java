package doublyLinkedList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> intlist = new DoublyLinkedList<Integer>();
        intlist.addFirst(10);
        intlist.add(20);
        intlist.add(30);
        intlist.add(40);
        intlist.add(50);
        intlist.addLast(60);
        intlist.removeAt(5);
        System.out.println(intlist);
    }
}
