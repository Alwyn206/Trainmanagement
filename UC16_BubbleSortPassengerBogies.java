/**
 * =======================================================
 * MAIN CLASS - UseCase16TrainConsistMgmnt
 * =======================================================
 *
 * Use Case 16: Sort Passenger Bogies by Capacity (Bubble Sort)
 *
 * Description:
 * Sorts passenger bogie capacities using a basic comparison-based 
 * Bubble Sort algorithm instead of library methods like Arrays.sort().
 *
 * @author Developer
 */
public class UseCase16TrainConsistMgmnt {

    /**
     * Sorts the given array of capacities using the Bubble Sort algorithm.
     * 
     * @param capacities The array of capacities to sort.
     */
    public static void sortPassengerBogieCapacities(int[] capacities) {
        if (capacities == null || capacities.length <= 1) {
            return;
        }
        int n = capacities.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (capacities[j] > capacities[j + 1]) {
                    // Swap values when the left element is greater than the right element
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC16 - Sort Passenger Bogies by Capacity");
        System.out.println("========================================");

        int[] capacities = {72, 56, 24, 70, 60};
        
        System.out.print("Unsorted array: ");
        printArray(capacities);

        sortPassengerBogieCapacities(capacities);

        System.out.print("Sorted array: ");
        printArray(capacities);
        
        System.out.println("UC16 validation completed.");
    }
    
    public static void printArray(int[] arr) {
        System.out.print("{");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}
