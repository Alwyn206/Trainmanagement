import java.util.Arrays;

/**
 * =======================================================
 * MAIN CLASS - UseCase17TrainConsistMgmnt
 * =======================================================
 *
 * Use Case 17: Sort Bogie Names Using Arrays.sort()
 *
 * Description:
 * Sorts bogie type names alphabetically using Java's built-in Arrays.sort() method.
 */
public class UseCase17TrainConsistMgmnt {

    /**
     * Sorts the given array of bogie names alphabetically using Arrays.sort().
     * 
     * @param names The array of bogie names to sort.
     */
    public static void sortBogieNames(String[] names) {
        if (names == null || names.length <= 1) {
            return;
        }
        Arrays.sort(names);
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("========================================");

        String[] names = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        
        System.out.println("Unsorted array: " + Arrays.toString(names));

        sortBogieNames(names);

        System.out.println("Sorted array: " + Arrays.toString(names));
        
        System.out.println("UC17 validation completed.");
    }
}
