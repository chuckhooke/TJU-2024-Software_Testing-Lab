package lab2;

public class MaxProductSolution {
    public int maxProduct(int N) {
        // dp[i] 表示分解整数i的最大乘积值，用于存储子问题解
        int[] dp = new int[N + 1];

        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            // 分解为 i 和 i - j
            for (int j = 1; j <= i / 2; j++) {
                // 1. 将 i 和 i - j 相乘
                // 2. 将 i - j 分解，保留 j 不动
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[N];
    }
}
