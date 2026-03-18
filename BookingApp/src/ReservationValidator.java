/**
 *
 * CLASS ReservationValidator
 *
 * Use Case 9: Error Handling & Validation
 *
 * Description:
 * This class is responsible for validating
 * booking requests before they are processed.
 *
 * @version 9.0
 */

public class ReservationValidator {

    /**
     * Validates booking input provided by the user.
     *
     * @param guestName name of the guest
     * @param roomType requested room type
     * @param inventory centralized inventory
     * @throws InvalidBookingException if validation fails
     */
    public void validate(
            String guestName,
            String roomType,
            RoomInventory inventory
    ) throws InvalidBookingException {

        // validate guest name
        if (guestName == null || guestName.trim().isEmpty()) {
            throw new InvalidBookingException(
                    "Guest name cannot be empty."
            );
        }

        // validate room type (case sensitive)
        if (!inventory.getRoomAvailability().containsKey(roomType)) {
            throw new InvalidBookingException(
                    "Invalid room type selected."
            );
        }

        // validate availability
        int available =
                inventory.getRoomAvailability().get(roomType);

        if (available <= 0) {
            throw new InvalidBookingException(
                    "Selected room type is not available."
            );
        }
    }
}