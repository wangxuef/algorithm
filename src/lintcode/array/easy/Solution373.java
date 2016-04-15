package lintcode.array.easy;

import java.util.Arrays;

// Partition an integers array into odd number first and even number second.
// 奇偶分割数组

public class Solution373 {
    public static void partitionArray(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            while(nums[left]%2==1 && left<right){//从左边找偶数
                left++;
            }
            while(nums[right]%2==0 && left<right){//从右边找奇数
                right--;
            }
            if(left<right){// 交换
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7 };
        partitionArray(a);
        System.out.println(Arrays.toString(a));

    }
}
