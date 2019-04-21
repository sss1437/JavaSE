package pc;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zhaodoudou
 * @Date: 2019/4/21
 * @Description: pc
 * @Version: 1.0
 */

//1.生产者消费者 单线程 并且无时间间隔
//2.模拟现实 速率问题
//单线程消费者
public class Test {
    public static void main(String[] args) {
        //商品容器
        final Queue<Goods> queue = new LinkedList<>();
        final Integer maxGoods = 10;
        //生产者
        final Producer producer = new Producer(queue, maxGoods);
        //消费者
        final Consumer consumer = new Consumer(queue);

        Thread producerThread1 = new Thread(producer, "生产者-1");
        Thread consumerThread1 = new Thread(consumer, "消费者-1");
        producerThread1.start();
        consumerThread1.start();
    }

}
