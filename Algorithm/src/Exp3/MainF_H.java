package Exp3;

import java.util.Arrays;
import java.util.Scanner;

public class MainF_H{
    
    // ==================== 1. 暴力递归解法 ====================
    /**
     * 暴力递归解法 - 尝试所有可能的分割方式
     * @param P 矩阵维度数组，长度为n+1（n个矩阵需要n+1个维度值）
     * @param i 起始矩阵索引（从1开始）
     * @param j 结束矩阵索引
     * @return 最小乘法次数
     */
    public static int bruteForce(int[] P, int i, int j) {
        // 基本情况：只有一个矩阵，不需要乘法操作
        if (i == j) {
            return 0;
        }
        
        int minCost = Integer.MAX_VALUE;
        
        // 尝试所有可能的分割点k
        for (int k = i; k < j; k++) {
            // 递归计算左半部分的最小代价
            int leftCost = bruteForce(P, i, k);
            // 递归计算右半部分的最小代价  
            int rightCost = bruteForce(P, k + 1, j);
            // 合并左右两部分的代价 = 左矩阵行数 × 分割点矩阵列数 × 右矩阵列数
            int mergeCost = P[i - 1] * P[k] * P[j];
            // 总代价
            int totalCost = leftCost + rightCost + mergeCost;
            
            // 更新最小值
            if (totalCost < minCost) {
                minCost = totalCost;
            }
        }
        
        return minCost;
    }
    
    // ==================== 2. 记忆化搜索解法 ====================
    /**
     * 记忆化搜索解法 - 添加备忘录避免重复计算
     */
    public static int memoization(int[] P) {
        int n = P.length - 1; // 矩阵个数
        int[][] memo = new int[n + 1][n + 1]; // 备忘录
        
        // 初始化备忘录为-1，表示未计算
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        return memoHelper(P, 1, n, memo);
    }
    
    private static int memoHelper(int[] P, int i, int j, int[][] memo) {
        // 如果已经计算过，直接返回结果
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        
        // 基本情况：只有一个矩阵
        if (i == j) {
            memo[i][j] = 0;
            return 0;
        }
        
        int minCost = Integer.MAX_VALUE;
        
        // 尝试所有可能的分割点
        for (int k = i; k < j; k++) {
            int leftCost = memoHelper(P, i, k, memo);
            int rightCost = memoHelper(P, k + 1, j, memo);
            int mergeCost = P[i - 1] * P[k] * P[j];
            int totalCost = leftCost + rightCost + mergeCost;
            
            if (totalCost < minCost) {
                minCost = totalCost;
            }
        }
        
        // 保存结果到备忘录
        memo[i][j] = minCost;
        return minCost;
    }
    
    // ==================== 3. 动态规划解法 ====================
    /**
     * 动态规划解法 - 自底向上填充DP表
     */
    public static int dynamicProgramming(int[] P) {
        int n = P.length - 1; // 矩阵个数
        int[][] dp = new int[n + 1][n + 1]; // dp[i][j]表示矩阵i到j的最小代价
        
        // 初始化：对角线为0（单个矩阵的代价为0）
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 0;
        }
        
        // 按链长从小到大计算（链长L从2到n）
        for (int L = 2; L <= n; L++) {
            for (int i = 1; i <= n - L + 1; i++) {
                int j = i + L - 1;
                dp[i][j] = Integer.MAX_VALUE;
                
                // 尝试所有可能的分割点
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + P[i - 1] * P[k] * P[j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }
        
        return dp[1][n];
    }
    
    // ==================== 主函数和测试代码 ====================
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
        	// 读取输入
            int n = scanner.nextInt(); // 矩阵个数
            int[] P = new int[n + 1];  // 维度数组
            
            for (int i = 0; i <= n; i++) {
                P[i] = scanner.nextInt();
            }
            
            
            int dpResult = dynamicProgramming(P);  
            System.out.println(dpResult);
        }
        scanner.close();
    }
}
