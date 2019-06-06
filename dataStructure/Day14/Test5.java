package day14;

import java.util.Scanner;

/**
 * @Author: zhaodoudou
 * @Date: 2019/6/6
 * @Description: day14
 * @Version: 1.0
 */
public class Test5 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int sum = scanner.nextInt();
        for (int i = 0;i < sum;i++){
            int n = scanner.nextInt();
            int[] arr1 = new int[n];
            int[] arr2 = new int[n];
            int count = scanner.nextInt();
            for (int j = 0; j < 2*n; j++){
                if (j < n){
                    arr1[j] = scanner.nextInt();
                }else {
                    arr2[j-n] = scanner.nextInt();
                }
            }
            int[] arr = new int[2*n];
            for (int j = 0; j < count; j++){
                for (int k = 0;k < arr.length; k++){
                    if (k % 2 == 0){
                        arr[k] = arr1[k/2];
                    }else {
                        arr[k] = arr2[k/2];
                    }
                }
                method1(arr,arr1,arr2);
            }
            if (i == sum-1){
                method2(arr);
            }else {
                method(arr);
            }

        }
    }
    public static void method(int[] arr){
        for (int i = 0;i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void method2(int[] arr){
        for (int i = 0;i < arr.length-1; i++){
            System.out.print(arr[i]+"#");
        }
        System.out.println(arr[arr.length-1]);
    }
    public static void method1(int[] arr,int[] arr1,int[] arr2){
        for (int i = 0;i < arr.length;i++){
           if (i < arr.length/2){
               arr1[i] = arr[i];
           }else {
               arr2[i-(arr.length/2)] = arr[i];
           }
        }
    }
}
