package www;

/**
 * @Author: zhaodoudou
 * @Date: 2019/3/10
 * @Description: www
 * @Version: 1.0
 */
public class TestSort {
    public static void main(String[] args) {
        int[] array = new int[]{8, 3, 7, 2, 6, 4};
        quicklySortInternal3(array,0,5);
        Test(array);
    }

    //归并排序
    //时间复杂度 :o(nlogn)
    //空间复杂度 :o(n)
    //稳定性：稳定性排序
    public static void mergeSortInter(int[] array, int p, int r) {
        if (r <= p) {
            return;
        } else {
            int mid = (p + r) / 2;
            mergeSortInter(array, p, mid);
            mergeSortInter(array, mid + 1, r);
            merge(array, p, mid, r);
        }
    }

    private static void merge(int array[], int p, int mid, int r) {
        int i = p;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[r - p + 1];
        if (j > r) {
            return;
        } else {
            //同时结束
            while (i <= mid && j <= r) {
                if (array[i] <= array[j]) {
                    temp[k++] = array[i++];
                } else {
                    temp[k++] = array[j++];
                }
            }
            //第一个数组没有走完
            int start = i;
            int end = mid;
            //第二个数组没有走完
            if (j <= r) {
                start = j;
                end = r;
            }
            //将未走完的数组放入temp中
            while (start <= end) {
                temp[k++] = array[start++];
            }
            //将temp中的数组拷贝到arrays中
            for (int s = 0; s <= r - p; s++) {
                array[s + p] = temp[s];
            }
        }
    }

    //选择排序
    //时间复杂度 :o(n^2)
    //空间复杂度 :o(1)
    //稳定性：不稳定性排序
    public static void selectionSort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        } else {
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (array[j] < array[minIndex]) {
                        minIndex = j;
                    }
                }
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }
        }
    }

    //希尔排序
    //时间复杂度 :o(n^2)
    //空间复杂度 :o(1)
    //稳定性：不稳定性排序
    public static void shellSort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        } else {
            int step = n / 2;
            while (step >= 1) {
                for (int i = step; i < n; i++) {
                    int j = i - step;
                    int value = array[i];
                    for (; j >= 0; j -= step) {
                        if (array[j] > value) {
                            array[j + step] = array[j];
                        } else {
                            break;
                        }
                    }
                    //出第二层for循环后j=0，变成j-step
                    array[j + step] = value;
                }
                step /= 2;
            }
        }
    }

    //冒泡法排序
    //时间复杂度:o(n^2)
    //空间复杂度:o(1)
    //稳定性：稳定性排序
    public static void bubbleSort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
        Test(array);
    }

    //插入排序
    //时间复杂度 :o(n^2)
    //空间复杂度 :o(1)
    //稳定性：稳定性排序
    public static void insertSort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        } else {
            for (int i = 1; i < n; i++) {
                int j = i - 1;
                int value = array[i];
                for (; j >= 0; j--) {
                    if (array[j] > value) {
                        array[j + 1] = array[j];
                    } else {
                        break;
                    }
                }
                array[j + 1] = value;
            }
        }
    }

    public static void Test(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    //折半插入排序 :
    //时间复杂度 :o(n^2)
    //空间复杂度 :o(1)
    //稳定性：稳定性排序
    public static void binaryInsertSort(int[] array) {
        int n = array.length;
        if (n <= 1) {
            return;
        } else {
            for (int i = 1; i < n; i++) {
                int low = 0;
                int high = i - 1;
                int value = array[i];
                int j = i - 1;
                while (high >= low) {
                    int mid = (high - low) / 2 + low;
                    if (value > array[mid]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                for (; j >= high + 1; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = value;
            }
        }
    }
    //快速排序
    //时间复杂度 :o(nlogn)
    //空间复杂度 :o(1)
    //稳定性：不稳定性排序（若基准值为最后一个元素（5.4.3.2.5））
    public static void quicklySortInternal(int[] array,int l,int r){
        if(l >= r){
            return;
        }
        int q = partition(array,l,r);
        quicklySortInternal(array,l,q-1);
        quicklySortInternal(array,q+1,r);
    }
    private static int partition(int[] array,int l,int r){
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
    //二路快排
    private static int partition2(int[] array,int l,int r){
        int randomIndex = (int) (Math.random()*(r-l+1)+l);
        swap(array,l,randomIndex);
        int v = array[l];
        //array[l+1...i-1]
        int i = l+1;
        //array[j+1...r]
        int j = r;
        while(true){
            while(array[i] < v && i <= r){i++;}
            while(array[j] > v && j >= l+1){j--;}
            if(i > j){
                break;
            }
            swap(array,i,j);
            i++;
            j--;
        }
        swap(array,j,l);
        return j;
    }
    //三路快排
    public static void quicklySortInternal3(int[] array,int l,int r){
        if(l >= r){
            return ;
        }
        int randomIndex = (int)(Math.random()*(r-l+1)+l);
        swap(array,l,randomIndex);
        int v = array[l];
        //array[l+1...lt]<v
        int lt = l;
        //array[lt+1...i-1]=v
        int i = l+1;
        //array[gt..r]>v
        int gt = r+1;
        while(i < gt) {
            if (array[i] < v) {
                swap(array, lt + 1, i);
                lt++;
                i++;
            } else if (array[i] > v){
                swap(array, gt-1, i);
                gt--;
            }else{
                i++;
            }
        }
        swap(array,lt,l);
        quicklySortInternal3(array,l,lt-1);
        quicklySortInternal3(array,gt,r);
    }
    private static void swap(int[] array,int l,int r){
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }
}


