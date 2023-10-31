package lecture05;

public class Homework {
    public static void main(String[] args) {

        reveredList();

    }

    private static void calculateSum() {
        int[] arr = {5, 10, 15, 20, 25};
        int sum = calculateSum(arr);
        System.out.println("Sum of the array elements: " + sum);
    }

    private static int calculateSum(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }
        return sum;
    }


    private static void reveredList() {

    }
}