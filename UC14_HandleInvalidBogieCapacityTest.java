import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase14TrainConsistMgmntTest {

    @Test
    public void testException_ValidCapacityCreation() {
        assertDoesNotThrow(() -> {
            UseCase14TrainConsistMgmnt.Bogie b = new UseCase14TrainConsistMgmnt.Bogie("Sleeper", 70);
            assertNotNull(b);
        });
    }

    @Test
    public void testException_NegativeCapacityThrowsException() {
        assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmnt.Bogie("Sleeper", -10);
        });
    }

    @Test
    public void testException_ZeroCapacityThrowsException() {
        assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmnt.Bogie("Sleeper", 0);
        });
    }

    @Test
    public void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(UseCase14TrainConsistMgmnt.InvalidCapacityException.class, () -> {
            new UseCase14TrainConsistMgmnt.Bogie("Sleeper", 0);
        });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    public void testException_ObjectIntegrityAfterCreation() {
        assertDoesNotThrow(() -> {
            UseCase14TrainConsistMgmnt.Bogie b = new UseCase14TrainConsistMgmnt.Bogie("Sleeper", 72);
            assertEquals("Sleeper", b.name);
            assertEquals(72, b.capacity);
        });
    }

    @Test
    public void testException_MultipleValidBogiesCreation() {
        assertDoesNotThrow(() -> {
            new UseCase14TrainConsistMgmnt.Bogie("Sleeper", 72);
            new UseCase14TrainConsistMgmnt.Bogie("AC Chair", 56);
            new UseCase14TrainConsistMgmnt.Bogie("General", 90);
        });
    }
}
