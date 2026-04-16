import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * =======================================================
 * MAIN CLASS - UseCase13TrainConsistMgmnt
 * =======================================================
 *
 * Use Case 13: Performance Comparison (Loops vs Streams)
 *
 * Description:
 * This class benches performance of traditional loop-based
 * collection filtering against functional Stream pipelines
 * using System.nanoTime().
 *
 * @author Developer
 * @version 13.0
 */
public class UseCase13TrainConsistMgmnt {

    static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static List<Bogie> filterWithLoop(List<Bogie> bogies) {
        List<Bogie> filtered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                filtered.add(b);
            }
        }
        return filtered;
    }

    public static List<Bogie> filterWithStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC13 - Performance Comparison ");
        System.out.println("========================================");
        System.out.println();

        // Create a large dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            bogies.add(new Bogie("Generic", (i % 100) + 1));
        }

        System.out.println("Dataset created: 1,000,000 bogies.");

        // Loop execution
        long startLoop = System.nanoTime();
        List<Bogie> loopFiltered = filterWithLoop(bogies);
        long endLoop = System.nanoTime();
        long loopDuration = endLoop - startLoop;
        
        System.out.println("Loop-based filter count: " + loopFiltered.size());
        System.out.println("Loop Exec Time (ns):   " + loopDuration);

        // Stream execution
        long startStream = System.nanoTime();
        List<Bogie> streamFiltered = filterWithStream(bogies);
        long endStream = System.nanoTime();
        long streamDuration = endStream - startStream;

        System.out.println("Stream-based filter count: " + streamFiltered.size());
        System.out.println("Stream Exec Time (ns): " + streamDuration);

        System.out.println();
        System.out.println("UC13 comparison completed...");
    }
}
