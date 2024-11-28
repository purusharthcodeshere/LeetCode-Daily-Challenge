class Solution {
    public int minimumObstacles(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        int[][] distance = new int[M][N];
        for (int[] row : distance) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        Deque<int[]> deque = new ArrayDeque<>();

        distance[0][0] = 0;

        deque.offerFirst(new int[] {0, 0});
        int[] directions = {-1, 0, 1, 0, -1};
        while (!deque.isEmpty()) {
            int[] cell = deque.pollFirst();
            int x = cell[0], y = cell[1];
            for (int k = 0; k < 4; k++) {
                int newRow = x + directions[k];
                int newCol = y + directions[k + 1];
                if (inBounds(newRow, newCol, M, N)) {
                    int newDistance = distance[x][y] + grid[newRow][newCol];
                    if (newDistance < distance[newRow][newCol]) {
                        distance[newRow][newCol] = newDistance;
                        if (grid[newRow][newCol] == 0) {
                            deque.offerFirst(new int[] {newRow, newCol});
                        } else {
                            deque.offerLast(new int[] {newRow, newCol});
                        }
                    }
                }
            }
        }
        
        return distance[M - 1][N - 1];
    }

    private boolean inBounds(int row, int col, int M, int N) {
        return row >= 0 && row < M && col >= 0 && col < N;
    }
}