class Solution {
    public int[] applyOperations(int[] nums) {
        int N = nums.length;
        int[] newNums = new int[N];
        int zero = 0;

        for (int i = 0; i < N - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        for (int num : nums) {
            if (num != 0) {
                newNums[zero++] = num;
            }
        }

        while (zero < N) {
            newNums[zero++] = 0;
        }

        return newNums;
    }
}