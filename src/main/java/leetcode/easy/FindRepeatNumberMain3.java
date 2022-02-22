package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/09/24/16:02
 * @Description:
 */
public class FindRepeatNumberMain3 {


    public static void main(String[] args) {

        //findRepeatNumber();

    }

    public static int findRepeatNumber(int [] arrs){
        Set<Integer> set  = new HashSet<>();
        int repeat = -1;
        for (int arr : arrs){
            if(!set.add(arr)){
                repeat = arr;
                break;
            }
        }
        return repeat;
    }

}
