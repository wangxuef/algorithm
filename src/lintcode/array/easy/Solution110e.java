package lintcode.array.easy;

// 最小路径和
/**
 * 从矩阵左上顶点到右下顶点的最小路径和
 * 每次只能向下或向右移动
 * @author Administrator
 */
public class Solution110e {
	public int minPathSum(int[][] grid) {
		if(grid==null || grid.length==0 ||grid[0].length==0)
			return 0;
		for(int i=1; i<grid.length; i++){
			grid[i][0] += grid[i-1][0];
		}
		for(int j=1; j<grid[0].length; j++){
			grid[0][j] += grid[0][j-1];
		}
		
		for(int i=1;i<grid.length; i++){
			for(int j=1; j<grid[0].length; j++){
				grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
			}
		}
		return grid[grid.length-1][grid[0].length-1];
	}
	
	
	/**
	 * 最小路径和:三个方向................还有，从左上到右下（四个方向）
	 * 从矩阵的最左列任意位置出发-->最右列任意位置，可以移动方向：up，down，right
	 */
    public static int path_min(int[][] data){
        int size = data.length;
        int ans[] = new int[size];
        for(int i =0;i<size;i++)
            ans[i] = data[i][size-1];
        // 最后一类的前一个路径一定是同行的前一列
        for(int index = size -2;index>=0;index--){
            ans[0] += data[0][index];
            // 向下 
            for(int innerIndex = 1;innerIndex<size;innerIndex++){
                ans[innerIndex] = Math.min(ans[innerIndex]+data[innerIndex][index],
                        ans[innerIndex-1]+data[innerIndex][index]);
            }
            // 向上
            for(int innerIndex = size-2;innerIndex>=0;innerIndex--){
                ans[innerIndex] = Math.min(ans[innerIndex],
                        ans[innerIndex+1]+data[innerIndex][index]);
            }
        }
        int MIN = Integer.MAX_VALUE;
        for(int i = 0;i<size;i++)
            if(MIN>ans[i])
                MIN = ans[i];
        return MIN;
    }

}
