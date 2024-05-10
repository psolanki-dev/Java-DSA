package BinaryHeap;

import java.util.*;

public class BinaryHeap<T extends Comparable<T>> {

    private List<T> heap = null;

    // Initialise empty priority queue
    public BinaryHeap() {
        this(1);
    }

    public BinaryHeap(int sz) {
        heap = new ArrayList<>(sz);
    }

    public BinaryHeap(T[] elems) {

        int heapSize = elems.length;
        heap = new ArrayList<T>(heapSize);

        // Place elements in heap
        for (int i = 0; i < heapSize; i++) heap.add(elems[i]);

        // Heapify O(n)
        for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--) sink(i);

    }

    public BinaryHeap(Collection<T> elems) {

        int heapSize = elems.size();
        heap = new ArrayList<T>(heapSize);

        heap.addAll(elems);

        // Heapify  O(n)
        for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--) sink(i);

    }

    public boolean isEmpty() {
        return size() == 0;
    }

    // Clears everything inside the heap, O(n)
    public void clear() {
        heap.clear();
    }
    public int size() {
        return heap.size();
    }

    // Return the value of the element with the lowest priority in this priority queue.
    public T peek() {
        if (isEmpty()) return null;
        return heap.get(0);
    }

    // Remove root of the heap, O(log(n))
    public T poll() {
        return removeAt(0);
    }

    // Test if an element is in heap, O(n)
    public boolean contains(T elem) {
        for (int i = 0; i < size(); i++) if (heap.get(i).equals(elem)) return true;
        return false;
    }

    // Adds an element to the priority queue, O(log(n))
    public void add(T elem) {

        if (elem == null) throw new IllegalArgumentException();

        heap.add(elem);

        int indexOfLastElem = size() - 1;
        swim(indexOfLastElem);
    }

    private boolean less(int i, int j) {
        T node1 = heap.get(i);
        T node2 = heap.get(j);
        return node1.compareTo(node2) <= 0;
    }
    private void swim(int k) {
        // Get the index of the next parent node to k
        int parent = (k - 1) / 2;

        while (k > 0 && less(k, parent)) {
            swap(parent, k);
            k = parent;

            // Get the index of the next parent node to k
            parent = (k - 1) / 2;
        }
    }

    private void sink(int k) {
        int heapSize = size();
        while (true) {
            int left = 2 * k + 1; // Left  node
            int right = 2 * k + 2; // Right node
            int smallest = left; // Assume the left is the smallest node of the two children

            if (right < heapSize && less(right, left)) smallest = right;

            if (left >= heapSize || less(k, smallest)) break;

            swap(smallest, k);
            k = smallest;
        }
    }

    // Swap two nodes
    private void swap(int i, int j) {
        T elem_i = heap.get(i);
        T elem_j = heap.get(j);

        heap.set(i, elem_j);
        heap.set(j, elem_i);
    }

    public boolean remove(T element) {
        if (element == null) return false;
        for (int i = 0; i < size(); i++) {
            if (element.equals(heap.get(i))) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    private T removeAt(int i) {
        if (isEmpty()) return null;

        int indexOfLastElem = size() - 1;
        T removed_data = heap.get(i);
        swap(i, indexOfLastElem);

        heap.remove(indexOfLastElem);

        if (i == indexOfLastElem) return removed_data;
        T elem = heap.get(i);

        sink(i);

        if (heap.get(i).equals(elem)) swim(i);
        return removed_data;
    }

    public boolean isMinHeap(int k) {
        int heapSize = size();
        if (k >= heapSize) return true;

        int left = 2 * k + 1;
        int right = 2 * k + 2;

        if (left < heapSize && !less(k, left)) return false;
        if (right < heapSize && !less(k, right)) return false;

        return isMinHeap(left) && isMinHeap(right);
    }

    @Override
    public String toString() {
        return heap.toString();
    }



}
