/**
 * =======================================================
 * MAIN CLASS - UseCase18TrainConsistMgmnt
 * =======================================================
 *
 * Use Case 18: Linear Search for Bogie ID (Array-Based Searching)
 *
 * Description:
 * Search and identify a specific bogie ID from an unsorted list using Linear Search.
 */
public class UseCase18TrainConsistMgmnt {

    /**
     * Performs a linear search to find a specific bogie ID in the given array.
     * 
     * @param bogieIds The array of bogie IDs to search within.
     * @param targetId The bogie ID to search for.
     * @return true if the ID is found, false otherwise.
     */
    public static boolean searchBogieID(String[] bogieIds, String targetId) {
        if (bogieIds == null || targetId == null) {
            return false;
        }
        for (int i = 0; i < bogieIds.length; i++) {
            if (bogieIds[i].equals(targetId)) {
                return true; // Match found, early termination
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC18 - Linear Search for Bogie ID");
        System.out.println("========================================");

        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        String searchKey = "BG309";
        
        System.out.print("Array List: {");
        for (int i = 0; i < bogieIds.length; i++) {
            System.out.print("\"" + bogieIds[i] + "\"");
            if (i < bogieIds.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
        
        System.out.println("Search Key: " + searchKey);

        boolean isFound = searchBogieID(bogieIds, searchKey);

        if (isFound) {
            System.out.println("Result: Bogie ID " + searchKey + " exists in the consist.");
        } else {
            System.out.println("Result: Bogie ID " + searchKey + " does not exist in the consist.");
        }
        
        System.out.println("UC18 validation completed.");
    }
}
