package SinglyLinkedList;

public class SinglyLinkedList<T> {

    private Node head;


    private static class Node<T>{

        private T data;

        private Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }

    }

    public void display() {
        Node current = head;
        while(current != null) {
            System.out.print(current.data + "--> ");
            current = current.next;
        }
        System.out.print("null");
    }



    public int length() {

        if(head == null) {
            return 0;
        }
        int count = 0;
        Node current = head;
        while(current != null) {
            count++;
            current = current.next;
        }
        return count;

    }


    public void addToBeginning(T data) {
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;
    }

    public void insertAtPosition(int position, T data) {
        Node<T> node = new Node<>(data);

        if(position == 1) {
            node.next = head;
            head = node;
        } else {
            Node previous = head;
            int count = 1;

            while(count < position - 1) {
                previous = previous.next;
                count++;
            }

            Node current = previous.next;
            previous.next = node;
            node.next = current;

        }
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if(head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while(current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public Node deleteFirst() {
        if(head == null) {
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }

    public void delete(int position) {
        if(position == 1) {
            head = head.next;
        } else {
            Node previous = head;
            int count = 1;
            while(count < position - 1) {
                previous = previous.next;
                count++;
            }

            Node current = previous.next;
            previous.next = current.next;

        }
    }

    public Node deleteLast() {
        if(head == null) {
            return head;
        }

        if(head.next == null) {
            Node temp = head;
            head = head.next;
            return temp;
        }

        Node current = head;
        Node previous = null;

        while(current.next != null) {
            previous = current;
            current = current.next;
        }

        previous.next = null;
        return current;
    }

    public Node reverse() {

        Node previous = null;

        while(head != null) {
            Node nextNode = head.next;
            head.next = previous;
            previous = head;
            head = nextNode;
        }

        return previous;

    }

    public Node reverseList(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node previous = null;
        Node next = null;
        Node curr = head;

        while(curr != null) {
            next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }
        return previous;
    }







}