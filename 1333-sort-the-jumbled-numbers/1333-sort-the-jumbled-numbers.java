class Solution {

    //Helper Pair class To maintain the pair of
    //current number with its mapped value

    class Pair {
        int num;
        int mappedValue;

        Pair (int num, int mappedValue) {
            this.num = num;
            this.mappedValue = mappedValue;
        }
    }

    public int[] sortJumbled(int[] mapping, int[] nums) {
        int N = nums.length;
        List <Pair> numList = new ArrayList <Pair> ();

        //Creating a list of Pair class
        //By using the getMappedValue function
        //TC: O(log(n))

        for (int num : nums) {
            int mappedValue = getMappedValue(num, mapping);
            numList.add(new Pair(num, mappedValue));
        }

        //Sorting the numList
        //using the mappedValues in ascending order
        //If there is a clash
        //then relative order of nums is maintained by returning 0

        numList.sort((Pair x, Pair y) -> {
            if (x.mappedValue != y.mappedValue) {
                return x.mappedValue - y.mappedValue;
            } else {
                return 0;
            }
        });

        //Instead of creating a new array here
        //Directly converting the ArrayList of Pair class
        //to the int[] by using stream() function
        //and then mapping it to int
        //the parameters in the 'mapToInt' function indicate
        //that we only need to stream the 'num' value stored in Pair class
        //And not the mappedValue
        
        return numList.stream().mapToInt(i -> i.num).toArray();  
    }

    private int getMappedValue(int num, int[] mapping) {
        if (num == 0) {
            return mapping[0];
        }

        int mappedValue = 0;
        int placeValue = 1;

        while (num > 0) {
            int digit = num % 10;
            mappedValue += mapping[digit] * placeValue;
            placeValue *= 10;
            num /= 10;
        }

        return mappedValue;
    }
}