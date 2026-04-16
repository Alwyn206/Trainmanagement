import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * =======================================================
 * MAIN CLASS - UseCase11TrainConsistMgmnt
 * =======================================================
 *
 * Use Case 11: Validate Train ID & Cargo Codes (Regex)
 *
 * Description:
 * This class applies Regular Expressions to validate exactly
 * formatted Train IDs and Cargo Codes to ensure data integrity
 * before downstream operations.
 *
 * At this stage, the application:
 * - Defines regex patterns (e.g. TRN-\d{4})
 * - Compiles Pattern objects
 * - Receives Input (hard-coded for demonstration)
 * - Evaluates formats using Matcher.matches()
 * - Flags inputs as valid or invalid
 *
 * @author Developer
 * @version 11.0
 */
public class UseCase11TrainConsistMgmnt {

    private static final String TRAIN_ID_REGEX = "^TRN-\\d{4}$";
    private static final String CARGO_CODE_REGEX = "^PET-[A-Z]{2}$";

    public static boolean validateTrainId(String trainId) {
        if (trainId == null) return false;
        Pattern pattern = Pattern.compile(TRAIN_ID_REGEX);
        Matcher matcher = pattern.matcher(trainId);
        return matcher.matches();
    }

    public static boolean validateCargoCode(String cargoCode) {
        if (cargoCode == null) return false;
        Pattern pattern = Pattern.compile(CARGO_CODE_REGEX);
        Matcher matcher = pattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC11 - Validate input formats (Regex)");
        System.out.println("========================================");
        System.out.println();

        String train1 = "TRN-1234";
        String train2 = "TRAIN12"; // Invalid
        
        String cargo1 = "PET-AB";
        String cargo2 = "PET123"; // Invalid

        System.out.println("Validating Train IDs:");
        System.out.println(train1 + " -> " + (validateTrainId(train1) ? "Valid" : "Invalid"));
        System.out.println(train2 + " -> " + (validateTrainId(train2) ? "Valid" : "Invalid"));
        System.out.println();

        System.out.println("Validating Cargo Codes:");
        System.out.println(cargo1 + " -> " + (validateCargoCode(cargo1) ? "Valid" : "Invalid"));
        System.out.println(cargo2 + " -> " + (validateCargoCode(cargo2) ? "Valid" : "Invalid"));
        System.out.println();

        System.out.println("UC11 validation completed...");
    }
}
