import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CancellationService {

    private Stack<String> releasedRoomIds;
    private Map<String, String> reservationRoomTypeMap;

    public CancellationService() {
        releasedRoomIds = new Stack<>();
        reservationRoomTypeMap = new HashMap<>();
    }

    public void registerBooking(String reservationId, String roomType) {
        reservationRoomTypeMap.put(reservationId, roomType);
    }

    public void cancelBooking(String reservationId,
                              RoomInventory inventory) {

        if (!reservationRoomTypeMap.containsKey(reservationId)) {
            System.out.println("Cancellation failed. Reservation not found.");
            return;
        }

        String roomType = reservationRoomTypeMap.get(reservationId);

        releasedRoomIds.push(reservationId);

        Integer current =
                inventory.getRoomAvailability().get(roomType);

        // ⭐ VERY IMPORTANT NULL CHECK
        if (current == null) {
            System.out.println("Inventory mismatch error. Invalid room type.");
            return;
        }

        inventory.updateAvailability(roomType, current + 1);

        reservationRoomTypeMap.remove(reservationId);

        System.out.println(
                "Booking cancelled successfully. Inventory restored for room type: "
                        + roomType
        );
    }

    public void showRollbackHistory() {

        System.out.println("Rollback History (Most Recent First):");

        while (!releasedRoomIds.isEmpty()) {
            System.out.println(
                    "Released Reservation ID: "
                            + releasedRoomIds.pop()
            );
        }
    }
}