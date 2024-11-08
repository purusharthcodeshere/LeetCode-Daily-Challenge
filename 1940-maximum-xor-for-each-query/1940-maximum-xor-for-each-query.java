class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int N = nums.length;
        int xor = nums[0];
        int maxXor = (1 << maximumBit) - 1;

        for (int i = 1; i < N; i++) {
            xor ^= nums[i];
        }

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[i] = xor ^ maxXor;
            xor ^= nums[N - 1 - i];
        }

        return ans;
    }
}