/**
 * =======================================================
 * MAIN CLASS - UseCase20TrainConsistMgmnt
 * =======================================================
 *
 * Use Case 20: Exception Handling During Search Operations
 *
 * Description:
 * Prevent search operations on an empty train by throwing an exception early.
 */
public class UseCase20TrainConsistMgmnt {

    /**
     * Performs a search using defensive programming to validate state.
     * Throws an IllegalStateException if the array is empty.
     * 
     * @param bogieIds The array of bogie IDs to search within.
     * @param targetId The bogie ID to search for.
     * @return true if the ID is found, false otherwise.
     * @throws IllegalStateException if bogieIds is null or empty.
     */
    public static boolean searchBogieID(String[] bogieIds, String targetId) {
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("Search failed: The train bogie collection is empty.");
        }
        
        if (targetId == null) {
            return false;
        }

        for (String id : bogieIds) {
            if (id.equals(targetId)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC20 - Exception Handling During Search");
        System.out.println("========================================");

        try {
            System.out.println("Trying to search in an empty array...");
            String[] emptyIds = {};
            searchBogieID(emptyIds, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("Caught Expected Exception: " + e.getMessage());
        }

        System.out.println("\nTrying to search in a valid array...");
        String[] validIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        boolean found = searchBogieID(validIds, "BG309");
        System.out.println("Is 'BG309' found? " + found);
        
        System.out.println("UC20 validation completed.");
    }
}
