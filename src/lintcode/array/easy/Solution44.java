package lintcode.array.easy;

import java.util.ArrayList;

// Minimum Subarray
// 最小子数组
/**
 * Given an array of integers, find the subarray with smallest sum.
 * Return the sum of the subarray.
 * 
 */
public class Solution44 {
    public int minSubArray(ArrayList<Integer> nums) {
        if (nums == null)
            return 0;
        int len = nums.size();
        int[] localmin  = new int[len];
        int[] globalmin = new int[len];
        for (int i = 0; i < len; i++) {
            if( i ==0 )
                globalmin[i] = localmin[i] = nums.get(i);
            else {
                localmin[i] = Math.min(localmin[i - 1] + nums.get(i), nums.get(i));
                globalmin[i] = Math.min(globalmin[i - 1], localmin[i]);
            }
            
        }
        return globalmin[len-1];
    }
    
    // 动态规划
    public int minSubArray2(ArrayList<Integer> nums) {
        int min_ending_here = nums.get(0);
        int min_so_far = nums.get(0);
        for (int i=1 ;i< nums.size(); i++){
            min_ending_here = Math.min(nums.get(i),nums.get(i) + min_ending_here);
            min_so_far = Math.min( min_so_far, min_ending_here );
        }
        return min_so_far;
    }
    
    // 定义一个数组dp[i] ，表示当前i位置时候的最小子数组的值，最后再变量找出dp的最小值就是答案
    public int minSubArray3(ArrayList<Integer> nums) {
        if( nums == null)
            return 0;
        int n = nums.size();
        int dp[] = new int[n];
        dp[0] = nums.get(0);
        for(int i=1;i<n;i++){
            int tmp = dp[i-1] + nums.get(i);
            if(tmp > nums.get(i))
                dp[i] = nums.get(i);
            else 
                dp[i] = tmp;
        }
        int minSum = Integer.MAX_VALUE;
        for(int i =0;i< n;i++){
            if(dp[i] < minSum)
                minSum = dp[i];
        }
        return minSum;
    }
    
}
