package huawei.huaweijishi;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/19/17:10
 * @Description:
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = Arrays.stream(in.nextLine().split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sum = Integer.parseInt(in.nextLine());
        in.close();

    }
}
