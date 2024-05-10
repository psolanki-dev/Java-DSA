package binarySearch;

public class binarySearch {
    public static void main(String[] args) {
        // Search algorithm that finds the position of a target value within a
        // sorted array.
        // Half of the array is eliminated during each step.

        int arr[] = {1,2,3,4,5,6,7,8,9};

        int index = binarySearch(arr, 8);
        System.out.println(index);


    }

    private static int binarySearch(int[] array, int target) {

        int low = 0;
        int high = array.length - 1;

        while(low <= high) {

            int middle = low + (high - low) / 2;
            int value = array[middle];

            System.out.println("middle: " + middle + " value: " + value);

            if(value < target) low = middle + 1;
            else if(value > target) high = middle - 1;
            else return middle;
        }

        return -1;
    }
}
