package lintcode.array.medium;

// 打劫房屋

public class Solution392m {
	// dp[i], 不包含A[i]元素时所取得的最大值
    public long houseRobber(int[] A) {
    	int len = A.length;
    	if(len==0){
    		return 0;
    	}
    	long dp[] = new long[len+1];
    	dp[1] = A[0];
    	if(len==1){
    		return dp[1];
    	}
    	for(int i=2; i<=len; i++){
    		dp[i] = Math.max(dp[i-1], dp[i-2]+A[i-1]);
    	}
    	return dp[len];	
    }
    
    public long houseRobber2(int[] A) {
        // write your code here
        int len = A.length;
        // dp[i] 表达打劫i房间为止所活动的收获 ，与dp[i-2] dp[i-3]有关
        if(len ==0)
            return 0;
        long dp[] = new long[len];
        dp[0] = A[0];
        if(len == 1){
            return dp[0];
        }else if(len == 2){
            dp[1] = A[1];
            return Math.max(dp[0],dp[1]);
        }else if(len == 3){
            dp[1] = A[1];
            dp[2] = A[0] + A[2];
            return Math.max(dp[1],dp[2]);
        }
        dp[1] = A[1];
        dp[2] = A[0] + A[2];
        for(int i = 3;i< len; i++){
            dp[i] = A[i] + Math.max(dp[i-2],dp[i-3]); 
        }
        return Math.max(dp[len-2],dp[len-1]);
    }
    
}
