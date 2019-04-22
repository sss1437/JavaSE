package multithreading;

/**
 * @Author: zhaodoudou
 * @Date: 2019/4/20
 * @Description: multithreading
 * @Version: 1.0
 */


/**同步代码块复习
 * 1.synchronized (this){}
 */
/*
class Mythread implements Runnable{
    @Override
    public void run() {
        //this锁的是mt，而不是thread1  thread2
        synchronized (this){}
    }
}

public class Test2 {
    public static void main(String[] args){
        Mythread mt = new Mythread();
        Thread thread1 = new Thread(mt);
        Thread thread2 = new Thread(mt);
        thread1.start();
        thread2.start();
    }
}
*/
//2.synchronized (类名称.class){}--全局锁
//3.synchronized(obj){}

import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 同步方法：
 * 1.普通方法--锁当前对象this
 * 2.静态方法--锁类对象--全局锁
 */
//wait()

/*
class MyThread implements Runnable{

    @Override
    public void run() {
        synchronized (this){
            try {
                System.out.println("wait方法开始。。");
                wait(1000);
                System.out.println("wait方法结束。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Test2{
    public static void main(String[] args){
        MyThread mt = new MyThread();
        Thread thread1 = new Thread(mt);
        thread1.start();
    }
}
*/
//notify()
/*
class MyThread implements Runnable{

    private boolean flag;
    private Object object;

    public MyThread(boolean flag, Object object) {
        this.flag = flag;
        this.object = object;
    }

    public  void waitMethod(){
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+"wait begin...");
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"wait end...");
        }

    }
    public void notifyMethod(){
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+"notify begin...");
            object.notify();
            System.out.println(Thread.currentThread().getName()+"notify end...");
        }
    }
    @Override
    public void run() {
        if(flag){
            waitMethod();
        }else {
            notifyMethod();
        }

    }
}
public class Test2{
    public static void main(String[] args){
        Object object = new Object();
        for(int i = 0;i < 10; i++){
            Thread waitMethod = new Thread(new MyThread(true,object),"wait-thread "+i);
            waitMethod.start();
        }
        Thread notifyMethod = new Thread(new MyThread(false,object),"notify-thread ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        notifyMethod.start();
    }
}
*/


/**
 * 1.写两个线程一个线程打印1~52，另一个线程打印A~Z
 * 打印顺序12A34B...5152Z；
 */
/*
class Print {
    //信号量
    private boolean flag = true;
    private int count = 1;

    //打印数字
    public synchronized void printNum(){
        if(flag == false){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(2*count-1);
        System.out.print(2*count);
        //该打印字母线程执行
        flag = false;
        notify();
    }
    //打印字母
    public synchronized void printChar(){
        if(flag == true){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print((char)('A'+count-1));
        flag = true;
        count++;
        notify();
    }

}
public class Test2{
    public static void main(String[] args){
        Print print = new Print();
        new Thread(()->{
            for(int i = 0;i < 26; i++){
                print.printNum();
            }
        }).start();
        new Thread(()->{
            for(int i = 0;i < 26; i++){
                print.printChar();
            }
        }).start();
    }
}
*/


/**
 * 2.编写一个线程，启动三个线程，三个线程的名称分别是A，B，C；
 * 每个线程将自己的名称在屏幕上打印5遍，打印顺序ABCABCABC...
 */
/*
class Print{
    private int flag = 1;
    private int count = 0;

    public int getCount() {
        return count;
    }

    public synchronized void printA(){
        //不能为if（），wait（）以后继续往下执行，而if（）只能判断一次，三个线程同时进来
        while (flag!=1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag = 2;
        notifyAll();
        count++;

    }

    public synchronized void printB() {
        while (flag != 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag = 3;
        notifyAll();
        count++;
    }

    public synchronized void printC() {
        while (flag != 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(Thread.currentThread().getName());
        flag = 1;
        notifyAll();
        count++;
    }
}
class MyThread implements Runnable{
  private Print print;

    public MyThread(Print print) {
        this.print = print;
    }

    @Override
    public void run() {
        //13判断的是A出现（count的次数）
        while (print.getCount() < 13){
            //判断名称：printA为例flag3也可以进，此时printA打印的是C，
            // 虽然也是按照线程一二三打印但是并不会按照ABC顺序
            if(Thread.currentThread().getName().equals("A")){
                print.printA();
            }else if (Thread.currentThread().getName().equals("B")){
                print.printB();
            }else if(Thread.currentThread().getName().equals("C")){
                print.printC();
            }
        }
    }
}
public class Test2{
    public static void main(String[] args){
        Print print = new Print();
        MyThread mt = new MyThread(print);
        new Thread(mt,"A").start();
        new Thread(mt,"B").start();
        new Thread(mt,"C").start();
    }
}
*/





































