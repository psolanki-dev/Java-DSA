package doublyLinkedList;

public class Node<T> {

    private T data;
    public Node previous;
    public Node next;

    public Node(T data) {
        previous = null;
        this.data = data;
        next = null;
    }

    public Node(Node previous, T data, Node next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    public T data() {
        return data;
    }

}
