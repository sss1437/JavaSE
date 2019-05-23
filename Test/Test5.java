package Test;

import java.util.Stack;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/22
 * @Description: Test
 * @Version: 1.0
 */

/**
 * 在常数时间内找栈内最小元素（双栈解答）
 */

class MinStack1 {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack1() {
        dataStack = new Stack<>();
        minStack = new Stack<>();

    }

    public void push(int x) {
        if (dataStack.isEmpty()){
            dataStack.push(x);
            minStack.push(x);
        }else if (minStack.peek() < x){
            dataStack.push(x);

        }else {
            dataStack.push(x);
            minStack.push(x);
        }

    }

    public void pop() {
        if (dataStack.isEmpty()){
            System.out.println("栈为空");
        }else if (dataStack.peek() <= minStack.peek()){
            dataStack.pop();
            minStack.pop();
        }else {
            dataStack.pop();
        }

    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();

    }
}


public class Test5 {
    public static void main(String[] args){
        MinStack1 minStack = new MinStack1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
    }
}
