package Test;

import java.util.Stack;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/24
 * @Description: Test
 * @Version: 1.0
 */
//用两个栈实现队列
class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int size;
    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
        this.size = 0;
    }
    public void push(int x) {
        stack1.push(x);
        size++;
    }
    public int pop() {
        int result = 0;
        if (size == 0){
            System.out.println("队列已空");
        }else {
            transfer1(stack1,stack2,size);
            result = stack2.peek();
            stack2.pop();
            size--;
            transfer2(stack1,stack2,size);
        }
        return result;
    }

    public int peek() {
        int peekResult = 0;
        if (empty()){
            System.out.println("队列为空");
            return -1;
        }else {
            transfer1(stack1,stack2,size);
            peekResult = stack2.peek();
            transfer2(stack1,stack2,size);
            return peekResult;
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (size == 0){
            return true;
        }
        return false;
    }
    private void transfer1(Stack<Integer> stack1,Stack<Integer> stack2,int size){
        for (int i = 0;i < size; i++){
            int temp = stack1.peek();
            stack1.pop();
            stack2.push(temp);
        }
    }
    private void transfer2(Stack<Integer> stack1,Stack<Integer> stack2,int size){
        for (int i = 0;i < size; i++){
            int temp = stack2.peek();
            stack2.pop();
            stack1.push(temp);
        }
    }
}
public class Test6 {
    public static void main(String[] args){
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        /*System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());*/

    }
}
