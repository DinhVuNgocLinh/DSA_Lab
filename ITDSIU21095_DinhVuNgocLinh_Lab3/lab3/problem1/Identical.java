package problem1;

import java.util.Stack;

public class Identical {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(5);
        s1.push(3);
        s1.push(9);
        s1.push(7);
        System.out.println("Stack 1 is " + s1);
        Stack<Integer> s2 = new Stack<>();
        s2.push(5);
        s2.push(3);
        s2.push(9);
        s2.push(7);
        // s2.push(6);
        System.out.println("Stack 2 is " + s2);

        if (s1.size() != s2.size()) {
            System.out.println("Two stack are not identical");

        } else {
            while (s1.empty() != true) {
                if (s1.pop() == s2.pop()) {
                    System.out.println("Two stack are identical");
                } else {
                    System.out.println("Two stack are not identical");
                }
                break;
            }
        }
    }
}