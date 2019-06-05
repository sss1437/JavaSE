package day14;
import java.util.*;

/**
 * @Author: zhaodoudou
 * @Date: 2019/6/5
 * @Description: 组个最小数
 * @Version: 1.0
 */
public class Test1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] num = {0,1,2,3,4,5,6,7,8,9};
        for (int i = 0;i < 10;i++){
            num[i] = scanner.nextInt();
        }
        for (int i = 1;i < 10; i++){
            if (num[i] != 0){
                System.out.println(i);
                num[i]--;
                break;
            }
        }
        for (int i = 0;i<10;i++){
            for (int j = 0;j < num[i];j++){
                System.out.println(i);
            }
        }

    }
}
