import java.util.LinkedHashSet;
import java.util.Set;

/**
 * =======================================================
 * MAIN CLASS - UseCase5TrainConsistMgmnt
 * =======================================================
 *
 * Use Case 5: Preserve Insertion Order of Bogies
 *
 * Description:
 * This class maintains the exact attachment order of bogies
 * while also preventing duplicate entries using LinkedHashSet.
 *
 * At this stage, the application:
 * - Attaches bogies in order
 * - Preserves insertion sequence
 * - Avoids duplicate bogies
 * - Displays final train formation
 *
 * This maps ordered uniqueness using LinkedHashSet.
 *
 * @author Developer
 * @version 5.0
 */
public class UseCase5TrainConsistMgmnt {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC5 - Preserve Insertion Order of Bogies");
        System.out.println("========================================");
        System.out.println();

        // LinkedHashSet preserves order and ensures uniqueness
        Set<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // Attempting to add a duplicate
        formation.add("Sleeper"); // Will be ignored

        System.out.println("Final Train Formation:");
        System.out.println(formation);
        System.out.println();

        System.out.println("Note:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");
        System.out.println();

        System.out.println("UC5 formation setup completed...");
    }
}
