/**
 *
 * MAIN CLASS
 *
 * Use Case 11: Concurrent Booking Simulation
 *
 * Description:
 * Simulates multiple users booking rooms
 * at the same time using threads.
 */

public class UseCase11ConcurrentBookingSimulation {

    public static void main(String[] args) {

        System.out.println("Concurrent Booking Simulation");

        RoomInventory inventory = new RoomInventory();

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        RoomAllocationService allocationService =
                new RoomAllocationService();

        /* Add booking requests */
        bookingQueue.enqueueRequest(new Reservation("Abhi", "Single"));
        bookingQueue.enqueueRequest(new Reservation("Vanmathi", "Double"));
        bookingQueue.enqueueRequest(new Reservation("Kural", "Suite"));
        bookingQueue.enqueueRequest(new Reservation("Subha", "Single"));

        /* Create threads */
        Thread t1 = new Thread(
                new ConcurrentBookingProcessor(
                        bookingQueue,
                        inventory,
                        allocationService
                )
        );

        Thread t2 = new Thread(
                new ConcurrentBookingProcessor(
                        bookingQueue,
                        inventory,
                        allocationService
                )
        );

        /* Start concurrent processing */
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread execution interrupted.");
        }

        /* Display remaining inventory */
        System.out.println("Remaining Inventory:");

        System.out.println("Single: " +
                inventory.getRoomAvailability().get("Single"));

        System.out.println("Double: " +
                inventory.getRoomAvailability().get("Double"));

        System.out.println("Suite: " +
                inventory.getRoomAvailability().get("Suite"));
    }
}