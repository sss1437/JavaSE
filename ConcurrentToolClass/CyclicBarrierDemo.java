package ConcurrentToolClass;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/20
 * @Description: ConcurrentToolClass
 * @Version: 1.0
 */
class CyclicBarrierTask implements Runnable{
    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierTask(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在写入数据。。。");
        try {
            TimeUnit.SECONDS.sleep(2);
            System.out.println(Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入。。。");
            //子线程调用await（）方法后，将计数器值减一，并进入阻塞态，直到计数器减为0时，
            // 所有调用await（）阻塞的子线程再同时恢复执行
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("所有线程写入数据完毕。");

    }
}
public class CyclicBarrierDemo {
    public static void main(String[] args){
        //所有调用await（）阻塞的子线程在计数器值减为0后，随机挑选一个线程执行子任务后所有子线程恢复执行
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程为："+Thread.currentThread().getName());
            }
        });
        for (int i = 0;i < 4;i++){
            new Thread(new CyclicBarrierTask(cyclicBarrier)).start();
        }

    }
}
