class Solution {
    public int minSwaps(int[] nums) {
        int k = 0;
        //Counting all the 1's in the array
        //Since the array is a binary array
        //the values will be either 0 or 1
        //So we can simply add all the values of nums
        //That will give us the count of 1's directly
        //This will also give us the window size
        for (int num : nums)  {
            k += num;
        }

        int N = nums.length;
        int count = 0;
        //Now we want to see how many 1's are there
        //in the first window size
        for (int i = 0; i < k; i++) {
            count += nums[i];
        }

        int max = count;
        //Now we will check what is the maximum number of 1's
        //In all the possible windows of nums of size k
        //We are going beyond 'n'
        //until n + k because the question says
        //that the array is a circular array
        for (int i = k; i < N + k; i++) {
            //Adding the new index that enters the window
            //And subtracting the index that leaves the window
            //Adding and subtracting only works because this is a binary array
            //Else we will have to check whether the going out and the coming in number
            //Is the same number that we want to keep a count of
            count += nums[i % N] - nums[(i - k + N) % N];
            max = Math.max(max, count);
        } 
        //Final answer is the total number of 1's found in the entire array
        //minus the maximum number of 1's found in a single window
        //as we want to calculate the minimum number of swaps
        return k - max;       
    }
}