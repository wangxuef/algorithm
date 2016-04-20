package lintcode.array.medium;

// 最大子正方形
/**
 * 给定一个二维01矩阵，从中找出最大的全1正方形,并返回其面积
 * @author Administrator
 */

public class Solution436m {
    public int maxSquare(int[][] matrix) {
        // write your code here
        if(matrix==null)
            return 0;
        int m = matrix.length;
        if(m ==0 )
            return 0;
        int n = matrix[0].length;
        if( n==0 )
            return 0;
        int res = -1;
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(matrix[i][j]!=0 ){
                    matrix[i][j] = min3(matrix[i-1][j-1],matrix[i][j-1],matrix[i-1][j]) + 1;
                }
                res = Math.max(res,matrix[i][j]);
                
            }
        }
        return res*res;
    }
    public int min3(int a ,int b,int c){
        a = Math.min(a,b);
        c = Math.min(a,c);
        return c;
    }
    
}
