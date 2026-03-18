import java.util.LinkedList;
import java.util.Queue;

public class BookingRequestQueue {

    private Queue<Reservation> queue;

    public BookingRequestQueue() {
        queue = new LinkedList<>();
    }

    /* ===== UC5 METHODS ===== */

    public void addRequest(Reservation reservation) {
        queue.offer(reservation);
    }

    public boolean hasPendingRequests() {
        return !queue.isEmpty();
    }

    public Reservation getNextRequest() {
        return queue.poll();
    }

    /* ===== UC11 METHODS (Wrapper methods) ===== */

    public void enqueueRequest(Reservation reservation) {
        addRequest(reservation);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public Reservation dequeueRequest() {
        return getNextRequest();
    }
}