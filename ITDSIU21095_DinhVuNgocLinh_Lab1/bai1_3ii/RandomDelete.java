package bai1_3ii;

import java.util.Random;
import java.util.Scanner;

public class RandomDelete {
    public static int removeRandom0(int a[], int n) {
        Random random = new Random();
        int j;
        int randomDelete = random.nextInt(10);
        for (j = 0; j < n; j++) {
            if (a[j] == randomDelete) {
                break;
            }
        }
        System.out.println("\nThe random number to delete by using nextInt() is " + randomDelete);

        for (int k = j; k < n - 1; k++) {
            a[k] = a[k + 1];
        }
        return n - 1;
    }
    public static int removeRandom1(int a[], int n) {
        Random random = new Random();
        int j;
        int randomDelete = 6;
        for (j = 0; j < n; j++) {
            if (a[j] == randomDelete) {
                break;
            }
        }
        System.out.println("\nThe random number to delete (fixed number)  is " + randomDelete);

        for (int k = j; k < n - 1; k++) {
            a[k] = a[k + 1];
        }
        return n - 1;
    }
    public static int removeRandom2(int a[], int n) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int j;
        System.out.println("\nEnter a num need to delete from 0 to 9");
        int randomDelete = input.nextInt();
        for (j = 0; j < n; j++) {
            if (a[j] == randomDelete) {
                break;
            }
        }
        System.out.println("\nThe random number to delete entered by user is " + randomDelete);

        for (int k = j; k < n - 1; k++) {
            a[k] = a[k + 1];
        }
        return n - 1;

    }

    public static void main(String[]args){
        Random random = new Random();
        int n1 = 10;
        int a[] = new int[n1];
        for (int i = 0; i < a.length; i++) {
            a[i] = random.nextInt(10);
        }
        System.out.println("Array before deleting");
        for (int i = 0; i < n1; i++){
            System.out.print(a[i] + " ");
        }
        n1 = removeRandom0(a, n1);
        System.out.println("Array after deleting");
        for (int i = 0; i < n1; i++) {
            System.out.print(a[i] + " ");
        }

        int n2 = 10;
        int b[] = new int[n2];
        for (int i = 0; i < b.length; i++) {
            b[i] = random.nextInt(10);
        }
        System.out.println("\nArray before deleting");
        for (int i = 0; i < n2; i++){
            System.out.print(b[i] + " ");
        }
        n2 = removeRandom1(b, n2);
        System.out.println("Array after deleting");
        for (int i = 0; i < n2; i++){
            System.out.print(b[i] + " ");
        }

        int n3 = 10;
        int c[] = new int[n3];
        for (int i = 0; i < c.length; i++) {
            c[i] = random.nextInt(10);
        }
        System.out.println("\nArray before deleting");
        for (int i = 0; i < n3; i++){
            System.out.print(c[i] + " ");
        }
        n3 = removeRandom2(c, n3);
        System.out.println("Array after deleting");
        for (int i = 0; i < n3; i++) {
            System.out.print(c[i] + " ");
        }
    }
}
