package huaweijishi;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/19/15:25
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = Arrays.stream(in.nextLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sum = Integer.parseInt(in.nextLine());
        in.close();

        int maxLength = 0;
        for (int i = 0; i < list.size(); i++) {
            int temSum = 0;
            int subLen = 0;
            for (int j = i;j<list.size(); j++){
                temSum+= list.get(j);
                subLen++;
                if (temSum == sum && subLen > maxLength){
                    maxLength = subLen;
                }
            }
        }
        maxLength = maxLength == 0 ? -1 : maxLength;
        System.out.println(maxLength);
    }

}
