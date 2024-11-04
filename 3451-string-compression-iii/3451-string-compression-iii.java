class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int count = 1, N = word.length();
        char c = word.charAt(0);
        for (int i = 1; i < N; i++) {
            if (word.charAt(i) == c && count < 9) {
                count++;
            } else {
                comp.append(count).append(c);
                c = word.charAt(i);
                count = 1;
            }
        }
        comp.append(count).append(c);
        return comp.toString();
    }
}