class Solution {
    public int maxWidthRamp(int[] nums) {
        int N = nums.length;
        Stack<Integer> stack = new Stack<Integer>();

        //Step 1: Build a decreasing stack of indices
        for (int i = 0; i < N; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        int maxWidth = 0;

        //Step 2: Travrse from the end and find maximum width ramp
        for (int j = N - 1; j >= 0; j--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                maxWidth = Math.max(maxWidth, j - stack.pop());
            }
        }

        return maxWidth;
    }
}