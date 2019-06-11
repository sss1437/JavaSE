package day14;


import java.util.Arrays;

/**
 * @Description:
 * @Author: zdd
 * @Date: 2019/6/11
 */

class Gift {
    public int getValue(int[] gifts, int n) {
        Arrays.sort(gifts);
        int count = 0;
        int i = 0;
        while (i<n){
            if (gifts[i] == gifts[n/2+1]){
                count++;
            }
            i++;
        }
        if (count > n/2+1){
            return gifts[n/2];
        }else {
            return 0;
        }
    }
}
public class Test11 {
    public static void main(String[] args){
        Gift gift = new Gift();
        int[] gifts = new int[]{1,2,3,2,2};
        int n = gift.getValue(gifts,gifts.length);
        System.out.println(n);
    }
}
