import java.util.*;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class CircularList {
    Node current;

    public CircularList(int numPeople, int startPerson) {
        Node head = new Node(1);
        Node prev = head;
        for (int i = 2; i <= numPeople; i++) {
            prev.next = new Node(i);
            prev = prev.next;
        }
        prev.next = head;
        current = head;

        for (int i = 1; i < startPerson; i++) {
            current = current.next;
        }
    }

    public LinkedList<Integer> eliminateEveryKth(int k) {
        LinkedList<Integer> eliminationOrder = new LinkedList<>();
        while (current != current.next) {
            for (int i = 1; i < k - 1; i++) {
                current = current.next;
            }
            eliminationOrder.add(current.next.data);
            current.next = current.next.next;
            current = current.next;
        }
        eliminationOrder.add(current.data);
        return eliminationOrder;
    }
}

public class JosephusTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of people in the circle:");
        int numPeople = scanner.nextInt();
        System.out.println("Enter the number used for counting off:");
        int k = scanner.nextInt();
        System.out.println("Enter the number of the person where counting starts:");
        int startPerson = scanner.nextInt();

        CircularList list = new CircularList(numPeople, startPerson);
        LinkedList<Integer> eliminationOrder = list.eliminateEveryKth(k);

        System.out.println("Elimination order: " + eliminationOrder.subList(0, eliminationOrder.size() - 1));
        System.out.println("Last person standing: " + eliminationOrder.getLast());
    }
}
