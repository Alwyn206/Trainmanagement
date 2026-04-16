import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * =======================================================
 * MAIN CLASS - UseCase9TrainConsistMgmnt
 * =======================================================
 *
 * Use Case 9: Group Bogies by Type (Collectors.groupingBy)
 *
 * Description:
 * This class groups passenger bogies based on their name
 * using Java Streams and Collectors.groupingBy.
 *
 * At this stage, the application:
 * - Creates bogie objects
 * - Stores them in a list
 * - Creates a stream from the list using stream()
 * - Applies Collectors.groupingBy(b -> b.name)
 * - Stores the result in Map<String, List<Bogie>>
 * - Displays the grouped bogies
 *
 * @author Developer
 * @version 9.0
 */
public class UseCase9TrainConsistMgmnt {

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
        System.out.println("UC9 - Group Bogies by Type");
        System.out.println("========================================");
        System.out.println();

        // Create list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();
        
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));
        bogies.add(new Bogie("General", 90));

        System.out.println("Original List:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
        System.out.println();

        // Apply groupingBy
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        System.out.println("Grouped Bogies (by Name):");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Bogie b : entry.getValue()) {
                System.out.println("  " + b);
            }
        }
        System.out.println();

        System.out.println("UC9 grouping completed...");
    }
}
