class Solution {
    public int slidingPuzzle(int[][] board) {
        //Directions for possible swaps based on '0' position
        int[][] directions = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        String target = "123450";
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        String start = "";

        //Convert 2D board to a single string
        for (int[] row : board) {
            for (int col : row) {
                start += col;
            }
        } 

        queue.offer(start);
        visited.add(start);
        int step = 0;

        //Start BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String current = queue.poll();

                //Check if the target is reached
                if (current.equals(target)) return step;

                //Find the position of '0'
                int zero = current.indexOf('0');

                //Generate next moves
                for (int move : directions[zero]) {
                    StringBuilder next = new StringBuilder(current);
                    char temp = next.charAt(zero);
                    next.setCharAt(zero, next.charAt(move));
                    next.setCharAt(move, temp);

                    if (!visited.contains(next.toString())) {
                        visited.add(next.toString());
                        queue.offer(next.toString());
                    }
                }
            }

            step++;
        }

        //Return -1 if the target is unreachable
        return -1;
    }
}