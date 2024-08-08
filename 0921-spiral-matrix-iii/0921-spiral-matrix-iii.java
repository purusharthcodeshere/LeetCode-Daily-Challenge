class Solution {
    int rows;
    int cols;

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        //List to store the visited indices
        //will stream to a 2-d matrix while returning
        List<int[]> matrix = new ArrayList<int[]> ();

        this.rows = rows;
        this.cols = cols;

        //Directions array to stimulate the flow of matrix
        //Right, Down, Left, Up
        int[] direc = {0, 1, 0, -1};
        // int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = 1;
        int grid = rows * cols;
        int dir = 0;
        int row = rStart, col = cStart;

        while (matrix.size() < grid) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < count; j++) {
                    if (inBounds(row, col)) {
                        matrix.add(new int[]{row, col});
                    }

                    if (matrix.size() == grid) {
                        return matrix.toArray(new int[matrix.size()][]);
                    }

                    row += direc[dir];
                    col += direc[(dir + 1) % 4];
                }

                dir = (dir + 1) % 4;
            }

            count++;
        } 

        return matrix.toArray(new int[matrix.size()][]);      
    }

    private boolean inBounds(int row, int col) {
        return (row >= 0 && row < rows && col >= 0 && col < cols);
    }
}