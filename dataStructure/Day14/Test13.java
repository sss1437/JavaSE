package day14;

import java.util.Scanner;

/**
 * @Description: 迭代输出fib数
 * @Author: zdd
 * @Date: 2019/6/12
 */
public class Test13 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int monthCount = in.nextInt();
            System.out.println(getTotalCount(monthCount));
        }
    }
    public static int getTotalCount(int monthCount){
        if (monthCount==1){
            return 1;
        }
        if (monthCount==2){
            return 1;
        }else{
            return getTotalCount(monthCount-1)
                    +getTotalCount(monthCount-2);
        }
    }
}
