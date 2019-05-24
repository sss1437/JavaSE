package Test;

import java.util.Scanner;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/24
 * @Description: Test
 * @Version: 1.0
 */

public class Test2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String strA = scanner.nextLine();
            String strB = scanner.nextLine();
            //They are students. aeiou
            int n1 = strA.length();
            int n2 = strB.length();
            char[] tempA = strA.toCharArray();
            char[] tempB = strB.toCharArray();
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < n2; j++) {
                    if (tempA[i] != tempB[j]) {
                        String string = new String(tempB, j, 1);
                        strA = strA.replace(string, "");
                    }
                }
            }
            System.out.println(strA);
        }
    }
}
