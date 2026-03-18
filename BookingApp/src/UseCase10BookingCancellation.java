/**
 *
 * MAIN CLASS UseCase10BookingCancellation
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * This class demonstrates how confirmed
 * bookings can be cancelled safely.
 *
 * Inventory is restored and rollback
 * history is maintained.
 *
 * @version 10.0
 */

public class UseCase10BookingCancellation {

    /**
     * Application entry point.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("Booking Cancellation");

        RoomInventory inventory = new RoomInventory();

        CancellationService cancellationService =
                new CancellationService();

        // simulate confirmed booking
        String reservationId = "Single-1";
        String roomType = "Single";

        cancellationService.registerBooking(
                reservationId,
                roomType
        );

        // perform cancellation
        cancellationService.cancelBooking(
                reservationId,
                inventory
        );

        cancellationService.showRollbackHistory();

        System.out.println(
                "Updated Single Room Availability: "
                        + inventory.getRoomAvailability().get("Single")
        );
    }
}