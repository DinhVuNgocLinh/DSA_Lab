package bai1_3ii;
//problem 2.1
public class getMax {
    public static int getMax(int[] a, int n){
        if (n == 0){
            return -1;
        }else {
            int maxValue = a[0];
            int i;
            for (i = 1; i < n; i++) {
                if (a[i] > maxValue) {
                    maxValue = a[i];
                }
            } return maxValue;
        }
    }
    public static void main(String[] args) {
        int a[] = {45, 86, 34, 76, 28};
        int n = a.length;
        System.out.println("Max value is " + getMax(a, n));
    }
}
