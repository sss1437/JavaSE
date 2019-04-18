package multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: zhaodoudou
 * @Date: 2019/4/6
 * @Description: multithreading
 * @Version: 1.0
 */
/*
class MyThread extends Thread{
    private String title;
    private int ticket = 10;
    public MyThread(String title){
        this.title = title;
    }
    @Override
    public void run() {
        for(int i = 0;i < 10; i++){
            System.out.println(this.title+"剩余票数"+ticket--);
        }
    }
}
public class TestDemo {
    public static void main(String[] args){
        Thread myThread1 = new MyThread("黄牛A");
        Thread myThread2 = new MyThread("黄牛B");
        Thread myThread3 = new MyThread("黄牛C");
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}
*/
/*
class MyThread implements Runnable{
    private int ticket =10;
    @Override
    public void run() {
        for(int i = 0;i < 10; i++){
            System.out.println("还剩票数"+ticket--);
        }
    }
}
public class TestDemo{
    public static void main(String[] args){
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread);
        Thread thread2 = new Thread(myThread);
        Thread thread3 = new Thread(myThread);
        thread1.start();
        thread2.start();
        thread3.start();
    }
}*/
/*
class MyThread implements Callable<String>{
    private int ticket = 10;
    @Override
    public String call() throws Exception {
        for(int i = 0;i < 10;i++){
            System.out.println("还剩"+ticket--+"票");
        }
        return "票卖完了";
    }
}
public class TestDemo{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new MyThread();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}*/
/*class MyThread implements Runnable{
    private int ticket = 10;
    @Override
    public void run() {
        for(int i = 0;i < 10; i++){
            System.out.println(Thread.currentThread().getName()+"还剩下"+this.ticket--+"票");
        }
    }
}
public class TestDemo{
    public static void main(String[] args){
        MyThread mt = new MyThread();
        Thread thread1 = new Thread(mt,"黄牛A");
        Thread thread2 = new Thread(mt,"黄牛B");
        Thread thread3 = new Thread(mt,"黄牛C");
        thread1.start();
        thread1.setName("zdd");
        thread2.start();
        thread3.start();

    }
}*/
/*
class Mythread implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i<1000;i++){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程"+ Thread.currentThread().getName()+" "+i);
        }
    }
}

public class TestDemo{
    public static void main(String[] args){
        Mythread mt = new Mythread();
        new Thread(mt).start();
        new Thread(mt).start();
        new Thread(mt).start();
    }
}
*/
//守护线程
/*
class MyThread implements Runnable{
    @Override
    public void run() {
        int i = 1;
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"是否是守护线程"+
                        Thread.currentThread().isDaemon());
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+"退出。。。");
                return;
            }
        }

    }
}

public class TestDemo{
    public static void main(String[] args) throws InterruptedException {
        MyThread mt = new MyThread();
        Thread thread1 = new Thread(mt,"A");
        Thread thread2 = new Thread(mt,"B");
        thread1.setDaemon(true);
        thread1.start();
        thread2.start();
        Thread.sleep(3000);
        thread2.interrupt();
    }
}
*/

//同步处理
    /*//同步代码块
class MyThread implements Runnable{
    private int ticket = 10;
    @Override
    public void run() {
        for(int i = 0;i < 10; i++){
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() +
                            "还剩" + this.ticket-- + "票");
                }
            }
        }
    }
}
public class TestDemo{
    public static void main(String[] args){
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread,"黄牛A");
        Thread thread2 = new Thread(myThread,"黄牛B");
        Thread thread3 = new Thread(myThread,"黄牛C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
*/
/*
//同步方法
class MyThread implements Runnable{
    private int ticket = 10;
    @Override
    public void run() {
        for(int i = 0;i < 10; i++){
            safe();
        }
    }
    //表示此时只有一个线程能够进入此方法
    //隐式对象锁 this
    public synchronized void safe(){
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() +
                    "还剩" + this.ticket-- + "票");
        }
    }
}
public class TestDemo{
    public static void main(String[] args){
        MyThread myThread = new MyThread();
        Thread thread1 = new Thread(myThread,"黄牛A");
        Thread thread2 = new Thread(myThread,"黄牛B");
        Thread thread3 = new Thread(myThread,"黄牛C");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
*/
//证明锁的可重入性
/*
class MyThread implements Runnable{
    @Override
    public void run() {
        test1();
    }
    public synchronized void test1(){
        if(Thread.currentThread().getName().equals("A")){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A线程进入test1方法");
            test2();
        }
    }
    public synchronized void test2(){
        System.out.println(Thread.currentThread().getName()+"进入test2方法");
    }
}
public class TestDemo{
    public static void main(String[] args){

        MyThread mt = new MyThread();
        Thread thread1 = new Thread(mt,"A");
        Thread thread2 = new Thread(mt,"B");
        thread1.start();
        thread2.start();
    }
}
*/
//证明锁的互斥性
class MyThread implements Runnable{
    @Override
    public void run() {
        test1();
        test2();
    }
    public synchronized void test1(){
        if(Thread.currentThread().getName().equals("A")){
            while (true){}
        }
    }
    public synchronized void test2(){
        if (Thread.currentThread().getName().equals("B")){
            System.out.println("B线程进入该同步方法test2。。");
        }
    }
}
public class TestDemo{
    public static void main(String[] args){

        MyThread mt = new MyThread();
        Thread thread1 = new Thread(mt,"A");
        Thread thread2 = new Thread(mt,"B");
        thread1.start();
        thread2.start();
    }
}


































