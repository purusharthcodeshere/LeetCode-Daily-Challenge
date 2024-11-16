class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new int[0];
        }

        int N = nums.length;

        int[] result = new int[N - k + 1];
        int i = 0, j = k - 1, index = 0;

        while (j < N) {
            if (solved(nums, i, j)) {
                result[index] = nums[j];
            } else {
                result[index] = -1;
            }
            i++;
            j++;
            index++;
        } 

        return result;
    }

    private boolean solved(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return false;
            }
        }

        return true;
    }
}