class Spreadsheet {

    private int[][] cells;

    public Spreadsheet(int rows) {
        cells = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        cells[row][col] = value;
    }
    
    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        cells[row][col] = 0;
    }
    
    public int getValue(String formula) {
        int idx = formula.indexOf('+');
        String left = formula.substring(1, idx);
        String right = formula.substring(idx + 1);

        int valLeft = 
            Character.isLetter(left.charAt(0)) 
            ? cells[Integer.parseInt(left.substring(1)) - 1][left.charAt(0) - 'A'] 
            : Integer.parseInt(left);

        int valRight = 
            Character.isLetter(right.charAt(0)) 
            ? cells[Integer.parseInt(right.substring(1)) - 1][right.charAt(0) - 'A'] 
            : Integer.parseInt(right);

        return valLeft + valRight;
    }
}