package lintcode.array.easy;

// Remove Duplicates from Sorted Array
// 删除排序数组中的重复数字 
// 只要求返回 数组的长度！！！

public class Solution100e {
    public static int removeDuplicates(int[] A) {
        int count = 0;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            if (count == 0 || A[i] != A[count - 1]) { // first or not dup
                A[count++] = A[i]; // copy and update count
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 2, 2, 3, 4 };
        System.out.println(removeDuplicates(A));
    }

}
