package lintcode.array.medium;

import java.util.ArrayList;

// 最长上升子序列，  可以有间隔
// 与最长上升连续子序列不同
/**
 * 给出[4,2,4,5,3,7]，这个LIS是[4,4,5,7]，返回 4
 */
public class Solution76m {
    /**
     * sublongest[i] 表示到i位置的最长升序子序列的长度。第i个元素的最长子序列长度是 sublongest[i]，
     * 则到达第 i + 1 个元素的最长子序列长度 sublongest[i+1]是 ：nums[j] <= nums[i]时候的最长子序列长度 + 1
     * @param nums
     * @return
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if(nums.length ==0 || nums == null)
            return 0;
        
        int len = nums.length;
        // 记录到当前位置最长升序序列的长度 
        int sublongest[] = new int[len];
        sublongest[0] = 1;
        int longest = Integer.MIN_VALUE;
        
        for(int i = 1;i<len;i++){
            int sublong = 0;
            for(int j=0;j<i;j++){
                // nums[i] 前面有几个比自己小的数 ,比自己小的那个数到自己就是一个递增序列 
                // sublongest[j]  j 这个下标对应 nums[j] 这个元素的
                if(nums[j] <= nums[i]){
                    sublong = Math.max(sublongest[j],sublong);
                }
            }
            sublongest[i] = sublong + 1;	// 表示到i 位置的最长升序子序列的长度
            longest = Math.max(sublongest[i],longest);
        }
        return longest;
    }
    
    // 二分法，且 dp可以保存最长升序子序列
    public int longestIncreasingSubsequence2(int[] nums) {
        int len = nums.length;
        if(nums == null || len ==0)
            return 0;
        
        ArrayList<Integer> dp = new ArrayList<Integer>();
        
        for(int i=0;i<len ;i++){
            if(dp.isEmpty() || dp.get(dp.size() - 1) <= nums[i])
                dp.add(nums[i]);
            else{
                int index = findFirstLargeEqual(dp,nums[i]);
                dp.set(index,nums[i]);
               
            }
        }
        return dp.size();
    }
    // 返回第一个大于等于num 的index
    private int findFirstLargeEqual(ArrayList<Integer> list,int num){
        int left = 0;
        int right = list.size() - 1;
        while(left < right){
            int mid = (left + right)/2;
            if(list.get(mid) <= num) 
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }
    
}
