class Solution {
    public int findMaxFish(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int maxCaught = 0;
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] > 0) {
                    int caught = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] pair = queue.poll();
                        int x = pair[0], y = pair[1];
                        if (grid[x][y] > 0) {
                            caught += grid[x][y];
                            grid[x][y] = 0;     //Mark as visited
                            if (x > 0 && grid[x - 1][y] > 0) queue.add(new int[]{x - 1, y});
                            if (x + 1 < M && grid[x + 1][y] > 0) queue.add(new int[]{x + 1, y});
                            if (y > 0 && grid[x][y - 1] > 0) queue.add(new int[]{x, y - 1});
                            if (y + 1 < N && grid[x][y + 1] > 0) queue.add(new int[]{x, y + 1});
                        }
                    }

                    maxCaught = Math.max(maxCaught, caught);
                }
            }
        }

        return maxCaught;
    }
}