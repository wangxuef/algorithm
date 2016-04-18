package suanfa.mogujie;

import java.util.Scanner;

// 最大间隔
/**
 * 给定一个递增序列，a1 <a2 <...<an 。定义这个序列的最大间隔为d=max{ai+1 - ai }(1≤i<n),
 * 现在要从a2,a3 ..an-1 中删除一个元素。问剩余序列的最大间隔最小是多少？
 * 
 * 输入描述:
 * 第一行，一个正整数n(1<=n<=100),序列长度;接下来n个小于1000的正整数，表示一个递增序列。
 * @author wxf
 */
public class MaxDistance {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, maxd = 0;
        int[] A;
        while (in.hasNext()) {
            n = in.nextInt();
            A = new int[n];
            for (int i = 0; i < n; i++)
                A[i] = in.nextInt();
            maxd = MaxDistanceMin(A, n);
            System.out.println(maxd);
        }
    }

    public static int MaxDistanceMin(int[] A, int n) {
        int maxd = -1;
        int minMaxd = Integer.MAX_VALUE;
        int[] d = new int[n - 1];
        // 记录相邻两个元素的间隔
        for (int i = 1; i <= n - 1; i++) {
            d[i - 1] = A[i] - A[i - 1];
            maxd = Math.max(maxd, d[i - 1]);// 求出最大间隔
        }
        // 间隔d 向量元素合并，当大于maxd 的时候选取最小值
        for (int i = 0; i < d.length - 1; i++) {
            int subd = d[i] + d[i + 1];
            if (subd > maxd) {// 新的最大间隔
                minMaxd = Math.min(minMaxd, subd);
            } else {
                minMaxd = Math.min(minMaxd, maxd);
            }
        }
        return minMaxd;
    }

}
