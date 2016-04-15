package lintcode.array.easy;

import java.util.ArrayList;

// Recover Rotated Sorted Array  , 元素循环右移的数组
// 恢复旋转排序数组
/**
 * Given a rotated sorted array, recover it to sorted array in-place.
 * What is rotated array?
 * For example, the orginal array is [1,2,3,4], 
 * The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 * 
 * 挑战-->使用O(1)的额外空间和O(n)时间复杂度
 * @author wxf
 */
public class Solution39 {
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        for(int i=0; i<nums.size(); i++){
            if(nums.get(i)>nums.get(i+1)){ //找到临界点
                reverseArray(nums, 0, i); // 前半部分逆序
                reverseArray(nums, i+1, nums.size()-1); //后半部分逆序
                reverseArray(nums, 0, nums.size()-1);   // 整体逆序
            }
        }
    }
    
    //逆序一个序列
    private void reverseArray(ArrayList<Integer> nums, int start, int end){
        for(int i=start, j=end; i<j; i++, j--){
            int temp = nums.get(i);
            nums.set(i, nums.get(j));
            nums.set(j, temp);
        }
    }
    
    //逆序一个序列---方法2
    private static void reverseArray2(ArrayList<Integer> nums, int start, int end){
        while(start<end){
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }
//    
//    public static void main(String[] args) {
//        Integer[] a = {1,2,3,4};
//        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(a));
//        System.out.println(list);
//        reverseArray2(list, 0, 3);
//        System.out.println(list);
//    }

}