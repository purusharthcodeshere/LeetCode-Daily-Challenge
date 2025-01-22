class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int M = isWater.length;
        int N = isWater[0].length;

        int[][] height = new int[M][N];

        Queue<int[]> queue = new LinkedList<>();

        //Initialize matrix and queue
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int[]{i, j});
                } else {
                    height[i][j] = -1;
                }
            }
        }

        //Down, Left, Up, Right
        int[] directions = new int[]{1, 0, -1, 0, 1};

        //BFS Traversal
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            //Check all the adjacent cells
            for (int k = 0; k < 4; k++) {
                int newRow = row + directions[k];
                int newCol = col + directions[k + 1];

                //If adjacent cell is within boundary and unvisited
                if (inBounds(M, N, newRow, newCol) && height[newRow][newCol] == -1) {
                    //Set height to 1 more than current cell
                    height[newRow][newCol] = height[row][col] + 1;

                    //Add to queue for further exploration
                    queue.add(new int[]{newRow, newCol});
                } 
            }
        }

        return height;
    }

    private boolean inBounds(int M, int N, int row, int col) {
        return row >= 0 && row < M && col >= 0 && col < N;
    }
}