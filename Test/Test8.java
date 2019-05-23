package Test;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/23
 * @Description: Test
 * @Version: 1.0
 */

import java.util.Stack;

/**
 * 给定字符串A和他的长度n，返回一个bool值判断是否为一个合法的括号串
 */
 class Parenthesis {

    public boolean chkParenthesis(String A, int n) {
        Stack<Character> stringStack = new Stack<>();
        if (A == null || A.length() != n) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            char a = A.charAt(i);
            if (a == '(') {
                stringStack.push(a);
            } else if (a == ')') {
                if (stringStack.empty()) {
                    return false;
                } else {
                    stringStack.pop();
                }
            } else {
                return false;
            }
        }
        if (!stringStack.empty()) {
            return false;
        } else {
            return true;
        }
    }

}

public  class Test8 {
    public static void main(String[] args){
        Parenthesis parenthesis = new Parenthesis();
         boolean x =parenthesis.chkParenthesis("((()))",6);
        System.out.println(x);
    }
}
