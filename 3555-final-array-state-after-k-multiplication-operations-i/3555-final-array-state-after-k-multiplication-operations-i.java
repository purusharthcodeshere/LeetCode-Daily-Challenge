class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            int value = Integer.compare(a[0], b[0]);
            if (value == 0) {
                return Integer.compare(a[1], b[1]);
            }
            return value;
        });

        for (int i = 0; i < nums.length; i++) {
            minHeap.offer(new int[]{nums[i], i});
        }

        while (k -- > 0) {
            int[] smallest = minHeap.poll();
            int index = smallest[1];

            nums[index] *= multiplier;
            minHeap.offer(new int[]{nums[index], index});
        }

        return nums;
    }
}