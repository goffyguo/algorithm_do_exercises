package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/09/24/16:00
 * @Description:
 * /**
 *      * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *      *
 *      * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *      *
 *      * 来源：力扣（LeetCode）
 *      * 链接：https://leetcode-cn.com/problems/two-sum
 *      * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *      *
 */
public class TwuSumMain1 {

    private static Map<Integer, String> map = new HashMap<Integer, String>();


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        //System.out.println(twoSum(nums, target));
        /*for(int i = 0; i < 10; i++) {
            map.put(i, "value" + i);
        }
        for(Entry<Integer, String> entry : map.entrySet()){
            Integer key = entry.getKey();
            if(key % 2 == 0){
                System.out.println("To delete key " + key);
                map.remove(key);
                System.out.println("The key " + + key + " was deleted");
            }
        }
        Set<Integer> keySet = map.keySet();
        for(Integer key : keySet){
            if(key % 2 == 0){
                System.out.println("To delete key " + key);
                keySet.remove(key);
                System.out.println("The key " + + key + " was deleted");
            }
        }

        Iterator<Entry<Integer, String>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Entry<Integer, String> entry = it.next();
            Integer key = entry.getKey();
            if(key % 2 == 0){
                System.out.println("To delete key " + key);
                it.remove();
                System.out.println("The key " + + key + " was deleted");

            }
        }
*/
        for (int i : test2(nums, target)) {
            System.out.println(i);
        }
    }


    /*暴力法*/

    /**
     * 遍历每一个元素x,并查找是否存在一个值与target-x值相等的目标元素
     *
     * @param nums   数组
     * @param target 目标值
     * @return int[]
     */
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No");
    }

    /*两遍hash法*/

    /**
     * 第一次迭代中，我们将每个元素的值和它的索引添加到表中。然后，在第二次迭代中，
     * 我们将检查每个元素所对应的目标元素（target - nums[i]target−nums[i]）是否存在于表
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        /*Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No");*/
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        // // 双重循环 循环极限为(n^2-n)/2
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = nums.length - 1; j > i; j --){
        //         if(nums[i]+nums[j] == target){
        //            indexs[0] = i;
        //            indexs[1] = j;
        //            return indexs;
        //         }
        //     }
        // }
        return indexs;
    }
    public static int [] test1(int[] nums,int target){
        /**
         * 暴力破解思路
         * int [] nums = {2,7,12,16,18}  target = 9
         * 首先循环第一次可以利用target减去数组中的一个数，再循环第二次
         * 此方法是时间复杂度为O(n2)
         */
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <nums.length+1; j++) {
                if (target-nums[i]==nums[j]){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
    public static int [] test2(int[] nums,int target){
        /**
         * 利用hashmap思路
         * hash算法存取时间复杂度都为O(1),双链表实现
         * 先遍历，如果存在
         * k 是值 v 是下标
         */
        Map<Integer,Integer> map = new HashMap<>(16);

        for (int i = 0; i < nums.length; i++) {
            int i1 = target - nums[i];
            if (map.containsKey(i1)){
                return new int[]{map.get(i1),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
