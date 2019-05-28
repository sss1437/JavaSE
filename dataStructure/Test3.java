package Test;
import java.util.Arrays;
import java.util.Scanner;
/**
 * @Author: zhaodoudou
 * @Date: 2019/5/28
 * @Description: 找出n个数里最小的k个
 * @Version: 1.0
 */
public class Test3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str1 = scanner.nextLine();
            String[] strings=str1.split(" ");
            int[] arr =new int[strings.length-1];
            int num = Integer.parseInt(strings[strings.length-1]);
            for (int i = 0;i < strings.length-1;i++){
                //parseInt():将字符串转化为数组
                arr[i] = Integer.parseInt(strings[i]);
                //System.out.println(arr[i]);
            }
            Arrays.sort(arr);
            for (int i = 0;i<num;i++){
                System.out.print(arr[i]+" ");
            }
        }
    }
}
