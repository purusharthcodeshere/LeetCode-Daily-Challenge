class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int N = nums.length;
        int[] LIS = new int[N], LDS = new int[N];
        Arrays.fill(LIS, 1);
        Arrays.fill(LDS, 1);

        //Compute LIS for each index
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    LDS[i] = Math.max(LDS[i], LDS[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int i = 1; i < N - 1; i++) {
            if (LIS[i] > 1 && LDS[i] > 1) {
                maxLength = Math.max(maxLength, LIS[i] + LDS[i] - 1);
            }
        }

        return N - maxLength;
    }
}