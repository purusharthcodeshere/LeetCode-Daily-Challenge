class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < Math.min(10, n + 1); i++) {
            ans.add(i);
            helper(i, n, ans);
        }
        return ans;
    }

    private void helper(int i, int n, List<Integer> ans) {
        for (int x = i * 10; x <= Math.min(((i * 10) + 9), n); x++) {
            ans.add(x);
            helper(x, n, ans);
        }
    }
}