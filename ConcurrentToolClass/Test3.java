package ConcurrentToolClass;

import java.util.Scanner;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/22
 * @Description: ConcurrentToolClass
 * @Version: 1.0
 */
public class Test3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n;
        while (scanner.hasNext()){
            n = scanner.nextInt();
            System.out.println(huanQiShui(n));
        }
    }
    private static int huanQiShui(int x){
        int count = 0;
        while(x!=0){
            int a = x/3;
            int b = x%3;
            count += a;
            x = a+b;
            if (x==2){
                count++;
                break;
            }else if (x==1){
                return count;
            }
        }
        return count;
    }
}
