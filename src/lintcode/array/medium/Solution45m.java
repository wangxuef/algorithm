package lintcode.array.medium;

// 最大字数组差
public class Solution45m {
    
	public int maxDiffSubArrays(int[] nums) {
        // write your code here
        if(nums == null || nums.length ==0)
            return 0;
        int len = nums.length;
        int[] leftMax = new int[len];
        int[] rightMin = new int[len];
        int localMax = 0;
        int globalMax = Integer.MIN_VALUE;
        for(int i=0;i <len ;i++){
            localMax = Math.max(localMax + nums[i],nums[i]);
            globalMax = Math.max(localMax,globalMax);
            leftMax[i] = globalMax;
        }
        int localMin = 0;
        int globalMin = Integer.MAX_VALUE;
        for(int i=len-1;i >=0 ;i--){
            localMin = Math.min(localMin + nums[i],nums[i]);
            globalMin = Math.min(localMin,globalMin);
            rightMin[i] = globalMin;
        }
        int leftMAX = Integer.MIN_VALUE;
        for(int i=0;i<len-1;i++){
            leftMAX = Math.max(Math.abs(leftMax[i] - rightMin[i+1]),leftMAX);
        }
        
        int[] leftMin = new int[len];
        int[] rightMax = new int[len];
        localMin = 0;
        globalMin = Integer.MAX_VALUE;
        for(int i=0;i <len ;i++){
            localMin = Math.min(localMin + nums[i],nums[i]);
            globalMin = Math.min(localMin,globalMin);
            leftMin[i] = globalMin;
        }
        localMax = 0;
        globalMax = Integer.MIN_VALUE;
        for(int i=len-1;i >=0 ;i--){
            localMax = Math.max(localMax + nums[i],nums[i]);
            globalMax = Math.max(localMax,globalMax);
            rightMax[i] = globalMax;
        }
        int rightMAX = Integer.MIN_VALUE;
        for(int i=0;i<len-1;i++){
            rightMAX = Math.max(Math.abs(leftMin[i] - rightMax[i+1]),rightMAX);
        }
        
        return Math.max(leftMAX,rightMAX);
    }
    
}
