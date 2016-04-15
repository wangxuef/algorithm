package lintcode.array.easy;

// Median
/**
 * 中位数
 * 给定一个未排序的整数数组，找到其中位数。
 * ---中位数是排序后数组的中间值，如果数组的个数是偶数个，则返回排序后数组的第N/2个数
 */
public class Solution80 {
    public int median(int[] nums) {
        return sub(nums, 0, nums.length - 1, (nums.length + 1)/2);
    }
    
    // 
    private int sub(int[] nums, int start, int end, int size) {	//size 为索引，是从1开始数的
    	
        int mid = (start + end) / 2;
        int pivot = nums[mid];
        int i = start - 1, j = end + 1;
       
        for (int k = start; k < j; k++) {
            if (nums[k] < pivot) {
                i++;
                int tmp = nums[i];// 交换nums[i] 和 nums[k]，小于pivot的数都在左边
                nums[i] = nums[k];
                nums[k] = tmp;
            } else if (nums[k] > pivot) {
                j--;
                int tmp = nums[j];// 交换nums[j] 和 nums[k] ,把大于pivot的数换到右边
                nums[j] = nums[k];
                nums[k] = tmp;
                k--;	// 原k处换来了新的数，再比较
            }
        }
        
        if (i - start + 1 >= size) {	// size 在上一次排序后的i的位置右边
            return sub(nums, start, i, size);   // 以i为end，重新排序
        } else if (j - start >= size) {	// size 在上一次排序后的i的位置左边， j的位置左边
            return nums[j-1];
        } else { // j<size<i
            return sub(nums, j, end, size - (j - start));
        }
    }
}
