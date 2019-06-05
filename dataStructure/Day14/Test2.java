package day14;

import java.util.Scanner;

/**
 * @Author: zhaodoudou
 * @Date: 2019/6/5
 * @Description: day14
 * @Version: 1.0
 */
public class Test2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            int sum = num*num*num;
            int temp = sum/num;
            int[] arr = new int[num];
            int mid = num/2;
            if ((temp)%2 == 1){
                arr[mid] = temp;
                for (int i = 0;i < mid; i++){
                    arr[i] = arr[mid]-2*(mid-i);
                }
                for(int i = mid+1;i < num;i++){
                    arr[i] = arr[mid]+2*(i-mid);
                }
            }else {
                arr[mid] = temp+1;
                for (int i = 0;i < mid; i++){
                    arr[i] = arr[mid]-2*(mid-i);
                }
                for(int i = mid+1;i < num;i++){
                    arr[i] = arr[mid]+2*(i-mid);
                }
            }
            for (int i = 0;i < num-1;i++){
                System.out.print(arr[i]+"+");
            }
            System.out.println(arr[arr.length-1]);
        }
    }

}
