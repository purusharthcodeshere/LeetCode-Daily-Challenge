class Solution {
    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        }

        //Calculate the length of the number in binary representation
        //Then create a number that has all 1's in the bits place
        //Of number of bits equal to the length of binary representation of num
        //Then xor the num and allOnes number
        
        int bitLength = Integer.toBinaryString(num).length();
        int allOnes = (1 << bitLength) - 1;
        
        return num ^ allOnes;
    }
}