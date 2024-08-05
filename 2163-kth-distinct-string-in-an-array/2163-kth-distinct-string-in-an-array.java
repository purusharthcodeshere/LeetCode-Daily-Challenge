class Solution {
    public String kthDistinct(String[] arr, int k) {

        HashMap <String, Integer> map = new HashMap <String, Integer> ();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int count = 0;
        for (String str : arr) {
            if (map.get(str) == 1) {
                count++;
            }

            if (count == k) {
                return str;
            }
        }

        return "";
    }
}