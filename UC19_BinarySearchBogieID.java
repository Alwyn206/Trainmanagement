import java.util.Arrays;

/**
 * =======================================================
 * MAIN CLASS - UseCase19TrainConsistMgmnt
 * =======================================================
 *
 * Use Case 19: Binary Search for Bogie ID (Optimized Searching)
 *
 * Description:
 * Find a bogie ID efficiently using binary search on sorted data.
 */
public class UseCase19TrainConsistMgmnt {

    /**
     * Performs a binary search to find a specific bogie ID in the given array.
     * Ensures the array is sorted before performing the search.
     * 
     * @param bogieIds The array of bogie IDs to search within.
     * @param targetId The bogie ID to search for.
     * @return true if the ID is found, false otherwise.
     */
    public static boolean binarySearchBogieID(String[] bogieIds, String targetId) {
        if (bogieIds == null || bogieIds.length == 0 || targetId == null) {
            return false;
        }
        
        // Ensure data is sorted before binary search
        Arrays.sort(bogieIds);
        
        int low = 0;
        int high = bogieIds.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = bogieIds[mid].compareTo(targetId);
            
            if (cmp == 0) {
                return true; // Match found
            } else if (cmp < 0) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }
        return false; // Not found
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC19 - Binary Search for Bogie ID");
        System.out.println("========================================");

        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        String searchKey = "BG309";
        
        System.out.println("Original Array List: " + Arrays.toString(bogieIds));
        System.out.println("Search Key: " + searchKey);

        boolean isFound = binarySearchBogieID(bogieIds, searchKey);

        System.out.println("Sorted Array List: "  + Arrays.toString(bogieIds));

        if (isFound) {
            System.out.println("Result: Bogie ID " + searchKey + " exists in the consist.");
        } else {
            System.out.println("Result: Bogie ID " + searchKey + " does not exist in the consist.");
        }
        
        System.out.println("UC19 validation completed.");
    }
}
