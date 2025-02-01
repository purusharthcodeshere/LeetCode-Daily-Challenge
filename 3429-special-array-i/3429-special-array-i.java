class Solution {
    public boolean isArraySpecial(int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N - 1; i++) {
            if (((nums[i] & 1) ^ (nums[i + 1] & 1)) == 0) {
                //If two adjacent numbers have the same parity
                //Then we return false;
                return false;
            }
        }

        //If no pair of adjacent numbers with same parity are found
        //We return true
        return true;
    }
}