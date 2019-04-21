package pc;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: zhaodoudou
 * @Date: 2019/4/21
 * @Description: pc
 * @Version: 1.0
 */
public class Producer implements Runnable {
    //因为容器是生产者和消费者共有的，因此要将商品传入消费者类中，不能直接new
    private final Queue<Goods> goodsQueue;
    //商品最大容量
    private final Integer maxGoods;
    //商品Id
    private final AtomicInteger goodsId = new AtomicInteger(0);
    public Producer(Queue<Goods> goodsQueue, Integer maxGoods) {
        this.goodsQueue = goodsQueue;
        this.maxGoods = maxGoods;
    }

    @Override
    public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //锁必须放在while循环内，不然会出现生产到最大值才会消费，消费空了才开始生产
                synchronized (this.goodsQueue) {
                    if (this.goodsQueue.size() >= this.maxGoods) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "商品队列已满 等待消费");
                            this.goodsQueue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        //Math.random():价格
                        //goodsId.getAndDecrement()：原子减1当前值
                        Goods goods = new Goods("商品-" + goodsId.getAndDecrement(), Math.random());
                        this.goodsQueue.add(goods);
                        System.out.println(Thread.currentThread().getName() +
                                "商品队列未满 生产商品" + goods);
                    }
            }
        }

    }
}
