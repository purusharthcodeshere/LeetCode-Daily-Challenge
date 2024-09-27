class Event {
    int start;
    int end;
    
    public Event(int start, int end) {
        this.start = start;
        this.end = end;
    }  
}

class MyCalendarTwo {
    List<Event> overlapBookings;
    List<Event> bookings;

    public MyCalendarTwo() {
        overlapBookings = new ArrayList<>();
        bookings = new ArrayList<>();        
    }
    
    public boolean book(int start, int end) {

        for (Event event : overlapBookings) {
            if (isOverlapping(event, start, end)) {
                return false;
            }
        }

        for (Event event : bookings) {
            if (isOverlapping(event, start, end)) {
                overlapBookings.add(getOverlapEvent(event, start, end));
            }
        }

        bookings.add(new Event(start, end));

        return true;        
    }

    public boolean isOverlapping(Event event, int start, int end) {
        return Math.max(event.start, start) < Math.min(event.end, end);
    }

    public Event getOverlapEvent(Event event, int start, int end) {
        return new Event(Math.max(event.start, start), Math.min(event.end, end));
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */