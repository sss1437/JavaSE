package day14;


/**
 * @Description:到底买不买
 * @Author: zdd
 * @Date: 2019/6/13
 */
import java.util.Scanner;
public class Test15 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int count = 0;
        for (int i = 0;i<ch1.length;i++){
            for (int j = 0;j<ch2.length;j++){
                if (ch1[i]==ch2[j]){
                    count++;
                    ch2[j] = '*';
                    break;
                }
            }
        }
        if (count==ch2.length){
            int s = ch1.length-count;
            System.out.println("Yes "+s);
        }else {
            int n = ch2.length-count;
            System.out.println("No "+n);
        }
    }
}
