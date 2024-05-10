package BinaryHeap;

public class Main {
    public static void main(String[] args) {
        BinaryHeap<Integer> b = new BinaryHeap<Integer>();
        b.add(10);
        b.add(20);
        b.add(30);
        b.add(40);
        b.add(50);
        b.remove(20);
        b.contains(30);
        System.out.println(b.peek());
        System.out.println(b.toString());
    }
}
