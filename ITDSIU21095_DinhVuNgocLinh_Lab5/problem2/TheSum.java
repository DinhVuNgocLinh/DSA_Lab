package problem2;

public class TheSum {
    public TheSum() {
    }

    public static void main(String[] args) {
        System.out.println(sum(7));
    }

    public static double sum(int n) {
        if (n == 1) {
            return 1.0;
        } else {
            double num = 1.0 / (double) n;
            return num + sum(n - 1);
        }
    }
}
