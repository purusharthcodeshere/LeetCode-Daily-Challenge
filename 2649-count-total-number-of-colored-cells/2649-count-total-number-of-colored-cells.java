class Solution {
    public long coloredCells(int n) {
        // long blueCells = 1;
        // int addend = 4;

        // while (--n > 0) {
        //     blueCells += addend;
        //     addend += 4;
        // } 

        // return blueCells;

        return 1 + (long) n * (n - 1) * 2;
    }
}