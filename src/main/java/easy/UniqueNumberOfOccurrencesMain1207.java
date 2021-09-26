package easy;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/09/26/16:49
 * @Description: 独一无二的出现次数
 *
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 */
public class UniqueNumberOfOccurrencesMain1207 {
    public static void main(String[] args) {
       /* int [] arr = {1,2,3,3,3,4,3,4,4};
        System.out.println(uniqueOccurrences(arr));*/
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        List<Integer> list2 = new ArrayList<>();

        list.retainAll(list2);
        System.out.println(list);

    }
    public static boolean uniqueOccurrences(int [] arr){
        Map<Integer,Integer> map = new HashMap<>(16);
        Set<Integer> set =new HashSet<>();

        for (int data : arr) {
            if (map.get(data) == null) {
                map.put(data, 1);
            } else {
                map.put(data, map.get(data) + 1);
            }
        }
        for (Integer i:map.values()){
            if (!set.add(i)){
                return false;
            }
        }
        return true;
    }
}
