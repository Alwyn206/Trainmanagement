import java.util.ArrayList;
import java.util.List;

/**
 * =======================================================
 * MAIN CLASS - UseCase12TrainConsistMgmnt
 * =======================================================
 *
 * Use Case 12: Safety Compliance Check for Goods Bogies
 *
 * Description:
 * This class validates train consist safety compliance using
 * Stream's allMatch(). Validates that any Cylindrical bogies
 * ONLY carry "Petroleum" cargo.
 *
 * @author Developer
 * @version 12.0
 */
public class UseCase12TrainConsistMgmnt {

    static class GoodsBogie {
        String type;
        String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return type + " carrying " + cargo;
        }
    }

    public static boolean checkSafetyCompliance(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC12 - Safety Compliance Check");
        System.out.println("========================================");
        System.out.println();

        runTests();

        System.out.println("UC12 validation completed...");
    }

    private static void runTests() {
        System.out.println("--- Running Test Cases ---");

        // Test Case 1: All Bogies Valid
        List<GoodsBogie> test1 = new ArrayList<>();
        test1.add(new GoodsBogie("Cylindrical", "Petroleum"));
        test1.add(new GoodsBogie("Box", "Coal"));
        boolean res1 = checkSafetyCompliance(test1);
        System.out.println("testSafety_AllBogiesValid: " + (res1 ? "Passed" : "Failed"));

        // Test Case 2: Cylindrical with Invalid Cargo
        List<GoodsBogie> test2 = new ArrayList<>();
        test2.add(new GoodsBogie("Cylindrical", "Coal"));
        boolean res2 = !checkSafetyCompliance(test2);
        System.out.println("testSafety_CylindricalWithInvalidCargo: " + (res2 ? "Passed" : "Failed"));

        // Test Case 3: Non-Cylindrical Bogies Allowed
        List<GoodsBogie> test3 = new ArrayList<>();
        test3.add(new GoodsBogie("Open", "Coal"));
        test3.add(new GoodsBogie("Box", "Grain"));
        boolean res3 = checkSafetyCompliance(test3);
        System.out.println("testSafety_NonCylindricalBogiesAllowed: " + (res3 ? "Passed" : "Failed"));

        // Test Case 4: Mixed Bogies With Violation
        List<GoodsBogie> test4 = new ArrayList<>();
        test4.add(new GoodsBogie("Cylindrical", "Petroleum"));
        test4.add(new GoodsBogie("Box", "Grain"));
        test4.add(new GoodsBogie("Cylindrical", "Iron Ore")); // Violation
        boolean res4 = !checkSafetyCompliance(test4);
        System.out.println("testSafety_MixedBogiesWithViolation: " + (res4 ? "Passed" : "Failed"));

        // Test Case 5: Empty Bogie List
        List<GoodsBogie> test5 = new ArrayList<>();
        boolean res5 = checkSafetyCompliance(test5);
        System.out.println("testSafety_EmptyBogieList: " + (res5 ? "Passed" : "Failed"));
        System.out.println("--------------------------\n");
    }
}
