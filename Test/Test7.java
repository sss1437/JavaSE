package Test;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/23
 * @Description: Test
 * @Version: 1.0
 */

import java.util.Scanner;

/**
 * 读入一个字符串str，输出str字符串中的连续最长的字符串
 */
public class Test7{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int max = 0;
        int count = 0;
        int end = 0;
        for (int i = 0;i < str.length(); i++){
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                count++;
                if (max < count){
                    max = count;
                    end = i;
                }
            }else {
                count = 0;
            }
        }
        System.out.println(str.substring(end-max+1,end+1));
    }
}
