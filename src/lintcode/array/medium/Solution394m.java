package lintcode.array.medium;

// 硬币排成线
/**
 * 有 n 个硬币排成一条线。两个参赛者轮流从右边依次拿走 1 或 2 个硬币，直到没有硬币为止。
 * 拿到最后一枚硬币的人获胜。
 * 请判定 第一个玩家 是输还是赢？
 * 
 * 3个一轮，因为你拿1个，我就2个，你拿2个，我就1个，也就是说如果是3的倍数，
 * 肯定是后手赢，先手可以拿1-2个把总数改成3的倍数。
 * @author Administrator
 */

public class Solution394m {
    public boolean firstWillWin(int n) {
        return n%3!=0;
    }
    
}
