class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        long count = 0;
        
        for (int i = 0; i < nums.length; i++) {
            count += -1 + map.merge(nums[i] - i, 1, Integer::sum);
        }

        int len = nums.length;
        return 1L * len * (len - 1) / 2 - count;
    }
}