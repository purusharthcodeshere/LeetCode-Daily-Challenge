class Solution {
    public String largestNumber(int[] nums) {
        //Convert the integers to String
        String[] stringNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            stringNums[i] = String.valueOf(nums[i]);
        }

        //Sort using comparator
        Arrays.sort(stringNums, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String order1 = x + y;
                String order2 = y + x;
                //Sort is descending order
                return order2.compareTo(order1);
            }
        });

        //If the largest number is "0", return "0"
        if (stringNums[0].equals("0")) {
            return "0";
        }

        //Concatenate the sorted numbers to fomr the largest number
        StringBuilder ans = new StringBuilder();
        for (String num : stringNums) {
            ans.append(num);
        }

        return ans.toString();
    }
}