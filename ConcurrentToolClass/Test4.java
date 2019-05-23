package ConcurrentToolClass;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/22
 * @Description: ConcurrentToolClass
 * @Version: 1.0
 */
class AntiOrder {
    public int count(int[] A, int n) {
        int count = 0;
        for (int i = 0;i < n; i++){
            for (int j = i+1;j < n; j++){
                if (A[i] > A[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
public class Test4 {
    public static void main(String[] args){
        AntiOrder antiOrder = new AntiOrder();
        int[] A = {1,7,3,0};
        System.out.println(antiOrder.count(A,4));
    }
}
