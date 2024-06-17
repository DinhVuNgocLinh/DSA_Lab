import java.util.Scanner;

public class bai1_2iii {
    public static int minGap(int[] a, int n) {
        int swap;
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
        if (n < 2) {
            return 0;
        }
        int gapMin = a[1] - a[0];
        if (n >= 2) {
            for (int i = 1; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (gapMin >= (a[j] - a[i])) {
                        gapMin = a[j] - a[i];
                    }
                }
            }
        }
        return gapMin;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter n");
        int n = input.nextInt();
        System.out.println("enter array");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        System.out.println("The min gap is " + minGap(a, n));
    }
}
