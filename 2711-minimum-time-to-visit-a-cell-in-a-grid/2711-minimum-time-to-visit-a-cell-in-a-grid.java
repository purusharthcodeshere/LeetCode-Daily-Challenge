class Solution {
    private static final int[] directions = {-1, 0, 1, 0, -1};

    public int minimumTime(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] seen = new boolean[rows][cols];

        queue.offer(new int[]{0, 0, 0});    //time, row, col
        seen[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int time = current[0];
            int row = current[1];
            int col = current[2];

            for (int dir = 0; dir < 4; dir++) {
                int newRow = row + directions[dir];
                int newCol = col + directions[dir + 1];

                if (newRow < 0 || newRow >= rows ||
                    newCol < 0 || newCol >= cols ||
                    seen[newRow][newCol]) {
                    continue;
                }

                int newTime = time + 1;
                if (grid[newRow][newCol] > newTime) {
                    int wait = ((grid[newRow][newCol] - newTime + 1) / 2) * 2;
                    newTime += wait;
                }

                if (newRow == rows - 1 && newCol == cols - 1) {
                    return newTime;
                }

                seen[newRow][newCol] = true;
                queue.offer(new int[] {newTime, newRow, newCol});
            }
        }

        return -1;
    }
}