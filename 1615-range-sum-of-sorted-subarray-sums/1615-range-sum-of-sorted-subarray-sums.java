class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] prefix = new int[n * (n + 1) / 2];

        for (int i = 0, k = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                prefix[k] = sum;
                k++;
            }
        }

        Arrays.sort(prefix);

        int ans = 0;
        int mod = 1_000_000_000 + 7;

        for (int i = left - 1; i < right; i++) {
            ans = (ans + prefix[i]) % mod;
        }

        return ans;
    }
}