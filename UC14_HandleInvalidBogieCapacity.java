/**
 * =======================================================
 * MAIN CLASS - UseCase14TrainConsistMgmnt
 * =======================================================
 *
 * Use Case 14: Handle Invalid Bogie Capacity (Custom Exception)
 *
 * Description:
 * This class validates data directly inside constructor 
 * parameters utilizing fail-fast validation by terminating 
 * instantly and throwing checked custom exceptions.
 *
 * @author Developer
 * @version 14.0
 */
public class UseCase14TrainConsistMgmnt {

    public static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
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
        System.out.println("UC14 - Handle Invalid Bogie Capacity");
        System.out.println("========================================");
        System.out.println();

        try {
            System.out.println("Attempting to create valid Bogie...");
            Bogie b1 = new Bogie("Sleeper", 72);
            System.out.println("Success: " + b1);

            System.out.println("\nAttempting to create INVALID Bogie...");
            Bogie b2 = new Bogie("AC Chair", -5); // Throws exception immediately
            System.out.println("Success: " + b2); // Will not reach here
        } catch (InvalidCapacityException e) {
            System.err.println("Exception Caught: " + e.getMessage());
        }

        System.out.println("\nUC14 validation completed...");
    }
}
