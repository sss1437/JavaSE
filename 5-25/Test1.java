package Day2;



/**
 * @Author: zhaodoudou
 * @Date: 2019/5/25
 * @Description: Day2
 * @Version: 1.0
 */
//猜糖果
import java.util.Scanner;
public class Test1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()){
            String str = scanner.nextLine();
            int num1 = Integer.parseInt(String.valueOf(str.split(" ")[0]));
            int num2 = Integer.parseInt(String.valueOf(str.split(" ")[1]));
            int num3 = Integer.parseInt(String.valueOf(str.split(" ")[2]));
            int num4 = Integer.parseInt(String.valueOf(str.split(" ")[3]));
            int A = (num1 + num3)/2;
            int B = (num2 + num4)/2;
            int C = num4-((num2 + num4)/2);
            if (num1 == A-B && num2 == B-C && num3 == A+B && num4 == B+C){
                System.out.println(A+" "+B+" "+C);
            }else {
                System.out.println("No");
            }
        }
    }
}
