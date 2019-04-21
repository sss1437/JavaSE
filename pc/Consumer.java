package pc;

import java.util.Queue;

/**
 * @Author: zhaodoudou
 * @Date: 2019/4/21
 * @Description: pc
 * @Version: 1.0
 */
public class Consumer implements Runnable {
    private final Queue<Goods> goodsQueue;

    public Consumer(Queue<Goods> goodsQueue) {
        this.goodsQueue = goodsQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.goodsQueue){
                //isEmpty():如果此集合不包含元素，则返回 true 。
                if (this.goodsQueue.isEmpty()){
                    System.out.println(Thread.currentThread().getName()+"商品队列已空 通知生产");
                    this.goodsQueue.notifyAll();
                }else {
                    //poll()：检索并删除此队列的头，如果此队列为空，则返回 null 。
                    Goods goods = this.goodsQueue.poll();
                    if (goods != null){
                        System.out.println(Thread.currentThread().getName()+
                                "商品队列有货 消费商品"+goods);
                    }
                }
            }
        }
    }
}
