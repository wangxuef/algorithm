package lintcode.array.easy;

// 合并排序数组
/**
 * Merge two given sorted integer array A and B into a new sorted integer array.
 */
public class Solution6 {
    public static int[] mergeSortedArray(int[] A, int[] B) {
        int[] rst = new int[A.length + B.length];
        int i=0,j=0,k=0;
        while(i<A.length && j<B.length){
            if(A[i]<B[j]){
                rst[k++] = A[i++];
            }else {
                rst[k++] = B[j++];
            }
        }
        while(i<A.length){
            rst[k++] = A[i++];
        }
        while(j<B.length){
            rst[k++] = B[j++];
        }
        return rst;
    }
}
