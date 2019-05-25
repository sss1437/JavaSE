package Day2;

import java.util.Arrays;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/25
 * @Description: Day2
 * @Version: 1.0
 */
//数组实现队列(搬移实现队列扩容)
interface Queue<E>{
    /**
     * 元素入队列
     * @param e 要插入的元素
     */
    void enqueue(E e);

    /**
     * 返回队首元素并出队
     * @throws NullPointerException 队列为空
     * @return 队首元素
     */
    E dequeue();

    /**
     * 返回队首元素但不出对列
     * @throws NullPointerException 队列为空
     * @return 队首元素
     */
    E peek();

    int getSize();
    boolean isEmpty();
}
class ArrayQueue<T> implements Queue<T>{
    //存放具体数据
    private T[] elementData;
    //队列头
    private int head;
    //队列尾部
    private int tail;
    //数组容量
    private int capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        elementData =(T[]) new Object[capacity];
    }

    //元素入队
    @Override
    public void enqueue(T t) {
        if (tail == capacity){
            if (head == 0){
                System.out.println("队列已满");
            }else {
                for (int i = head;i < tail; i++){
                    elementData[i-head] = elementData[i];
                }
                tail-=head;
                head = 0;
            }
        }else {
            elementData[tail++]  = t;
        }
    }

    //元素出队
    @Override
    public T dequeue() {
        if (head == tail){
            throw new NullPointerException("队列为空");
        }
        T result = elementData[head++];
        return result;
    }

    @Override
    public T peek() {
        if (head == tail){
            throw new NullPointerException("队列为空");
        }
        T result = elementData[head];
        return result;
    }

    @Override
    public int getSize() {
        return tail - head;
    }

    @Override
    public boolean isEmpty() {
        if (getSize()==0){
            return true;
        }
        return false ;
    }
}
public class Test4 {
    public static void main(String[] args){
        Queue<Integer> arrayQueue = new ArrayQueue<>(3);
        arrayQueue.enqueue(1);
        arrayQueue.enqueue(2);
        arrayQueue.enqueue(4);
        arrayQueue.enqueue(4);
        System.out.println(arrayQueue.getSize());
        System.out.println(arrayQueue.peek());
        System.out.println(arrayQueue.dequeue());
        System.out.println(arrayQueue.dequeue());
    }
}
