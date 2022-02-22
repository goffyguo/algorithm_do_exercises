package leetcode.easy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2021/09/26/19:04
 * @Description: 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestCommonPrefixMain14 {
    public static void main(String[] args) {
        String[] str =  {"flower","flow","flight"};
        System.out.println(longestCommonPrefixTest(str));

    }
    public static String longestCommonPrefixTest(String [] args){
        if (args.length==0){
            return "";
        }
        // 最长前缀末尾位置
        int end = args[0].length()-1;
        for (String arg : args) {
            int j = 0;
            // 优化1: 不用比较整个字符串, 只要比较前缀长度即可
            for (; j <= end && j < arg.length(); ++j) {
                if (args[0].charAt(j) != arg.charAt(j)) {
                    break;
                }
            }
            // 没有公共前缀, 不用再遍历剩余字符串
            end = Math.min(end, j - 1);
            // 没有公共前缀, 不用再遍历剩余字符串
            if (end < 0) {
                break;
            }
        }
        return args[0].substring(0,end+1);
    }
    /*public static String longestCommonPrefixTest2(String[] strs) {
        if(strs.length==0){
            return "";
        }
        //公共前缀比所有字符串都短，随便选一个先
        String s=strs[0];
        for (String string : strs) {
            while(!string.startsWith(s)){
                if(s.length()==0){
                    return "";
                }
                //公共前缀不匹配就让它变短！
                s=s.substring(0,s.length()-1);
            }
        }
        return s;
    }*/
}
