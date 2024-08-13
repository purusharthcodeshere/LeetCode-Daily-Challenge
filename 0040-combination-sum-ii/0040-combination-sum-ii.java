class Solution {
    int[] candidates;
    int N;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.candidates = candidates;
        this.N = candidates.length;
        Arrays.sort(candidates);

        List<List<Integer>> combinations = new ArrayList<>();
        
        findCombinations(0, target, combinations, new ArrayList<>());
        return combinations;
    }

    private void findCombinations(int index, int target, List<List<Integer>> combinations, List<Integer> list) {
        if (target == 0) {
            combinations.add(new ArrayList <> (list));
            return;
        }

        for (int i = index; i < N; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }

            list.add(candidates[i]);
            findCombinations(i + 1, target - candidates[i], combinations, list);
            list.remove(list.size() - 1);
        }
    }
}