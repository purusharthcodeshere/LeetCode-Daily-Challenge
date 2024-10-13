class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int currentMax = Integer.MIN_VALUE;
        
        //Initialize the heap with the first element of each list
        for (int i = 0; i < nums.size(); i++) {
            minHeap.offer(new int[]{nums.get(i).get(0), i, 0});
            currentMax = Math.max(currentMax, nums.get(i).get(0));
        }

        int[] smallestRange = new int[]{0, Integer.MAX_VALUE};

        while (true) {
            // Get the minimum element from the heap
            int[] current = minHeap.poll();
            int currentMin = current[0], listIndex = current[1], elementIndex = current[2];

            // Update the smallest range if a better one is found
            if ((currentMax - currentMin < smallestRange[1] - smallestRange[0]) ||
                (currentMax - currentMin == smallestRange[1] - smallestRange[0] && currentMin < smallestRange[0])) {
                smallestRange[0] = currentMin;
                smallestRange[1] = currentMax;
            }

            // Move to the next element in the same list
            if (elementIndex + 1 < nums.get(listIndex).size()) {
                int nextVal = nums.get(listIndex).get(elementIndex + 1);
                minHeap.offer(new int[]{nextVal, listIndex, elementIndex + 1});
                currentMax = Math.max(currentMax, nextVal);
            } else {
                // If any list is exhausted, stop
                break;
            }
        }
        return smallestRange;
    }
}