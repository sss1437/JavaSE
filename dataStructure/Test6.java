package Test;

import java.util.Scanner;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/29
 * @Description: 末尾0的个数
 * @Version: 1.0
 */

/**
 * 解题思路：将1000里面的数因式分解，因为只要有5和偶数就可以得到0，（5*2=10）
 * 5的倍数可以贡献出一个0；
 * 5*5=25，所以25的倍数就会贡献出两个0
 * 5*5*5=125，就会多贡献出三个0
 * 5*5*5*5=625，就会贡献4个0；
 * 因此1000的阶乘的0个数为1000/5+1000/25+1000/125+1000/625= 249;
 */
public class Test6 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int result = 0;
            int sum = n;
            if (n>=1 && n<=1000){
                result = sum/5;
                if (n >= 25){
                    result +=sum/25;
                    if (n >= 125){
                        result += sum/125;
                        if (n >= 625){
                            result+=sum/625;
                        }
                    }
                }
            }
            System.out.println(result);
        }
    }

}
