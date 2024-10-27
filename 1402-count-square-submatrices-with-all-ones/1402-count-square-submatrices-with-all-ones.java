class Solution {
    public int countSquares(int[][] matrix) {
        //Get the dimensions of the matrix
        int N = matrix.length;
        int M = matrix[0].length;

        //Create a dp table with the same dimensions as the matrix
        int[][] dp = new int[N][M];

        //variable to store the count of squares
        int ans = 0;

        //Initialize first column of DP table
        for (int i = 0; i < N; i++) {
            dp[i][0] = matrix[i][0];
            ans += dp[i][0];
        }

        //Initialize first row of DP table
        for (int j = 1; j < M; j++) {
            dp[0][j] = matrix[0][j];
            ans += dp[0][j];
        }

        //Fill the DP table for the remaining cells
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                }
                ans += dp[i][j];
            }
        }

        return ans;
    }
}