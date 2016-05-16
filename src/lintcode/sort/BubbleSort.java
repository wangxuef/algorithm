package lintcode.sort;

import java.util.Arrays;

/**
 * 冒泡排序的时间复杂度是O(N2)
 * 
 * 冒泡排序是稳定的算法
 * 
 * 算法稳定性 -- 假设在数列中存在a[i]=a[j]，若在排序之前，a[i]在a[j]前面；
 * 并且排序之后，a[i]仍然在a[j]前面。则这个排序算法是稳定的！
 * @author wxf
 */
public class BubbleSort {
    public static void bubbleSort1(int[] a){
        int len = a.length;
        for(int i=len-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                }
            }
        }
    }
    
    /*
     * 改进版
     */
    public static void bubbleSort2(int[] a){
        int len = a.length;
        boolean flag;
        for(int i=len-1; i>0; i--){
            flag = false;
            for(int j=0; j<i; j++){
                if(a[j] > a[j+1]){
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;
                }
            }
            if(!flag){
                break;
            }
        }
    }
    
    
    public static void main(String[] args) {
        int[] a = {20,40,30,10,60,50};
        bubbleSort1(a);
        System.out.println(Arrays.toString(a));
    }
}
