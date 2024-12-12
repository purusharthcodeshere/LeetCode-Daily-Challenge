class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int gift : gifts) {
            queue.add(gift);
        }

        while (k-- > 0) {
            int gift = queue.poll();
            gift = (int) Math.sqrt(gift);
            queue.add(gift);
        }

        long sum = 0L;
        for (int i = 0; i < gifts.length; i++) {
            sum += queue.poll();
        }

        return sum;
    }
}