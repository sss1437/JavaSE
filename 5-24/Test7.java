package Test;


/**
 * @Author: zhaodoudou
 * @Date: 2019/5/25
 * @Description: Test
 * @Version: 1.0
 */
//数组中的逆序对

/**
 * 分治思想，采用归并排序的思路来处理，如下图，先分后治：先把数组分隔成子数组，先统计出子数组内
 * 部的逆序对的数目，然后再统计出两个相邻子数组之间的逆序对的数目。在统计逆序对的过程中，还需要对数组进
 * 行排序，其实这个排序过程就是归并排序的思路 .
 * 逆序对的总数=左边数组中的逆序对的数量+右边数组中逆序对的数量+左右结合成新的顺序数组时中出现的逆序对
 * 的数量；
 */
class AntiOrder {
    public int count(int[] A, int n) {
        if(A == null||n == 0){
            return 0;
        }
        return mergeSortRecursion(A,0,n - 1);

    }
    public int mergeSortRecursion(int[] arr,int l,int r){
        if (l == r){
            return 0;
        }
        int mid = (r+l)/2;
        //逆序对的总数=左边数组中的逆序对的数量+右边数组中逆序对的数量+
        // 左右结合成新的顺序数组时中出现的逆序对的数量
        return mergeSortRecursion(arr,l,mid)+mergeSortRecursion(arr,mid+1,r)+
                merge(arr,l,mid,r);
    }
    public int merge(int[] arr,int left,int mid,int right){
        int[] temp = new int[right-left+1];
        int index = 0;
        int i = left;
        int j = mid+1;
        int inverseNum = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[index++] = arr[i++];
            } else {
                inverseNum += (mid - i + 1);
                temp[index++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= right) {
            temp[index++] = arr[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            arr[left++] = temp[k];
        }
        return inverseNum;
    }
}


public class Test7 {
    public static void main(String[] args){

    }
}
