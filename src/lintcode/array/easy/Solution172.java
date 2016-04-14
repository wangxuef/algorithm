package lintcode.array.easy;

//Remove Element
//  Given an array and a value, remove all occurrences 
// of that value in place and return the new length.

public class Solution172 {
    /**
     * @param A: A list of integers
     * @param elem: An integer
     * @return: The new length after remove
     */
    // 可以改变原来数组的顺序。
    // 删除A中的所有elem元素
    public int removeElement(int[] A, int elem) {
        int i = 0;
        int pointer = A.length - 1;
        while (i <= pointer) {
            if (A[i] == elem) {
                A[i] = A[pointer]; // 把最后一个元素放到被删除的位置，再重新判断
                pointer--;
            } else {
                i++;
            }
        }
        return pointer + 1;
    }
}
