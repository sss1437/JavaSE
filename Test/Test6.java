package Test;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/23
 * @Description: Test
 * @Version: 1.0
 */

import java.util.Stack;

/**
 * 在常数时间内找栈内最小元素（单栈解答）
 */
class MinStack {
    private Stack<Integer> dataStack;

    /** initialize your data structure here. */
    public MinStack() {
        dataStack = new Stack<>();

    }

    public void push(int x) {

        if (dataStack.isEmpty()){
            dataStack.push(x);
            dataStack.push(x);
        }else {
            int temp = dataStack.peek();
            if (temp < x) {
                dataStack.push(x);
                dataStack.push(temp);
            } else {
                dataStack.push(x);
                dataStack.push(x);
            }
        }

    }

    public void pop() {
        if (dataStack.isEmpty()){
            System.out.println("栈为空");
        }else {
            dataStack.pop();
            dataStack.pop();
        }
    }

    public int top() {
        int temp = dataStack.peek();
        dataStack.pop();
        int result = dataStack.peek();
        dataStack.push(temp);
        return result;


    }

    public int getMin() {
        return dataStack.peek();

    }
}

public class Test6{
    public static void main(String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
    }
}