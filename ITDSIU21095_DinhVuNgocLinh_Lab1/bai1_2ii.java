import java.util.Scanner;

public class bai1_2ii {
    public static double findMedian() {
        Scanner input = new Scanner(System.in);

        System.out.println("enter n");
        int n = input.nextInt();
        double[] a = new double[n];
        System.out.println("enter array");
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        double swap;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++)
                if (a[i] > a[j]) {
                    swap = a[i];
                    a[i] = a[j];
                    a[j] = swap;
                }
        }
        System.out.println("After sorting");
        for (int i = 0; i < n; i++) {
            System.out.print((int) a[i] + " ");
        }
        System.out.println();
        int pos1 = n / 2;
        int pos2 = n / 2 - 1;
        double median = 0;
        if (n % 2 == 0) {
            median = ((double) a[pos1] + (double) a[pos2]) / 2;
        }
        if (n % 2 != 0) {
            median = a[pos1];
        }
        return median;
    }

    public static void main(String[] args) {
        System.out.println("median is " + findMedian());
    }
}
