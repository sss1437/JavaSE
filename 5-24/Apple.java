package Test;

import java.util.Scanner;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/24
 * @Description: Test
 * @Version: 1.0
 */

public class Apple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       if (scanner.hasNext()){
            int n = scanner.nextInt();
           System.out.println(apples(n));
        }
    }
    public static int apples(int n){
        int result = -1;
        if (n >= 1 && n <= 100) {
            for (int x = 0; x <= 16; x++) {
                for (int y = 0; y <= 12; y++) {
                    int num = 6 * x + 8 * y;
                    if (num == n) {
                        result = x+y;
                        return result;
                    }
                }
            }
        }
        return -1;
    }

}
