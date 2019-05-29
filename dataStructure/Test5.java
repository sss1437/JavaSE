package Test;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/29
 * @Description: Test
 * @Version: 1.0
 */
/*
public class Test5 {
    public static void main(String[] args){
        String s = " hello%worl";
        s.toUpperCase();
        System.out.println(s);// hello%worl
    }
}
*/
public class Test5{
    String str = new String("hello");
    char[] ch = {'a','b'};
    public static void main(String[] args){
        Test5 test5 = new Test5();
        test5.change(test5.str,test5.ch);
        System.out.println(test5.str+test5.ch);//hello[C@1540e19d
    }
    public void change(String str,char ch[]){
        str = "tesk";
        ch[0] = 'c';
    }
}
