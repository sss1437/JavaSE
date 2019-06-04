package Test;

/**
 * @Author: zhaodoudou
 * @Date: 2019/6/3
 * @Description: Test
 * @Version: 1.0
 */
class Exchange {
    public int[] exchangeAB(int[] AB) {
        int a = AB[0];
        int b = AB[1];
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        AB[0] = a;
        AB[1] = b;
        return AB;
    }
}
public class test10 {
    public static void main(String[] args){

    }
}
