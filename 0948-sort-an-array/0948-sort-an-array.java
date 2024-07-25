class Solution {
    public int[] sortArray(int[] nums) {

        mergeSort(nums, 0, nums.length - 1);
        return nums;        
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int N = mid - left + 1;
        int M = right - mid;

        int[] leftArray = new int[N];
        int[] rightArray = new int[M];

        //Copy data to temporary arrays using System.arraycopy

        // System.arraycopy(nums, left, leftArray, 0, N); 
        // Function above copies N elements from nums 
        // starting at index left 
        // to leftArray starting at index 0.
        // last parameter specifies the number of elements

        // System.arraycopy(nums, mid + 1, rightArray, 0, M); 
        // Function above copies M elements from nums 
        // starting at index mid + 1
        // to rightArray starting at index 0.
        // last parameter specifies the number of elements

        System.arraycopy(nums, left, leftArray, 0, N);
        System.arraycopy(nums, mid + 1, rightArray, 0, M);

        //Pointers for left part, right part, and mergedArray, respectively
        int i = 0, j = 0;
        int k = left;

        while (i < N && j < M) {
            if (leftArray[i] <= rightArray[j]) {
                nums[k] = leftArray[i];
                i++;
            } else {
                nums[k] = rightArray[j];
                j++;
            }
            //Pointer for merged will move 
            //irrespecitve of what element comes first
            k++;
        }

        //If there are any remaining elements
        //In either leftArray or rightArray
        //Then put them in nums

        while (i < N) {
            nums[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < M) {
            nums[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private void mergeSort(int[] nums, int left, int right) {
        //Base Condition
        if (left == right) {
            return;
        }

        int mid = left + ((right - left) / 2);

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        merge(nums, left, mid, right);
    }
}