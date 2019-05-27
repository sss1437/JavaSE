package ConcurrentToolClass;

import java.util.Scanner;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/21
 * @Description: ConcurrentToolClass
 * @Version: 1.0
 */
//判断回文

public class Test1 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        String strA = scanner.nextLine();
        String strB = scanner.nextLine();
        int count = 0;
        if (isLowerCase(strA)&&isLowerCase(strB)){
            for (int i = 0;i <= strA.length(); i++){
                StringBuffer str = new StringBuffer(strA);
                str.insert(i,strB);
                String result = str.toString();
                if(isPalindrome(result)){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static boolean isLowerCase(String str) {
        char[] temp = str.toCharArray();
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] < 'a' && temp[i] > 'z') {
                return false;
            }else if (temp.length > 100){
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome(String str){
        char[] temp = str.toCharArray();
        for(int i = 0,j = str.length()-1;i <= j;i++,j--){
            if (temp[i]!=temp[j]){
                return false;
            }
        }
        return true;
    }
}


