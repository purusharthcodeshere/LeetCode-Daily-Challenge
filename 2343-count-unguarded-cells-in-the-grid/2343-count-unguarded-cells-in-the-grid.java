class Solution {
    int m;
    int n;
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        this.m = m;
        this.n = n;
        int[][] grid = new int[m][n];

        //Mark guards and walls as 2
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }

        //Directions: up, right, down, left
        int[] directions = {-1, 0, 1, 0, -1};

        //Process the guard's line of sight
        for (int[] guard : guards) {
            for (int dir = 0; dir < 4; dir++) {
                int x = guard[0], y = guard[1];
                int dx = directions[dir], dy = directions[dir + 1];

                //Check cells in current direction until hitting boundary or obstacle
                while (inbounds(x, y, dx, dy) && grid[x + dx][y + dy] < 2) {
                    x += dx;
                    y += dy;
                    grid[x][y] = 1;
                }
            }
        }

        //Count unguarded cells (with value 0) 
        int count = 0;
        for (int[] i : grid) {
            for (int j : i) {
                if (j == 0) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean inbounds(int x, int y, int dx, int dy) {
        return (x + dx >= 0 && x + dx < m && y + dy >= 0 && y + dy < n);
    }
}