package bai1_3ii;
//problem 2.2
public class removeMax {
    public static int removeMax(int[] a, int n) {
        int maxValue = a[0];
        int i;
        for (i = 1; i < n; i++) {
            if (a[i] > maxValue) {
                maxValue = a[i];
            }
        }

        int j;
        for (j = 0; j < n; j++) {
            if (a[j] == maxValue) {
                break;
            }
        }
        System.out.println("\nMax value is " + maxValue);

        for (int k = j; k < n - 1; k++) {
            a[k] = a[k + 1];
        }
        return n - 1;
    }

    public static void main(String[] args) {
        int a[] = { 45, 86, 34, 76, 28 };
        int n = a.length;
        // Scanner input = new Scanner(System.in);
        // System.out.println("enter n");
        // int n = input.nextInt();
        // System.out.println("enter array");
        // int a[] = new int[n];
        // for (int i = 0; i < n; i++) {
        // a[i] = input.nextInt();
        // }
        System.out.println("Array before deleting max value is ");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }

        n = removeMax(a, n);
        System.out.println("Array after deleting max value is");
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
