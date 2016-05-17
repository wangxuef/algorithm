package lintcode.sort;

import java.util.Arrays;

/**
 * 堆排序
 * @author wxf
 */
public class HeapSort {
    
    /**
     * 最大堆的向下调整算法
     * @param a
     * @param start
     * @param end
     */
    public static void maxHeapDown(int[] a, int start, int end){
        int c = start; // 当前(current)节点的位置
        int l = 2 * c + 1; // 左(left)孩子的位置
        int tmp = a[c]; // 当前(current)节点的大小
        
        for (; l <= end; c = l, l = 2 * l + 1) {
            // "l"是左孩子，"l+1"是右孩子
            if (l < end && a[l] < a[l + 1])
                l++; // 左右两孩子中选择较大者，即m_heap[l+1]
            if (tmp >= a[l])
                break; // 调整结束
            else { // 交换值
                a[c] = a[l];
                a[l] = tmp;
            }
        }
    }
    
    /**
     * 堆排序(从小到大)
     * @param a
     * @param n
     */
    public static void heapSortAsc(int[] a, int n){
        int i, tmp;

        // 从(n/2-1) --> 0逐次遍历。遍历之后，得到的数组实际上是一个(最大)二叉堆。
        for (i = n / 2 - 1; i >= 0; i--){
            maxHeapDown(a, i, n - 1);
        }

        // 从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
        for (i = n - 1; i > 0; i--) {
            // 交换a[0]和a[i]。交换后，a[i]是a[0...i]中最大的。
            tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            // 调整a[0...i-1]，使得a[0...i-1]仍然是一个最大堆。
            // 即，保证a[i-1]是a[0...i-1]中的最大值。
            maxHeapDown(a, 0, i - 1);
        }
    }
    
    //TODO
    //(最小)堆的向下调整算法
    //堆排序(从大到小)
    
    public static void main(String[] args) {
        int a[] = {20,30,90,40,70,110,60,10,100,50,80};
        heapSortAsc(a, a.length);  
        System.out.println(Arrays.toString(a));
    }
}
