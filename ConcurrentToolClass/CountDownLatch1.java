package ConcurrentToolClass;

import java.sql.Time;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/20
 * @Description: ConcurrentToolClass
 * @Version: 1.0
 */
class Task implements Runnable{
    private CountDownLatch countDownLatch;

    public Task(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"已经到达！");
        countDownLatch.countDown();

    }
}
//闭锁：实现类似计数器功能
public class CountDownLatch1 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        System.out.println("比赛开始");
        new Thread(new Task(countDownLatch),"运动员A").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new Task(countDownLatch),"运动员B").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new Task(countDownLatch),"运动员C").start();
        countDownLatch.await();
        System.out.println("比赛结束");
    }
}
