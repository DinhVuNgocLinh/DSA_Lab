package problem4;

public class RecursiveMinSum {
    public static void main(String[] args) {
        int[] a = { 66, 33, 44, 88, 77, 11, 22 };
        int[] aSorted = { 11, 22, 33, 44, 66, 77, 88 };
        int n = a.length - 1;

        System.out.println("Minimum value for unsorted array: " + findMin(a, n));
        System.out.println("Minimum value for sorted array: " + findMin(aSorted, n));
        System.out.println("Sum: " + findSum(a, n));

    }

    public static int findMin(int a[], int n) {
        if (n == 0)
            return a[0];
        else {
            int value = findMin(a, n - 1);

            if (a[n] < value) {
                return a[n];
            } else
                return value;
        }
    }

    public static int findSum(int a[], int n) {
        if (n == 0)
            return a[0];
        else {
            return a[n] + findSum(a, n - 1);
        }
    }
}