class Solution {
    public int minimumLength(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        for (int freq : map.values()) {
            if (freq % 2 == 1) {
                count += freq - 1;
            } else {
                count += freq - 2;
            }
        }

        return s.length() - count;
    }
}