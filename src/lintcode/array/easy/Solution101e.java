package lintcode.array.easy;

// Remove Duplicates from Sorted Array II
// duplicates are allowed at most twice

// 可以允许出现两次
// 只要求返回 数组的长度！！！

public class Solution101e {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null)
            return 0;

        int cur = 0;
        int i, j;
        for (i = 0; i < nums.length;) {
            int now = nums[i];
            for (j = i; j < nums.length; j++) {
                if (nums[j] != now)
                    break;
                if (j - i < 2)  // nums[j] == nums[i].  当j-i>=2时并没有跳出循环
                    nums[cur++] = now;
            }
            i = j;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 2, 2, 3, 4 };
        System.out.println(removeDuplicates(A));
    }
}
