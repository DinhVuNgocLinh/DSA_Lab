package problem1;

public class Puzzle {
    public static int puzzle(int base, int limit) {
        // base and limit are non-negative numbers
        // 1.base case
        if (base > limit)
            return -1;
        else if (base == limit)
            return 1;
        // recursive case
        else
            return base * puzzle(base + 1, limit);
    }

    public static void main(String[] args) {
        // 3.a
        System.out.println(puzzle(14, 10));
        // The result is display: -1
        // Since the base > limit -> we go to the first base case of function puzzle

        // 3.b
        System.out.println(puzzle(4, 7));
        // The result is displayed: 120
        // Since the base < limit -> we go to the recursive case of function puzzle
        // puzzle(4,7) --> 4 * puzzle(5,7) --> 5 * puzzle(6,7) --> 6 * puzzle(7,7) -->
        // go to second base case (base == limit) -> return 1.
        // 120 = puzzle(4,7) <-- 4 * 5 * 6 <-- 5 * (6*1) <-- 6 * 1 <--

        // 3.c
        System.out.println(puzzle(0, 0));
        // The result is displayed: 1
        // Since the base == limit -> we go to the second base case of function puzzle
    }
}