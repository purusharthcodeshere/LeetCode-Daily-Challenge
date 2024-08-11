class Solution {
    public int minDays(int[][] grid) {
        if (countIslands(grid) != 1) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    if (countIslands(grid) != 1) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }

    private int countIslands(int[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !seen[i][j]) {
                    islands++;
                    dfs(grid, i, j, seen);
                }
            }
        }

        return islands;
    }

    private void dfs(int[][] grid, int row, int col, boolean[][] seen) {
        seen[row][col] = true;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] == 1 && !seen[newRow][newCol]) {
                dfs(grid, newRow, newCol, seen);
            }
        }
    }
}