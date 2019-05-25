package Day2;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/25
 * @Description: Day2
 * @Version: 1.0
 */
class MyCircularQueue {
    private int[] elementData;
    private int head;
    private int tail;
    private int k;
    private int headData;
    private int tailData;
    /** 构造器，设置队列长度为 k  */
    public MyCircularQueue(int k) {
        this.k = k;
        elementData = new int[k+1];
    }

    /** 向循环队列插入一个元素。如果成功插入则返回真。 */
    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }else {
            elementData[tail] = value;
            tailData = elementData[tail];
            tail = (tail+1)%elementData.length;
            return true;
        }
    }

    /**  从循环队列中删除一个元素。如果成功删除则返回真。 */
    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }else {
            headData = elementData[head];
            elementData[head] = 0;
            head = (head+1)%elementData.length;
            return true;
        }
    }
    public void data(){
        for (int i = 0;i < tail-head;i++){
            System.out.print(elementData[i]+" ");
        }
    }

    //* 从队首获取元素。如果队列为空，返回 -1 。 /
    public int Front() {
        if (isEmpty()){
            return -1;
        }
        headData = elementData[head];
        return headData;
    }

   // *  获取队尾元素。如果队列为空，返回 -1 。
    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        return tailData;
    }

    /** 检查循环队列是否为空。 */
    public boolean isEmpty() {
        if (tail == head){
            return true;
        }
        return false;
    }

    /** 检查循环队列是否已满。*/
    public boolean isFull() {
        if ((tail+1)%elementData.length == head){
            return true;
        }
        return false;
    }
}

public class Test5 {
    public static void main(String[] args){
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.Front());
    }
}
