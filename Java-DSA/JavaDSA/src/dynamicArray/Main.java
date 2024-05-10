package dynamicArray;

public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> array = new DynamicArray<>(10);
        DynamicArray<String> stringArray = new DynamicArray<>();

        array.add(1);
        array.add(1);
        array.add(1);

        System.out.println(array);

        stringArray.add("A");
        stringArray.add("B");
        stringArray.add("C");

        System.out.println(stringArray);
    }
}
