package huawei.nowcoderhuawei;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/07/15:13
 * @Description: 字符串反转
 */
public class HJ12 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            char[] chars = s.toCharArray();
            for (int i = chars.length-1; i >=0 ; i--) {
                System.out.print(chars[i]);
            }
            System.out.println();
        }
    }
}
