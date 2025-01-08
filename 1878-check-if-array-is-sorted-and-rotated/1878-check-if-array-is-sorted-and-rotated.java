class Solution {
    public boolean check(int[] nums) {
        int N = nums.length;
        int count = 0;

        for (int i = 1; i < N; i++) {
            if (nums[i - 1] > nums[i]) {
                count++;
            }
        }

        if (nums[N - 1] > nums[0]) {
            count++;
        }

        return count <= 1;
    }
}