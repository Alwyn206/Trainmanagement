import java.util.ArrayList;
import java.util.List;

/**
 * =======================================================
 * MAIN CLASS - UseCase10TrainConsistMgmnt
 * =======================================================
 *
 * Use Case 10: Count Total Seats in Train (reduce)
 *
 * Description:
 * This class aggregates seating capacities into a single 
 * total value using Stream reduction.
 *
 * At this stage, the application:
 * - Creates bogie objects
 * - Stores them in a list
 * - Creates a stream from the list using stream()
 * - extract capacity using map(b -> b.capacity)
 * - sums the capacities using reduce(0, Integer::sum)
 * - Displays the total seating capacity
 *
 * @author Developer
 * @version 10.0
 */
public class UseCase10TrainConsistMgmnt {

    // Inner Bogie class to model passenger bogies
    static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC10 - Count Total Seats in Train");
        System.out.println("========================================");
        System.out.println();

        // Create list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();
        
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("Original List:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
        System.out.println();

        // Apply stream, map and reduce
        int totalSeatingCapacity = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("Total Seating Capacity: " + totalSeatingCapacity);
        System.out.println();

        System.out.println("UC10 counting completed...");
    }
}
