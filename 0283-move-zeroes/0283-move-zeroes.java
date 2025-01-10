class Solution {
    public void moveZeroes(int[] nums) {
        int N = nums.length;
        int i = 0;

        for (int j = 0; j < N; j++) {
            if (nums[j] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
        }
    }
}