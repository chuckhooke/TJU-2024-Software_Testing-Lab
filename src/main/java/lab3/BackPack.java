package lab3;

public class BackPack {

    public int backPack(int[] weight, int[] value, int capacity) {
        int n = weight.length;
        int[][] dp = new int[n + 1][capacity + 1];

        // dp[i][j]表示前i个物品 背包容量为j 的最大价值
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weight[i - 1] <= j) {
                    // 不拿第i个物品：dp[i - 1][j]
                    // 拿第i个物品：value[i - 1] + dp[i - 1][j - weight[i - 1]] 【在考虑前一个物品的背包容量预留出当前物品重量的基础上】
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i - 1][j - weight[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        BackPack backPack = new BackPack();
        int[] weight = {2, 3, 4, 5};
        int[] value = {3, 4, 5, 6};
        int capacity = 7;
        int maxValue = backPack.backPack(weight, value, capacity);
        System.out.println("Max Value: " + maxValue);
    }
}




