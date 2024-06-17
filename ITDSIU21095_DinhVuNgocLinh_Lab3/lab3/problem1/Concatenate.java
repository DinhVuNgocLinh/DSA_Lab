package problem1;

import java.util.Stack;

public class Concatenate {
    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        s1.push(5);
        s1.push(3);
        s1.push(9);
        s1.push(7);
        System.out.println("Stack 1 is " + s1);
        Stack<Integer> s2 = new Stack<>();
        s2.push(1);
        s2.push(8);
        s2.push(4);
        s2.push(5);
        s2.push(6);
        System.out.println("Stack 2 is " + s2);
        Stack<Integer> s3 = new Stack<>();
        while (s2.empty() != true) {
            s3.push(s2.pop());
        }
        while (s3.empty() != true) {
            s1.push(s3.pop());
        }
        System.out.println("Concatenate two stack : " + s1);
    }
}
