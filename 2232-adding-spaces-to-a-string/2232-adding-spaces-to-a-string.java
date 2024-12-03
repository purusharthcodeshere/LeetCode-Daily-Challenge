class Solution {
    public String addSpaces(String s, int[] spaces) {
        int start = 0, end = spaces[0];
        int N = spaces.length;

        StringBuilder str = new StringBuilder();
        str.append(s.substring(start, end));
        for (int i = 1; i < N; i++) {
            start = spaces[i - 1];
            end = spaces[i];
            str.append(" ");
            str.append(s.substring(start, end));
        }

        str.append(" ");
        str.append(s.substring(spaces[N - 1]));

        return str.toString();
    }
}