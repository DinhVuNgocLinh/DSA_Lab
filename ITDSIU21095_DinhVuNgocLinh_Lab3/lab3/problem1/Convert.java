package problem1;

import java.util.Stack;

public class Convert {
    public static void main(String[] arg) {
        int decimal = 127;
        int Octal;
        Stack<Integer> stack = new Stack<>();
        System.out.print(decimal + " as Octal is ");
        while (decimal > 0) {
            Octal = decimal % 8;
            decimal = decimal / 8;

            stack.push(Octal);
        }
        int[] a = new int[stack.size()];
        for (int i = 0; i <= stack.size() + 1; i++) {
            a[i] = stack.pop();
            System.out.print(a[i]);
        }
    }
}
