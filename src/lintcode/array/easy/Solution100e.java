package lintcode.array.easy;

// Remove Duplicates from Sorted Array
// 删除排序数组中的重复数字 
// 只要求返回 数组的长度！！！

public class Solution100e {
    public static int removeDuplicates(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int size = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != A[size]) {
                A[++size] = A[i];
            }
        }
        return size + 1;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 2, 2, 3, 4 };
        System.out.println(removeDuplicates(A));
    }

}
