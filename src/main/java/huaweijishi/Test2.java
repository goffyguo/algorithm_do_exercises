package huaweijishi;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/19/16:22
 * @Description:
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        String[] split = line.split(",");
        if (split.length == 0){
            System.out.println("/");
            return;
        }
        String s = split[0] + "/" + split[1];
        System.out.println(s);
        String s1 = s.replaceAll("/+", "/");
        System.out.println(s1);
    }
}
