package hauwei1;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/03/03/21:15
 * @Description:
 */
public class MainTest {
    public static void main(String[] args) {
        final int[] world = {3, 2, 3, 4};
        int[][] worlds = {{1, 4}, {6, 9}, {2, 5}};
        System.out.println(test1(world, worlds));
    }

    private static List<Integer> test1(int[] list1, int[][] list2) {
        List<Integer> longs = new ArrayList<>(list2.length);
        int test = 0;
        for (int[] ints : list2) {
            ints[0] = ints[0] - test;
            ints[1] = ints[1] - test * 2;
            test = test(list1, ints[0], ints[1]);
            longs.add(test);
        }
        return longs;
    }

    private static int test(int[] lists, int start, int end) {
        final ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = start - 1; i <= end - 1; i++) {
            arrayList.add(lists[i]);
        }
        List<Integer> collect = arrayList.stream().distinct().collect(Collectors.toList());
        return collect.size();
    }
}
