class Solution {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer, Integer> valueToRank = new HashMap<>();
        int[] sortedNumbers = Arrays.stream(arr).distinct().sorted().toArray();

        for (int i = 0; i < sortedNumbers.length; i++) {
            valueToRank.put(sortedNumbers[i], i + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = valueToRank.get(arr[i]);
        }

        return arr;
    }
}