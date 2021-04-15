package dp;

//[最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/)

public class Leetcode64 {
    /**
     * 1.确定状态
     *  最后一步路径一定在f(m - 1, n) 或者 f(m, n - 1)的位置，找到其中和值最小的位置。
     *  转为为子问题，例如f(m - 1, n)最小，那么就转化为走到f(m - 1, n) 这个位置的最小路径和
     * 2.转移方程
     *  f(m, n) = min(f(m - 1, n), f(m, n - 1)) + g(m, n)
     * 3.初始条件和边界处理
     *  f(0, 0) = g(0, 0)
     *  上边界和左边界需要特殊处理
     * 4.计算顺序
     *  从左到右，从上到下
     */
    public int minPathSum(int[][] grid) {
        int minSum = grid[0][0];
        int m = grid.length;
        int n = grid[0].length;
        int[][] sumGrid = new int[m][n];
        sumGrid[0][0] = minSum;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == 0 && j > 0) {
                    sumGrid[i][j] = sumGrid[i][j - 1] + grid[i][j];
                } else if (j == 0 && i > 0) {
                    sumGrid[i][j] += sumGrid[i - 1][j] + + grid[i][j];
                } else if (i > 0) {
                    sumGrid[i][j] = Math.min(sumGrid[i - 1][j], sumGrid[i][j - 1]) + + grid[i][j];
                }
            }
        }
        return sumGrid[m - 1][n - 1];
    }
}
