package lintcode.array.easy;

import java.util.Arrays;

// Merge Sorted Array 
// Given two sorted integer arrays A and B, merge B into A as one sorted array.
// 合并排序数组 ,A有足够空间
public class Solution64 {
    public static void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int i = m-1, j = n-1, index = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[index--] = A[i--];
            } else {    
                A[index--] = B[j--];
            }
        }
        while (i >= 0) {
            A[index--] = A[i--];
        }
        while (j >= 0) {
            A[index--] = B[j--];
        }
    }
    
    public static void main(String[] args) {
        int[] a = new int[10];
        a[0] = 1;
        a[1] = 3;
        a[2] = 6;
        int m = 3;
        int[] b = {2,4};
        int n = 2;
        mergeSortedArray(a, m, b, n);
        System.out.println(Arrays.toString(a));
    }
    
}