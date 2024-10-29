class Solution {
    public int maxMoves(int[][] grid) {
        //Dimensions of the grid
        int M = grid.length;
        int N = grid[0].length;

        //Result will be stored the rightmost column we can reach\
        int result = 0;

        //Dp array stores the maximum number of moves possible to reach each cell
        //in the current column we are processing
        int[] dp = new int [M];

        for (int j = 1; j < N; j++) {
            //LeftTop keeps track of the DP value from the cell above-left
            int leftTop = 0;
            //Founc indicates if we can reach any cell in current column
            boolean found = false;

            //Iterate through each row in current column
            for (int i = 0; i < M; i++) {
                int current = -1;
                int nextLeftTop = dp[i];

                if (i - 1 >= 0 && leftTop != -1 && grid[i][j] > grid[i - 1][j - 1]) {
                    current = Math.max(current, leftTop + 1);
                }

                if (dp[i] != -1 && grid[i][j] > grid[i][j - 1]) {
                    current = Math.max(current, dp[i] + 1);
                }

                if (i + 1 < M && dp[i + 1] != -1 && grid[i][j] > grid[i + 1][j - 1]) {
                    current = Math.max(current, dp[i + 1] + 1);
                }

                dp[i] = current;
                found = found || (dp[i] != -1);
                leftTop = nextLeftTop;
            }

            if (!found) break;

            result = j;
        }

        return result;
    }
}