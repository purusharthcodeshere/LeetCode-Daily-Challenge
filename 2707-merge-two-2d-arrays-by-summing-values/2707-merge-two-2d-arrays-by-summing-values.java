class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int N = nums1.length;
        int M = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int id = nums1[i][0];
            int val = nums1[i][1];
            map.put(id, val);
        }

        for (int j = 0; j < M; j++) {
            int id = nums2[j][0];
            int val = nums2[j][1];
            map.put(id, map.getOrDefault(id, 0) + val);
        }

        int[][] mergedArray = new int[map.size()][2];

        int i = 0, j = 0, k = 0;

        while (i < N && j < M) {
            if (nums1[i][0] < nums2[j][0]) {
                mergedArray[k][0] = nums1[i][0];
                mergedArray[k][1] = map.get(nums1[i][0]);
                i++;
            } else if (nums2[j][0] < nums1[i][0]) {
                mergedArray[k][0] = nums2[j][0];
                mergedArray[k][1] = map.get(nums2[j][0]);
                j++;
            } else {
                mergedArray[k][0] = nums1[i][0];
                mergedArray[k][1] = map.get(nums1[i][0]);
                i++;
                j++;
            }

            k++;
        }

        while (i < N && k < N + M) {
            mergedArray[k][0] = nums1[i][0];
            mergedArray[k][1] = map.get(nums1[i][0]);
            i++;
            k++;
        }


        while (j < M && k < N + M) {
            mergedArray[k][0] = nums2[j][0];
            mergedArray[k][1] = map.get(nums2[j][0]);
            j++;
            k++;
        }

        return mergedArray;
    }
}