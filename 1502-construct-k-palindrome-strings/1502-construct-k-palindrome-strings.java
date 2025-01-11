class Solution {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;

        int bitmask = 0;
        for (char c : s.toCharArray()) {
            bitmask ^= (1 << (c - 'a'));
        }

        int oddCount = Integer.bitCount(bitmask);
        return oddCount <= k;
    }
}