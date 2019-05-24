package Test;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/24
 * @Description: Test
 * @Version: 1.0
 */
import java.util.Stack;

/**
 * 两个栈实现队列
 */
class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    private int size;
    public void push(int node) {
        stack1.push(node);
        size++;
    }
    public int pop() {
        int result = 0;
        if (size == 0){
            System.out.println("队列已空");
        }else {
            for (int i = 0;i < size; i++){
                int temp = stack1.peek();
                stack1.pop();
                stack2.push(temp);
            }
            result = stack2.peek();
            stack2.pop();
            for (int j = 0;j < size-1;j++){
                int temp2 = stack2.peek();
                stack1.push(temp2);
                stack2.pop();
            }
            size--;
        }
        return result;
    }
}
public class Test5 {
    public static void main(String[] args){
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        System.out.println(solution.pop());
        solution.push(3);
        System.out.println(solution.pop());
        System.out.println(solution.pop());
        System.out.println(solution.pop());
    }
}
