package Test;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/28
 * @Description: Test
 * @Version: 1.0
 */
//static修饰属性
public class Test2 {
    static int count = 6;
    static {
        count += 9;
    }
    public static void main(String[] args){
        System.out.println(count);//count = 5;
    }
    static {
        count /= 3;
    }
}
