package day14;



/**
 * @Author: zhaodoudou
 * @Date: 2019/6/5
 * @Description: day14
 * @Version: 1.0
 */

//不使用算数运算符计算A+B
class UnusualAdd {
    public int addAB(int A, int B) {
        return B == 0 ? A:addAB(A^B,(A&B) << 1);
    }
}
public class Test3 {
    public static void main(String[] args){


    }
}
