package Day2;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/25
 * @Description: Day2
 * @Version: 1.0
 */
//括号匹配
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s == null){
            return false;
        }
        for (int i = 0;i < s.length(); i++){
            char temp = s.charAt(i);
            if (stack.empty()){
                stack.push(temp);
            }else {
                char t = stack.peek();
                stack.push(temp);
                if (t =='(' && temp == ')'||t=='{' && temp == '}'||
                        t =='[' && temp == ']'){
                    stack.pop();
                    stack.pop();
                }
            }
        }
        if (stack.empty()){
            return true;
        }
        return false;
    }
}
public class Test3 {
    public static void main(String[] args){
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNext()){
            String str = scanner.nextLine();
            System.out.println(solution.isValid(str));
        }
    }
}
