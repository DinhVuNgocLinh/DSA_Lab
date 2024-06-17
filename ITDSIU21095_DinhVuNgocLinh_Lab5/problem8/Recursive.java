package problem8;

import java.util.LinkedList;

public class Recursive {
    public static void getSubsets(LinkedList<Integer> set, int index, LinkedList<Integer> current,
            LinkedList<LinkedList<Integer>> result) {

        if (index == set.size()) {
            result.add(new LinkedList<>(current));
            return;
        }

        getSubsets(set, index + 1, current, result);
        current.add(set.get(index));
        getSubsets(set, index + 1, current, result);
        current.removeLast();
    }

    public static void main(String[] args) {
        LinkedList<Integer> s1 = new LinkedList<>();
        s1.add(1);
        s1.add(2);
        s1.add(3);
        s1.add(4);
        LinkedList<LinkedList<Integer>> r1 = new LinkedList<>();
        getSubsets(s1, 0, new LinkedList<>(), r1);
        System.out.println(r1);

        LinkedList<Integer> s2 = new LinkedList<>();
        s2.add(9);
        s2.add(8);
        s2.add(7);
        LinkedList<LinkedList<Integer>> r2 = new LinkedList<>();
        getSubsets(s2, 0, new LinkedList<>(), r2);
        System.out.println(r2);
    }
}