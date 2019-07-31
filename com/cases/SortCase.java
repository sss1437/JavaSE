package com.cases;

import com.Case;
import com.annotations.Benchmark;
import com.annotations.Measurement;
import com.annotations.WarmUp;

import java.util.Arrays;
import java.util.Random;

/**
 * @Description:
 * @Author: zdd
 * @Date: 2019/7/31
 */

/**
 * 1.快速排序和归并排序的差别
 * 2.自己实现的归并排序h和Arrays.sort对比
 */
@Measurement(iterations = 10,group = 3)
public class SortCase implements Case {
    /**
     * 归并排序
     * @param array
     * @param p
     * @param r
     */
    public  void mergeSortInter(int[] array, int p, int r) {
        if (r <= p) {
            return;
        } else {
            int mid = (p + r) / 2;
            mergeSortInter(array, p, mid);
            mergeSortInter(array, mid + 1, r);
            merge(array, p, mid, r);
        }
    }

    private void merge(int array[], int p, int mid, int r) {
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

    /**
     * 三路快排
     * @param array
     * @param l
     * @param r
     */
    public void quicklySortInternal3(int[] array,int l,int r){
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
    private void swap(int[] array,int l,int r){
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }

    @Benchmark
    public void testQuickSort(){
        int [] a = new int[10000];
        Random random = new Random(20190713);
        for (int i = 0;i < a.length; i++){
            a[i] = random.nextInt(10000);
        }
        quicklySortInternal3(a,0,a.length-1);
    }
    @Benchmark
    public void testMergeSort(){
        int [] a = new int[10000];
        Random random = new Random(20190713);
        for (int i = 0;i < a.length; i++){
            a[i] = random.nextInt(10000);
        }
        mergeSortInter(a,0,a.length-1);
    }
    @Benchmark
    public void testArraysSort(){
        int [] a = new int[10000];
        Random random = new Random(20190713);
        for (int i = 0;i < a.length; i++){
            a[i] = random.nextInt(10000);
        }
        Arrays.sort(a);
    }
}
