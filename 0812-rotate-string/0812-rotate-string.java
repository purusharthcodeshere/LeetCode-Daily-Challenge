class Solution {
    public boolean rotateString(String s, String goal) {
        String str = goal + goal;
        return s.length() <= goal.length() && str.contains(s);
    }
}