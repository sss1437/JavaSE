package Test;

import java.util.Arrays;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/23
 * @Description: Test
 * @Version: 1.0
 */
interface Stack{
    void push(Object data);
    Object pop();
    Object peek();
    int getSize();
    boolean isEmpty();
}
class ArrayStack implements Stack{
    private String[] arrays;
    private int count;
    private int n;

    ArrayStack(int n){
        this.arrays = new String[n];
        this.count = 0;
        this.n = n;
    }
    @Override
    public void push(Object array) {
        if (count == n){
            int oldCount = n;
            int newCount = oldCount<<1;
            if ((newCount+8)-Integer.MAX_VALUE > 0){
                return;
            }
            n = newCount;
            arrays = Arrays.copyOf(arrays,newCount);
        }else {
            arrays[count] = (String) array;
            ++count;
        }
    }
    @Override
    public Object pop() {
        if (count == 0){
            return null;
        }else {
            String  temp = arrays[count-1];
            --count;
            return temp;
        }
    }

    @Override
    public Object peek() {
        if (count==0){
            return null;
        }
        return arrays[count];
    }

    @Override
    public int getSize() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        if (count == 0){
            return true;
        }
        return false;
    }
}

public class Test9 {
    public static void main(String[] args){
        Stack arrayStack  = new ArrayStack(1);
        arrayStack.push("h");
        arrayStack.push("e");
        arrayStack.push("l");
        System.out.println(arrayStack.isEmpty());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.peek());
        System.out.println(arrayStack.getSize());
    }
}
