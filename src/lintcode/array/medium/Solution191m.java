package lintcode.array.medium;

// 乘积最大子序列

public class Solution191m {
    
    public int maxProduct(int[] nums) {
    	if(nums==null || nums.length==0){
    		return 0;
    	}
    	int len = nums.length;
    	int max = Integer.MIN_VALUE;
    	for(int i=0; i<len; i++){
    		int s = 1;
    		for(int j=i; j<len; j++){
    			s *= nums[j];
    			max = Math.max(s, max);
    		}
    	}
    	return max;
    }
    
    //动态规划
    public int maxProduct2(int[] A) {
        // write your code here
        if(A == null || A.length ==0)
            return 0;
        int maxLocal = A[0];
        int minLocal = A[0];
        int global = A[0];
        for(int i=1;i< A.length; i++){
            int tmp = maxLocal;
            maxLocal = Math.max(Math.max(A[i]*maxLocal,A[i]),
                                A[i]*minLocal);
            minLocal = Math.min(Math.min(A[i]*tmp,A[i]),
                                A[i]*minLocal);
            global = Math.max(maxLocal,global);
        }
        return global;
        
    }
    
}
