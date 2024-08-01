class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String person : details) {
            if (Integer.parseInt(person.substring(11, 13)) > 60) {
                count++;
            }
        }

        return count;
    }
}