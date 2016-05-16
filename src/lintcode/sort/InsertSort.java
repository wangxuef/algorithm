package lintcode.sort;

import java.util.Arrays;

/**
 * 直接插入排序(Straight Insertion Sort)的基本思想是：
 * 把n个待排序的元素看成为一个有序表和一个无序表。开始时有序表中只包含1个元素，无序表中包含有n-1个元素，
 * 排序过程中每次从无序表中取出第一个元素，将它插入到有序表中的适当位置，使之成为新的有序表，重复n-1次可完成排序过程。
 * 
 * 直接插入排序是稳定的算法
 * 
 * 直接插入排序的时间复杂度是O(N2)。
 * @author wxf
 */
public class InsertSort {

    public static void insertSort(int[] arr) {
        int len = arr.length;
        int i, j, k;
        for(i=1; i<len; i++){
            //为a[i]在前面的a[0...i-1]有序区间中找一个合适的位置
            for(j=i-1; j>=0; j--){
                if(arr[j] < arr[i]){
                    break;
                }
            }
            
            //如找到了一个合适的位置
            if(j!=i-1){
                int tmp = arr[i];
                for(k=i-1; k>j; k--){
                    arr[k+1] = arr[k]; //将比a[i]大的数据向后移
                }
                arr[k+1] = tmp; //将a[i]放到正确位置上
            }
        }
    }
    
    public static void main(String[] args) {
        int[] a = {20,40,30,10,60,50};
        insertSort(a);
        System.out.println(Arrays.toString(a));
    }
}
