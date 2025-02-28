class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int max = 0;

        for (int i : nums) {
            if (i == 1) {
                count++;
            } else {
                count = 0;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}