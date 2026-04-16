/**
 * =======================================================
 * MAIN CLASS - UseCase15TrainConsistMgmnt
 * =======================================================
 *
 * Use Case 15: Safe Cargo Assignment Using try-catch-finally
 *
 * Description:
 * This class applies RuntimeExceptions wrapping them inside
 * structured try/catch blocks ensuring safe ongoing program
 * flows and triggering finally hooks logging evaluations.
 *
 * @author Developer
 * @version 15.0
 */
public class UseCase15TrainConsistMgmnt {

    public static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    static class GoodsBogie {
        String shape;
        String cargo;

        public GoodsBogie(String shape) {
            this.shape = shape;
        }

        public void assignCargo(String assignedCargo) {
            if ("Rectangular".equalsIgnoreCase(this.shape) && "Petroleum".equalsIgnoreCase(assignedCargo)) {
                throw new CargoSafetyException("Unsafe Assignment: Cannot assign Petroleum to a Rectangular bogie.");
            }
            this.cargo = assignedCargo;
            System.out.println("Cargo successfully assigned: " + assignedCargo + " to " + this.shape + " bogie.");
        }
    }

    public static void processCargoAssignment(GoodsBogie bogie, String cargo) {
        System.out.println("\nAttempting to assign " + cargo + " to a " + bogie.shape + " bogie...");
        try {
            bogie.assignCargo(cargo);
        } catch (CargoSafetyException e) {
            System.err.println("Exception Caught: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed: Cargo assignment process completed.");
        }
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC15 - Safe Cargo Assignment (try-catch)");
        System.out.println("========================================");

        GoodsBogie cylindricalBogie = new GoodsBogie("Cylindrical");
        GoodsBogie rectangularBogie = new GoodsBogie("Rectangular");

        // Safe Assignment
        processCargoAssignment(cylindricalBogie, "Petroleum");

        // Unsafe Assignment - Caught and Handled
        processCargoAssignment(rectangularBogie, "Petroleum");

        System.out.println("\nProgram continues safely after exception handling...");
        System.out.println("UC15 validation completed.");
    }
}
