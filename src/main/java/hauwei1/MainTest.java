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
/**
 * 2014年8月2号，是农历一年一度的七夕节日，就在这一天，牛郎和织女又会在鹊桥相遇，在一起度过这一年唯一的一天。
 * 他们坐在鹊桥上，遥望着漫天星河，发现刚好有若干颗星星从左到右排成一排，形成了一条星星链，细心的牛郎依次给这些星星标上了序号。
 * 一共有n颗星星，序号从最左边的1开始，从左到右依次递增，直到最右边的n号星星。
 * 调皮的织女给这些星星分别设定了星愿值。
 * 调皮的织女想要知道从第x号星星到第y号星星之间（包括x和y）有多少种不同的星愿值。
 * 织女的询问有很多，你能帮助牛郎尽量快的回答织女的问题吗？
 *
 * 解答要求
 * 时间限制：3000ms, 内存限制：128MB
 * 输入
 * 第一行输入两个正整数n, q(1 <= n, q <= 100000)，表示有n颗星星和织女的q次操作询问。
 * 第二行输入n个正整数a_1, a_2, a_3, …, a_n(对于任意的1 <= i <= n，都有1 <= a_i <= n), 依次表示第1号星星到第n号星星的初始星愿值。
 * 每次织女问一个问题，牛郎就要回答出来，这里为了必须要求在线，所以我们记录一个pre，表示上一次询问的答案，每组测试数据一开始pre = 0。
 * 接下来q行，每行包含2个正整数x’, y’，真实的查询区间是[x’ - pre, y’ - pre * 2]，数据的输入保证1 <= x’ - pre <= y’ - pre * 2 <= n，
 * 查询出这个区间里有多少个不同的星愿值。
 *
 * 输出
 * 对于每个询问，输出一行一个整数，表示询问的答案，并把pre置为当前的答案。
 *
 * 样例
 * 输入样例 1 复制
 *
 * 4 3
 * 3 2 3 4
 * 1 4
 * 6 9
 * 2 5
 * 输出样例 1
 *
 * 3
 * 1
 * 2
 */
