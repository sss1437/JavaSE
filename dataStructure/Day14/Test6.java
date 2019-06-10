package day14;

/**
 * @Author: zhaodoudou
 * @Date: 2019/6/7
 * @Description: day14
 * @Version: 1.0
 */
/*
class X{
    Y y = new Y();
    public X(){
        System.out.println("X");
    }

}
class Y{
    public Y(){
        System.out.println("Y");
    }
}
public class Test6 extends X {
    Y y = new Y();
    public Test6(){
        System.out.println("Z");
    }
    public static void main(String[] args){
        new Test6();
    }
}
*/
/*
public class Test6{
    public String name = "abc";
    public static void main(String[] args){
        Test6 test = new Test6();
        Test6 test1 = new Test6();
        System.out.println(test.equals(test1)+","+test.name.equals(test1.name));

    }
}*/

public class Test6{
    private int count;
    public static void main(String[] args){
        Test6 test = new Test6(88);
        System.out.println(test.count);
    }
    Test6(int a){
        count = a;
    }
}