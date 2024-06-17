package problem6;

public class RecursiveLargest {
    public RecursiveLargest() {
    }
    public static double gcd(int p, int q) {
        return q == 0 ? (double) p : gcd(q, p % q);
    }
    public static void main(String[] args) {
        System.out.println(gcd(5, 7));
    }
}