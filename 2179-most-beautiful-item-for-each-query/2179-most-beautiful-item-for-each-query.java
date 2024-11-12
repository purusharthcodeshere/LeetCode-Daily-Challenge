class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int max = Integer.MAX_VALUE;
        List<int[]> result = new ArrayList<>();
        result.add(new int[] {0, 0, max});

        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));

        for (int[] item : items) {
            int price = item[0];
            int beauty = item[1];
            int[] lastBracket = result.get(result.size() - 1);

            if (beauty > lastBracket[1]) {
                lastBracket[2] = price;
                result.add(new int[] {price, beauty, max});
            }
        }

        int[] ans = new int[queries.length];

        for (int j = 0; j < queries.length; j++) {
            int x = queries[j];
            for (int i = result.size() - 1; i >= 0; i--) {
                if (result.get(i)[0] <= x) {
                    ans[j] = result.get(i)[1];
                    break;
                }
            }
        }

        return ans;
    }
}