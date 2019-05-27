package Test;

import java.util.Scanner;
/**
 * @Author: zhaodoudou
 * @Date: 2019/5/26
 * @Description: Test
 * @Version: 1.0
 */
public class Test8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            System.out.println(numMin(A, B));
        }
    }

    public static int numMin(int A, int B) {
        if (A < B) {
            int X = A;
            A = B;
            B = X;
        }
        int i = 1;
        int temp = (A%B);
        while (temp!= 0) {
            temp = (A*(i+1))%B;
            i++;
        }
        return i*A;
    }
}

