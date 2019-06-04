package Test;

import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zhaodoudou
 * @Date: 2019/6/3
 * @Description: Test
 * @Version: 1.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
       if (p == null&&q == null){
           return true;
       }else {
           if (p != null && q != null && p.val == q.val){
               return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
           }
           return false;
       }
    }
}

public class Test12 {
    public static void main(String[] args){

    }
}
