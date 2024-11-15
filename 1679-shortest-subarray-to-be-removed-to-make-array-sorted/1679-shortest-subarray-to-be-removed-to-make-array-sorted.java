class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int N = arr.length;

        //Step 1: Find the longest non-decreasing prefix
        int left = 0;
        while (left + 1 < N && arr[left] <= arr[left + 1]) {
            left++;
        }

        //If the entire array is already sorted
        if (left == N - 1) {
            return 0;
        }

        //Step 2: Find the longest non-decreasing suffix
        int right = N - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        //Step 3: Find the minimum length to remove by comparing prefix and suffix
        int result = Math.min(N - left - 1, right);

        //Step 4: use two pointers to find the smallest middle part to remove
        int i = 0, j = right;
        while (i <= left && j < N) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}