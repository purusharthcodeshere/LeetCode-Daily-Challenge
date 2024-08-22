class Solution {
    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        }

        int bitLength = Integer.toBinaryString(num).length();
        int allOnes = (1 << bitLength) - 1;
        
        return num ^ allOnes;
    }
}