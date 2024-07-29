class Solution {
    public int numTeams(int[] rating) {
        if (rating.length < 3) {
            return 0;
        }

        int N = rating.length;
        int count = 0;

        //Consider the middle element in a valid 3-element team
        //Then just count all the elements on the left and right
        //That are bigger and smaller respectively
        //The the count of a valid 3-element team will be
        //count += left[smaller] * right[bigger] + left[bigger] * right[smaller]

        for (int i = 1; i < N - 1; i++) {
            int[] left = new int[2];
            int[] right = new int[2];

            //Count rating on the left of i
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    left[1]++;
                } else {
                    left[0]++;
                }
            }

            //Count of rating on the right of i
            for (int k = i + 1; k < N; k++) {
               if (rating[k] < rating[i]) {
                    right[1]++;
                } else {
                    right[0]++;
                }
            }

            count += (left[0] * right[1]) + (left[1] * right[0]);
        }

        return count;
    }
}