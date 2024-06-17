import java.util.Random;

public class LinkQueueApp {
    public static void main(String[] args) throws InterruptedException {
        LinkQueue theQueue = new LinkQueue();
        Random random = new Random();
        // Simulate adding 5 customers to the queue
        for (int i = 1; i <= 5; i++) {
            theQueue.insert(i); // each customer is represented by a number
            System.out.println("Customer " + i + " enters the queue.");
            System.out.println("Current queue size: " + theQueue.size());
        }
        // simulate a queue of customers each one served for a random amount of time
        while (!theQueue.isEmpty()) {
            int serviceTime = random.nextInt(5) + 1; // Random service time between 1 and 5 seconds
            long currentCustomer = theQueue.remove(); // serve the next customer
            System.out.println("Serving Customer " + currentCustomer + " for " + serviceTime + " seconds.");
            Thread.sleep(serviceTime * 1000);// Pause execution for service time (converted to milliseconds)
            System.out.println("Customer " + currentCustomer + " leaves the queue.");
            System.out.println("Current queue size: " + theQueue.size());
        }
        System.out.println("All customers have been served.");

        theQueue.insert(20); // insert items
        theQueue.insert(40);

        theQueue.displayQueue(); // display queue

        theQueue.insert(60); // insert items
        theQueue.insert(80);

        theQueue.displayQueue(); // display queue

        theQueue.remove(); // remove items
        theQueue.remove();

        theQueue.displayQueue(); // display queue
    } // end main()
}
