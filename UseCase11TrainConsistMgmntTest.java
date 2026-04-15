import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase11TrainConsistMgmntTest {

    @Test
    public void testRegex_ValidTrainID() {
        assertTrue(UseCase11TrainConsistMgmnt.validateTrainId("TRN-1234"));
    }

    @Test
    public void testRegex_InvalidTrainIDFormat() {
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId("TRAIN12"));
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId("TRN12A"));
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId("1234-TRN"));
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId("TRN-12a4"));
    }

    @Test
    public void testRegex_ValidCargoCode() {
        assertTrue(UseCase11TrainConsistMgmnt.validateCargoCode("PET-AB"));
    }

    @Test
    public void testRegex_InvalidCargoCodeFormat() {
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode("PET-ab"));
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode("PET123"));
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode("AB-PET"));
    }

    @Test
    public void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId("TRN-123"));
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId("TRN-12345"));
    }

    @Test
    public void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode("PET-Ab"));
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode("PET-ab"));
    }

    @Test
    public void testRegex_EmptyInputHandling() {
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId(""));
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode(""));
    }
    
    @Test
    public void testRegex_NullInputHandling() {
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId(null));
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode(null));
    }

    @Test
    public void testRegex_ExactPatternMatch() {
        // Matches should check the entire string rather than partial.
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId("TRN-1234-EXTRA"));
        assertFalse(UseCase11TrainConsistMgmnt.validateTrainId("EXTRA-TRN-1234"));
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode("PET-ABC"));
        assertFalse(UseCase11TrainConsistMgmnt.validateCargoCode("APET-AB"));
    }
}
