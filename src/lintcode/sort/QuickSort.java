package lintcode.sort;

// http://www.cnblogs.com/skywang12345/p/3596746.html
import java.util.Arrays;

/**
 * 快速排序(Quick Sort)使用分治法策略。
 * 
 * 它的基本思想是：选择一个基准数，通过一趟排序将要排序的数据分割成独立的两部分；
 * 其中一部分的所有数据都比另外一部分的所有数据都要小。然后，再按此方法对这两部分数据分别进行快速排序，
 * 整个排序过程可以递归进行，以此达到整个数据变成有序序列。
 * 
 * 快速排序是不稳定的算法
 * 
 * 快速排序的时间复杂度在最坏情况下是O(N2)，平均的时间复杂度是O(N*lgN)。
 * @author wxf
 */
public class QuickSort {
    
    public static void quickSort(int[] arr, int left, int right){
        if(left<right){
            int i, j, x;
            i = left;
            j = right;
            x = arr[i]; //
            
            while(i<j){
                while(i<j && arr[j]>x){ //
                    j--; // 从右向左找第一个小于x的数
                }
                if(i<j){
                    arr[i++] = arr[j];
                }
                while(i<j && arr[i]<x){
                    i++; // 从左向右找第一个大于x的数
                }
                if(i<j){
                    arr[j--] = arr[i];
                }       
            }
            
            arr[i] = x;
            quickSort(arr, left, i-1);
            quickSort(arr, i+1, right);
        }
    }
    
    public static void main(String[] args) {
        int[] a = {20,40,30,10,60,50};
        quickSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
