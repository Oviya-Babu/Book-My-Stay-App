/**
 *
 * CLASS ConcurrentBookingProcessor
 *
 * Use Case 11: Concurrent Booking Simulation
 *
 * Description:
 * This class represents a booking processor
 * that can be executed by multiple threads.
 *
 * It demonstrates how shared resources
 * such as booking queues and inventory
 * must be accessed in a thread-safe manner.
 *
 * @version 11.0
 */

public class ConcurrentBookingProcessor implements Runnable {

    /** Shared booking request queue */
    private BookingRequestQueue bookingQueue;

    /** Shared room inventory */
    private RoomInventory inventory;

    /** Shared room allocation service */
    private RoomAllocationService allocationService;

    /**
     * Constructor
     */
    public ConcurrentBookingProcessor(
            BookingRequestQueue bookingQueue,
            RoomInventory inventory,
            RoomAllocationService allocationService
    ) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    /**
     * Executed when thread starts
     */
    @Override
    public void run() {

        while (true) {

            Reservation reservation;

            /*
             * Only one thread can access the queue
             * at a time to retrieve a booking request
             */
            synchronized (bookingQueue) {

                if (bookingQueue.isEmpty()) {
                    break;
                }

                reservation = bookingQueue.dequeueRequest();
            }

            /*
             * Allocation modifies shared inventory
             * so it must also be synchronized
             */
            synchronized (inventory) {
                allocationService.allocateRoom(reservation, inventory);
            }
        }
    }
}