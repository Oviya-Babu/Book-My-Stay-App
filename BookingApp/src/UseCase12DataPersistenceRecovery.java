public class UseCase12DataPersistenceRecovery {

    public static void main(String[] args) {

        System.out.println("System Recovery");

        RoomInventory inventory = new RoomInventory();
        FilePersistenceService persistenceService =
                new FilePersistenceService();

        String filePath = "inventory.txt";

        // STEP 1: Load previous data
        persistenceService.loadInventory(inventory, filePath);

        // STEP 2: Show current inventory
        System.out.println("\nCurrent Inventory:");

        System.out.println("Single: " +
                inventory.getRoomAvailability().get("Single"));

        System.out.println("Double: " +
                inventory.getRoomAvailability().get("Double"));

        System.out.println("Suite: " +
                inventory.getRoomAvailability().get("Suite"));

        // STEP 3: Save inventory
        persistenceService.saveInventory(inventory, filePath);
    }
}