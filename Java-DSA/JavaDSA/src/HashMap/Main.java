package HashMap;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, String> myHashMap = new MyHashMap<>();
        myHashMap.put("A", "B");
        myHashMap.put("9", "V");
        myHashMap.put("1", "B");
        myHashMap.put("W", "A");
        myHashMap.put("B", "P");
        myHashMap.put("K", "R");
        myHashMap.put("E", "E");
        myHashMap.put("4", "3");
        myHashMap.put("Y", "O");

        System.out.println(myHashMap);
        System.out.println(myHashMap.get("A"));
        System.out.println(myHashMap.remove("A"));
        System.out.println(myHashMap);
    }
}
