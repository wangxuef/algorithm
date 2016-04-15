package lintcode.array.easy;

//最长上升连续子序列----------- 还有，最长上升子序列 76
//最长上升连续子序列可以定义为从右到左或从左到右的序列
// 返回长度
public class Solution397 {
    //最长上升连续子序列
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int answer = 1;
        
        // from left to right
        int length = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                length++;
            } else {
                length = 1;         
            }
            answer = Math.max(answer, length);
        }
        
        // from right to left
        length = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                length++;
            } else {
                length = 1;
            }
            answer = Math.max(answer, length);
        }
        
        return answer;
    }
    
    // 最长上升子序列--可以不连续
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
            sublongest[i] = sublong + 1;        // 表示到i 位置的最长升序子序列的长度
            longest = Math.max(sublongest[i],longest);
        }
        return longest;
    }
    
    public static void main(String[] args) {
        Solution397 s1 = new Solution397();
        int[] a = { 1, 2, 3, 4, 3, 4, 5 };
        System.out.println(s1.longestIncreasingSubsequence(a));
    }
    
}
