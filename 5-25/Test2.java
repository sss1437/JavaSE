package Day2;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/25
 * @Description: Day2
 * @Version: 1.0
 */
import java.util.Scanner;
public class Test2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()){
            String str = scanner.nextLine();
            char[] data = str.replace(" ","").toCharArray();
            System.out.println(sameNum(data));
        }
    }
    public static char sameNum(char[] data){
        int count = 0;
        for (int i = 0;i < data.length; i++){
            for (int j = i+1;j < data.length;j++){
                if (data[i] == data[j]){
                    count++;
                    if (count >= data.length/2){
                        return data[i];
                    }
                }
            }
        }
        return ' ';
    }
}
