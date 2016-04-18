package suanfa;

// 年终奖
/**
 * 小东要在公司年会上参与一个抽奖游戏，游戏在一个6*6的棋盘上进行，上面放着36个价值不等的礼物，每个小的棋盘上面放置着一个礼物，
 * 他需要从左上角开始游戏，每次只能向下或者向右移动一步，到达右下角停止，一路上的格子里的礼物小东都能拿到，请设计一个算法使小东拿到价值最高的礼物。
 * 给定一个6*6的矩阵board，其中每个元素为对应格子的礼物价值,左上角为[0,0],请返回能获得的最大价值，保证每个礼物价值大于100小于1000。
 * 
 * @author wxf
 */
public class Bonus {
    // 动态规划
    public int getMost(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return -1;
        int row = board.length;
        int col = board[0].length;
        // 第一列
        for(int i = 1;i<row;i++)
            board[i][0] += board[i-1][0];
        // 第一行
        for(int j = 1;j<col;j++)
            board[0][j] += board[0][j-1];
        
        for(int i = 1;i<row;i++){
            for(int j = 1;j< col;j++){
                board[i][j] += Math.max(board[i][j-1] ,board[i-1][j]);
            }
        }
        return board[row-1][col-1];
    }
    
}
