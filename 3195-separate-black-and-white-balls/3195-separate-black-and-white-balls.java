class Solution {
    public long minimumSteps(String s) {
        long white = 0;
        long result = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                result += white;
            } else if (c == '1') {
                white++;
            }
        }

        return result;
    }
}