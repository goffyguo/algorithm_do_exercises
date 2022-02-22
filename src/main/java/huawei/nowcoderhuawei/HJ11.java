package huawei.nowcoderhuawei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: GuoFei
 * @Date: 2022/02/07/14:54
 * @Description: 数字颠倒
 *
 */
public class HJ11 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        char[] chars = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int i = chars.length-1; i >=0 ; i--) {
            builder.append(chars[i]);
        }
        System.out.println(builder);
    }
}
