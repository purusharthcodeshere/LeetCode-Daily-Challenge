class Solution {
    int[] nums;
    int N;

    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        this.N = nums.length;
        return depthFirstSearch(0, 0);
        
    }

    private int depthFirstSearch(int index, int currentXOR) {
        //Base Case: When all the elements have been considered
        //Then the index is equal to the length

        if (index == N) {
            return currentXOR;
        }

        //Take nums[index] in the subset
        int take = depthFirstSearch(index + 1, currentXOR ^ nums[index]);
        //Dont take nums[index] in the subset
        int dont = depthFirstSearch(index + 1, currentXOR);

        return take + dont;
    }
}