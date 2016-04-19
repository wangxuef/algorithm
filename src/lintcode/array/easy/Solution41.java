package lintcode.array.easy;

// Maximum Subarray
// 最大子数组
/**
 * Given an array of integers, find a contiguous subarray which has the largest sum. 
 * Return the sum of the subarray. 
 * 给出数组[−2,2,−3,4,−1,2,1,−5,3]，符合要求的子数组为[4,−1,2,1]，其最大和为6
 * 
 */

// 记住 maxSubArray1、maxSubArray2
public class Solution41 {
    public static void main(String[] args) {
        int[] A = { -2, 2, -3, 4, -1, 2, 1, -5, 3 };
        int[] B = { -1, -2 };
        System.out.println(maxSubArray1(A));
    }
    
    // 暴力 O(n2)
    public static int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            int sum = 0; //必须定义在第一个for内部
            for(int j=i; j<nums.length; j++){
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
    
    // Greedy 贪婪算法!!  
    public static int maxSubArray1(int[] A) {
        if(A==null || A.length==0){
            return 0;
        }
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<A.length; i++){
            sum += A[i];
            maxSum = Math.max(maxSum, sum);
            sum = Math.max(sum, 0);//最关键 --sum 为负数时，令sum为0
        }
        return maxSum;
    }

    // 动态规划!!!
    // [−2,2,−3,4,−1,2,1,−5,3]
    public static int maxSubArray6(int[] nums) {
        int max_ending_here = nums[0]; //包括当前位置时候的最大值
        int max_so_far = nums[0]; // 最大值
        for (int i = 1; i < nums.length; i++) {
            max_ending_here = Math.max(nums[i], nums[i] + max_ending_here);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }

    // O(N)
    public static int maxSubArray5(int[] nums) {
        int maxsum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            maxsum = Math.max(maxsum, sum);
        }
        return maxsum;
    }

    // Prefix Sum (DP) 数组前缀和
    // [−2,2,−3,4,−1,2,1,−5,3]
    public int maxSubArray4(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return max;
    }

    public int maxSubArray3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] localmax = new int[len];
        int[] globalmax = new int[len];
        for (int i = 0; i < len; i++) {
            if (i == 0)
                globalmax[i] = localmax[i] = nums[0];
            else {
                localmax[i] = Math.max(localmax[i - 1] + nums[i], nums[i]);
                globalmax[i] = Math.max(globalmax[i - 1], localmax[i]);
            }
        }
        return globalmax[len - 1];
    }
    
}
