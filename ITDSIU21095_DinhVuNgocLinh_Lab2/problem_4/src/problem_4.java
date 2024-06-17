import java.util.Random;

public class problem_4 {
    public static void bubbleSort(int[] a){
        int n = a.length;
        int swapCounter = 0;
        int comparisonCounter = 0;
        int copyCounter = 0;
        for (int out = n - 1; out >= 1; out--) {
            for (int in = 0; in < out; in++) {
                if (a[in] > a[in + 1]) {
                    comparisonCounter++;
                    int temp = a[in];
                    copyCounter++;
                    a[in] = a[in+1];
                    copyCounter++;
                    a[in +1] = temp;
                    copyCounter++;
                    swapCounter++;
                }
            }
        }
        System.out.println("\nThe total number of copies after the inner loop bubbleSort= " + copyCounter);
        System.out.println("The total number of comparison after inner loop bubbleSort= " + comparisonCounter);
        System.out.println("The total number of swaps after the inner loop bubbleSort= " + swapCounter);
    }
    public static void selectionSort(int[] a){
        int n = a.length;
        int comparisonCounter = 0;
        int swapCounter = 0;
        int copyCounter = 0;
        for(int out = 0; out<n-1;out++){
            int min = out;
            for (int in = out +1 ; in<n; in++){
                if (a[in] < a[min]){
                    comparisonCounter++;
                    min = in;
                }
            }
            int temp = a[out];
            copyCounter++;
            a[out] = a[min];
            copyCounter++;
            a[min] = temp;
            copyCounter++;

            swapCounter++;

        }
        System.out.println("\nThe total number of copies after the inner loop selectionSort= " + copyCounter);
        System.out.println("The total number of comparison after inner loop selectionSort= " + comparisonCounter);
        System.out.println("The total number of swaps after the inner loop selectionSort= " + swapCounter);
    }
    public static void insertionSort(int[] a){
        int n = a.length;
        int comparisonCounter = 0;
        int swapCounter = 0;
        int copyCounter = 0;
        for (int out = 1; out<n;out++){
            int temp = a[out];
            copyCounter++;
            int in = out;
            while (in>0 && a[in-1] >= temp){
                comparisonCounter++;
                a[in] = a[in-1];
                copyCounter++;
                in--;
            }
            a[in] = temp;
            copyCounter++;
            swapCounter++;
        }
        System.out.println("\nThe total number of copies after the inner loop insertionSort= " + copyCounter);
        System.out.println("The total number of comparison after inner loop insertionSort= " + comparisonCounter);
        System.out.println("The total number of swaps after the inner loop insertionSort= " + swapCounter);
    }
    public static int[] generateArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++){
            array[i] = rand.nextInt(size) + 1;
        }
        return array;
    }
    public static void main(String[] args) {
        int[] sizes = {10000, 15000, 20000, 25000, 30000, 35000, 40000, 45000, 50000};
        for (int size : sizes) {
            int[] a = generateArray(size);
            bubbleSort(a);

            int[] b = generateArray(size);
            selectionSort(b);

            int[] c = generateArray(size);
            insertionSort(c);
        }
    }
}
//