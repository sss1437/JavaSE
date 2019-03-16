/*
package www;

        *
        * @Author: zhaodoudou
        * @Date: 2019/3/7
        * @Description: www
        * @Version: 1.0


interface InterfaceA {
    String S = "good ";
    void f();
}

abstract class ClassA {
    abstract void g();
}

class ClassB extends ClassA implements InterfaceA {
    void g() {
        System.out.print(S);
    }

    public void f() {
        System.out.print(" "+ S);
    }
}
public class Test {
    public static void main(String[] args) {
        ClassA a = new ClassB();
        InterfaceA b = new ClassB();
        a.g();
        b.f();
    }
}

2.编程题:
        利用接口做参数，写个计算器，能完成加减乘除运算。
        （1）定义一个接口Compute含有一个方法int computer(int n, int m)。
        （2）设计四个类分别实现此接口，完成加减乘除运算。
        （3）设计一个类UseCompute，类中含有方法：public void useCom(Compute com, int one, int two)，
        此方法能够用传递过来的对象调用computer方法完成运算，并输出运算的结果。
        （4）设计一个主类Test，调用UseCompute中的方法useCom来完成加减乘除运算。


public class Test{
    public static void main(String[] args){
        UseComputer useComputer = new UseComputer();
        useComputer.useCom(new add(),10,20);

    }

}
interface ICompute{
    int computer(int n,int m);
}
class add implements ICompute{
    @Override
    public int computer(int n, int m) {
        int sum = n + m;
        return sum;
    }
}
class subtract implements ICompute{
    @Override
    public int computer(int n, int m) {
        int sub = n-m;
        return sub;
    }
}
class multiply implements ICompute{
    @Override
    public int computer(int n, int m) {
        int mul = n*m;
        return mul;
    }
}
class divide implements ICompute{
    @Override
    public int computer(int n, int m) {
        if (m != 0) {
            int divide = n / m;
            return divide;
        }else{
            System.out.println("分母不能为0");
            return 0;
        }
    }
}
class UseComputer{
    public void useCom(ICompute com,int one, int two){
        System.out.println(com.computer(one,two));
    }
}

3.按如下要求编写Java程序：
        （1）定义接口A，里面包含值为3.14的常量PI和抽象方法double area()。
        （2）定义接口B，里面包含抽象方法void setColor(String c)。
        （3）定义接口C，该接口继承了接口A和B，里面包含抽象方法void volume()。
        （4）定义圆柱体类Cylinder实现接口C，该类中包含三个成员变量：底圆半径radius、
        圆柱体的高height、颜色color。
        （5）创建主类来测试类Cylinder。

public class Test{
    public static void main(String[] args){
        Cylinder cylinder = new Cylinder(1,2,"红色");
        System.out.println(cylinder.area());
        cylinder.setColor("红色");
        cylinder.volume();
    }
}
interface A{
    final static double PI = 3.14;
    //area:面积
    abstract double area();
}
interface B{
    abstract void setColor(String c);
}
interface C extends A,B{
    //volume:体积
    abstract void volume();
}
class Cylinder implements C{
    double radius;
    double height;
    String colour;

    public Cylinder(double radius, double height, String colour) {
        this.radius = radius;
        this.height = height;
        this.colour = colour;
    }

    @Override
    public double area() {
        double area = PI*radius*radius;
        return area;
    }

    @Override
    public void setColor(String c) {
        System.out.println(c);
    }

    @Override
    public void volume() {
        System.out.println(PI*radius*radius*height);
    }
}

5.(附加题-算法)
        一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。例如6=1＋2＋3.编程 找出1000以内的所有完数。

public class Test{
    public static void main(String[] args){
        for(int i = 1;i < 1000;i++){
            int sum = 0;
            for(int j = 1;j <= i/2;j++){
                if(i%j == 0){
                    sum += j;
                }
            }
            if(i == sum){
                System.out.print(sum+" ");
            }

        }
    }
}







*/
