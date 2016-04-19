package lintcode.array.medium;

import java.util.ArrayList;

// 最大子数组 II
/**
 * 给定一个整数数组，找出两个不重叠子数组使得它们的和最大。
 * 每个子数组的数字在数组中的位置应该是连续的。
 * 返回最大的和。
 */
public class Solution42m {
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
    	
        int size = nums.size();
        int[] left = new int[size];
        int[] right = new int[size];
        
        int sum = 0;
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < size; i++){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            left[i] = max;
        }
        
        sum = 0;
        minSum = 0;
        max = Integer.MIN_VALUE;
        for(int i = size - 1; i >= 0; i--){
            sum += nums.get(i);
            max = Math.max(max, sum - minSum);
            minSum = Math.min(sum, minSum);
            right[i] = max;
        }
        
        max = Integer.MIN_VALUE;
        for(int i = 0; i < size - 1; i++){
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }
    
    public int maxTwoSubArrays2(ArrayList<Integer> nums) {
        // write your code
        int size = nums.size();
        if(nums==null || size ==0)
            return 0;
        int[] left = new int[size];
        int[] right = new int[size];
        left[0] = nums.get(0);
        right[size-1] = nums.get(size-1);
        for(int i=1;i<size;i++){
            left[i] = Math.max(left[i-1] + nums.get(i),nums.get(i));
        }
        for(int j=size-2;j>=0 ;j--){
            right[j] = Math.max(right[j+1] + nums.get(j),nums.get(j));
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<size;i++){
            for(int j=size-1;j>i ; j--){
                int tmp = left[i] + right[j];
                max = Math.max(max,tmp);
            }
        }
        return max;
    }
    
    public int maxTwoSubArrays3(ArrayList<Integer> nums) {
        // write your code
        int size = nums.size();
        if(nums==null || size ==0)
            return 0;
        int max = Integer.MIN_VALUE;
        int left[] = new int[size];
        int localMax = 0;
        int globalMax = Integer.MIN_VALUE;
        for(int i=0;i< size;i++){
            localMax = Math.max(localMax+nums.get(i) , nums.get(i));
            globalMax = Math.max(localMax,globalMax);
            left[i] = globalMax;
        }
        localMax = 0;
        globalMax = Integer.MIN_VALUE;
        int right[] = new int[size];
        for(int i = size -1;i>=0;i--){
            localMax = Math.max(localMax + nums.get(i),nums.get(i));
            globalMax = Math.max(localMax,globalMax);
            right[i] = globalMax;
        }
        //left[i] 表示从0 到i 这个区间的最大值
        //right[i+1] 表示从 i + 1 都 size-1 这个区间的最大值
        for(int i=0;i< size-1;i++){
            max = Math.max(left[i] + right[i+1],max);
        }
        return max;
    }
    
}
