import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * =======================================================
 * MAIN CLASS - UseCase8TrainConsistMgmnt
 * =======================================================
 *
 * Use Case 8: Filter Passenger Bogies Using Streams
 *
 * Description:
 * This class filters passenger bogies based on seating
 * capacity using Java Streams.
 *
 * At this stage, the application:
 * - Creates bogie objects
 * - Stores them in a list
 * - Creates a stream from the list using stream()
 * - Applies filter(b -> b.capacity > 60)
 * - Collects the result into a new list
 * - Displays the filtered bogies
 *
 * @author Developer
 * @version 8.0
 */
public class UseCase8TrainConsistMgmnt {

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
        System.out.println("UC8 - Filter Bogies Using Streams");
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

        // Apply filter(b -> b.capacity > 60) as the condition
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        System.out.println("Filtered Bogies (Capacity > 60):");
        for (Bogie b : filteredBogies) {
            System.out.println(b);
        }
        System.out.println();

        System.out.println("UC8 filtering completed...");
    }
}
