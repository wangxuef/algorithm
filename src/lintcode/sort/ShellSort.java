package lintcode.sort;

import java.util.Arrays;

// http://www.cnblogs.com/skywang12345/p/3597597.html

/**
 * 希尔排序(Shell Sort)是插入排序的一种，它是针对直接插入排序算法的改进。该方法又称缩小增量排序。
 * 希尔排序实质上是一种分组插入方法。它的基本思想是：
 * 对于n个待排序的数列，取一个小于n的整数gap(gap被称为步长)将待排序元素分成若干个组子序列，
 * 所有距离为gap的倍数的记录放在同一个组中；然后，对各组内的元素进行直接插入排序。
 * 这一趟排序完成之后，每一个组的元素都是有序的。然后减小gap的值，并重复执行上述的分组和排序。
 * 重复这样的操作，当gap=1时，整个数列就是有序的。
 * 
 * 希尔排序的时间复杂度与增量(即，步长gap)的选取有关。
 * 例如，当增量为1时，希尔排序退化成了直接插入排序，此时的时间复杂度为O(N²)，
 * 而Hibbard增量的希尔排序的时间复杂度为O(N3/2)
 * 
 * 希尔排序是不稳定的算法.
 * @author wxf
 */
public class ShellSort {
    
    public static void shellSort(int[] a){
        int len = a.length;
        
        // gap为步长，每次减为原来的一半。
        for(int gap=len/2; gap>0; gap /= 2){
            // 共gap个组，对每一组都执行直接插入排序
            for(int i=0; i<gap; i++){
                for(int j=i+gap; j<len; j+=gap){
                    // 如果a[j] < a[j-gap]，则寻找a[j]位置，并将后面数据的位置都后移。
                    if(a[j] < a[j-gap]){
                        int tmp = a[j];
                        int k=j-gap;
                        while(k>=0 && a[k]>tmp){
                            a[k+gap] = a[k];
                            k -= gap;
                        }
                        a[k + gap] = tmp;
                    }
                }
            }
        }
    }
    
    
    public static void main(String[] args) {
        int[] a = {20,40,30,10,60,50};
        shellSort(a);
        System.out.println(Arrays.toString(a));
    }
}
