class Solution {
    public long maxPoints(int[][] points) {
        int M = points.length;
        int N = points[0].length;
        long[] dp = new long[N];

        //Initialize dp with the first row
        for (int j = 0; j < N; j++) {
            dp[j] = points[0][j];
        }

        for (int i = 1; i < M; i++) {
            long[] leftMax = new long[N];
            long[] rightMax = new long[N];
            long[] newDP = new long[N];

            //Calculate left max
            leftMax[0] = dp[0];
            for (int j = 1; j < N; j++) {
                leftMax[j] = Math.max(leftMax[j - 1], dp[j] + j);
            }

            //Calculate right max
            rightMax[N - 1] = dp[N - 1] - (N - 1);
            for (int j = N - 2; j >= 0; j--) {
                rightMax[j] = Math.max(rightMax[j + 1], dp[j] - j);
            }

            //Calculate new DP for the current row
            for (int j = 0; j < N; j++) {
                newDP[j] = Math.max(leftMax[j] - j, rightMax[j] + j) + points[i][j];
            }

            dp = newDP;
        }

        long maxPoints = dp[0];
        for (int j = 1; j < N; j++) {
            maxPoints = Math.max(maxPoints, dp[j]);
        }

        return maxPoints;
    }
}