package day14;
/**
 * @Author: zhaodoudou
 * @Date: 2019/6/6
 * @Description: day14
 * @Version: 1.0
 */
import java.util.Scanner;
public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int sum = scanner.nextInt();
            int count = 0;
            int[] arr = new int[sum];
            for (int i = 0; i < sum; i++) {
                arr[i] = scanner.nextInt();
            }
            int result = scanner.nextInt();
            for (int i = 0; i < sum; i++) {
                if (arr[i] == result) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
