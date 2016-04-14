package lintcode.array.easy;

// 矩阵的之字型遍历		注意：之字遍历，与对角遍历不同
/*
	[
	  [1, 2,  3,  4],
	  [5, 6,  7,  8],
	  [9,10, 11, 12]
	]
	
	返回 [1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12]
*/

public class Solution185e {
    public int[] printZMatrix(int[][] matrix) {
        
        if(matrix == null || matrix.length==0 || matrix[0].length==0){
            return null;
        }
        
        int r = 0;
        int c = 0;
        int count = matrix.length * matrix[0].length;
        int[] result = new int[count];
        result[0] = matrix[0][0];
        
        for(int i=1; i<count;){
            
            // 斜向上
            while(i<count && r-1>=0 && c+1<matrix[0].length){
                result[i++] = matrix[--r][++c];
            }
            
            // 横右走一步，不可横右走时竖下走一步
            if (i < count && c + 1 < matrix[0].length) { // 横右走一步
                result[i++] = matrix[r][++c];
            } else if (i < count && r + 1 < matrix.length) { // 不可横右走时竖下走一步
                result[i++] = matrix[++r][c];
            }
            
            // 斜下走到底
            while (i < count && r + 1 < matrix.length && c - 1 >= 0) {
                result[i++] = matrix[++r][--c];
            }
            
            // 竖下走一步，不可竖下走时横右走一步
            if (i < count && r + 1 < matrix.length) {
                result[i++] = matrix[++r][c];
            } else if (i < count && c + 1 < matrix[0].length) {
                result[i++] = matrix[r][++c];
            }
        }
        return result;
        
    }

}
