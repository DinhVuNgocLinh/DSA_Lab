import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class CircularListJosephus {
    Node current;

    public CircularListJosephus(int numPeople, int startPerson) {
        Node head = new Node(1);
        Node tail = head;
        for (int i = 2; i <= numPeople; i++) {
            tail.next = new Node(i);
            tail = tail.next;
        }
        tail.next = head;
        current = head;
        for (int i = 1; i < startPerson; i++) {
            current = current.next;
        }
    }
}

class Josephus {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of people in the circle:");
        int numPeople = input.nextInt();
        System.out.println("Enter the number used for counting off:");
        int k = input.nextInt();
        System.out.println("Enter the number of the person where counting starts:");
        int startPerson = input.nextInt();

    }
}
