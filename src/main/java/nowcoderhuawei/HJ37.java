package nowcoderhuawei;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/10/14:51
 * @Description: n只兔子问题
 */
public class HJ37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            int a = 1;
            int b = 1;
            int c = 0;
            if (num == 1 || num == 2){
                System.out.println(num);
            }else {
                for (int i = 2; i < num; i++) {
                    c = a + b;
                    a = b;
                    b = c;
                }
                System.out.println(c);
            }
        }
    }
}
