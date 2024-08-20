class Solution {
    public int stoneGameII(int[] piles) {
        int N = piles.length;

        int[][] dp = new int[N][N + 1];
        int[] suffixSum = new int[N];
        suffixSum[N - 1] = piles[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        for (int i = N - 1; i >= 0; i --) {
            for (int m = 1; m <= N; m++) {
                if (i + 2 * m >= N) {
                    dp[i][m] = suffixSum[i];
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        dp[i][m] = Math.max(dp[i][m], suffixSum[i] - dp[i + x][Math.max(m, x)]);
                    }
                }
            }
        }

        return dp[0][1]; 
    }
}