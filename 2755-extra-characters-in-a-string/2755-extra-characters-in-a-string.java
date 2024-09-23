class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        HashSet<String> set = new HashSet<>();
        
        for (String word : dictionary) {
            set.add(word);
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, set, s, dp);
    }

    int solve (int index, HashSet<String> set, String s, int[] dp) {
        if (index >= s.length()) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int ans = Integer.MAX_VALUE;

        String sub = "";
        for (int i = 0; i + index < s.length(); i++) {
            sub = s.substring(index, index + i + 1);

            if (set.contains(sub)){
                ans = Math.min(ans, solve(index + i + 1, set, s, dp));
            }
            ans = Math.min(ans, i + 1 + solve(index+i+1, set, s, dp));
        } 

        return dp[index] = ans;
    }


}