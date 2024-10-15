class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int N = A.length;
        int M = B.length;

        if (M < N) {
            return findMedianSortedArrays(B, A);
        }

        int totalLength = N + M;
        int halfLength = (totalLength + 1) / 2;

        int left = 0;
        int right = Math.min(N, halfLength);

        while (left <= right) {

            int mid = left + (right - left) / 2;
            //Mid is equal to the number of elements to be taken from A
            int takeB = halfLength - mid;
            
            int left1 = (mid == 0) ? Integer.MIN_VALUE : A[mid - 1];
            int left2 = (takeB == 0) ? Integer.MIN_VALUE : B[takeB - 1];
            int right1 = (mid == N) ? Integer.MAX_VALUE : A[mid];
            int right2 = (takeB == M) ? Integer.MAX_VALUE : B[takeB];

            if (left1 <= right2 && left2 <= right1) {
                //Partition is correct
                int l = Math.max(left1, left2);
                int r = Math.min(right1, right2);

                if (totalLength % 2 == 0) {
                    return (l + r) / 2.0;
                } else {
                    return l;
                }
            } else if (left1 > right2) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1.0;
    }
}