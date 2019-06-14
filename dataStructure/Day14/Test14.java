package day14;

import java.util.Scanner;

/**
 * @Description: 凯撒密码
 * @Author: zdd
 * @Date: 2019/6/12
 */
public class Test14 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();
            for (int i = 0;i <chars.length; i++){
                if (chars[i]>=65&&chars[i]<=90){
                    char c = ' ' ;
                    if (chars[i] < 70){
                         c = (char)(chars[i]+21);
                    }else {
                         c = (char) (chars[i] - 5);
                    }
                    System.out.print(c);
                }
                if (chars[i]==32){
                    System.out.print(chars[i]);
                }
            }
            System.out.println();
        }
    }
}
