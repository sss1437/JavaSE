package day14;




/**
 * @Author: zhaodoudou
 * @Date: 2019/6/7
 * @Description: day14
 * @Version: 1.0
 */

/*class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
class Solution {
    public void Mirror(TreeNode root) {
        TreeNode tempNode = null;
       if (root==null){
           return;
       }else {
           Mirror(root.left);
           Mirror(root.right);
           tempNode = root.left;
           root.left = root.right;
           root.right = tempNode;
       }
    }
}*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test7 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < N;i++ ){
            list.add(scanner.nextInt());
        }

    }

}
