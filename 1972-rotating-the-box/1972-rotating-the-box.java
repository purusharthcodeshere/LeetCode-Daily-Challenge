class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int rows = box.length;
        int cols = box[0].length;

        char[][] result = new char[cols][rows];
        for (char[] row : result) {
            Arrays.fill(row, '.');
        }

        for (int row = 0; row < rows; row++) {
            int i = cols - 1;
            for (int col = cols - 1; col >= 0; col--) {
                if (box[row][col] == '#') {
                    result[i][rows - row - 1] = '#';
                    i--;
                } else if (box[row][col] == '*') {
                    result[col][rows - row - 1] = '*';
                    i = col - 1;
                }
            }
        }

        return result;
    }
}