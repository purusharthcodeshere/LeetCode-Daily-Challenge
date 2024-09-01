class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int length = original.length;

        if (m * n != length) {
            return new int[][]{};
        }

        int index = 0;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[index++];
            }
        }

        return result;
    }
}