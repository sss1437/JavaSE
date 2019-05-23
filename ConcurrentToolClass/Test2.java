package ConcurrentToolClass;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/21
 * @Description: ConcurrentToolClass
 * @Version: 1.0
 */
class Finder {
    public int findKth(int[] a, int n, int K) {
        return findKth(a, 0, n-1, K);
    }
    private int findKth(int[] a,int p,int n,int k){
        int q = partition(a,p,n);
        if(k==q-p+1){
            return a[q];
        }else if (k<q-p+1){
            return findKth( a,p,q-1,k);
        }else {
            return findKth(a,q+1,n,k-q+p-1);
        }
    }
    private int partition(int[] array, int l, int r){
        int v = array[l];
        //array[l+1...j]
        int j = l;
        //array[j+1...i-1]
        int i = l+1;
        for(;i <= r;i++){
            if(array[i] < v){
                swap(array,j+1,i);
                j++;
            }
        }
        swap(array,l,j);
        return j;
    }
    private void swap(int[] array,int x,int y){
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}