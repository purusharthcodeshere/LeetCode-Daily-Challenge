class MyCalendar {
    TreeMap<Integer, Integer> calendar = new TreeMap<>();

    public MyCalendar() {
        calendar.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> pair = calendar.higherEntry(start);
        boolean result = end <= pair.getValue();
        if (result) {
            calendar.put(end, start);
        }

        return result;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */