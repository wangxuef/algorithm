package lintcode.sort;

import java.util.Arrays;

/**
 * 选择排序(Selection sort)的基本思想是：
 * 首先在未排序的数列中找到最小(or最大)元素，然后将其存放到数列的起始位置；
 * 接着，再从剩余未排序的元素中继续寻找最小(or最大)元素，然后放到已排序序列的末尾。
 * 以此类推，直到所有元素均排序完毕。
 * 
 * 选择排序是稳定的算法
 * 
 * 时间复杂度是O(N2)
 * @author wxf
 */
public class SelectSort {
    public static void selectSort(int[] a){
        int len = a.length;
        int i; // 有序区的末尾位置
        int j; // 无序区的起始位置
        int min; // 无序区中最小元素位置
        
        for(i=0; i<len; i++){
            min = i;
            for(j=i+1; j<len; j++){
                if(a[j]<a[min]){
                    min=j;
                }
            }
            
            if(min != i){
                int tmp = a[i];
                a[i] = a[min];
                a[min] = tmp;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] a = {20,40,30,10,60,50};
        selectSort(a);
        System.out.println(Arrays.toString(a));
    }
}
