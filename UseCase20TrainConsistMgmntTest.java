import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Use Case 20: Exception Handling During Search Operations
 */
public class UseCase20TrainConsistMgmntTest {

    @Test
    public void testSearch_ThrowsExceptionWhenEmpty() {
        String[] bogieIds = {};
        assertThrows(IllegalStateException.class, () -> {
            UseCase20TrainConsistMgmnt.searchBogieID(bogieIds, "BG101");
        });
    }

    @Test
    public void testSearch_AllowsSearchWhenDataExists() {
        String[] bogieIds = {"BG101", "BG205"};
        assertDoesNotThrow(() -> {
            UseCase20TrainConsistMgmnt.searchBogieID(bogieIds, "BG101");
        });
    }

    @Test
    public void testSearch_BogieFoundAfterValidation() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        assertTrue(UseCase20TrainConsistMgmnt.searchBogieID(bogieIds, "BG205"));
    }

    @Test
    public void testSearch_BogieNotFoundAfterValidation() {
        String[] bogieIds = {"BG101", "BG205", "BG309"};
        assertFalse(UseCase20TrainConsistMgmnt.searchBogieID(bogieIds, "BG999"));
    }

    @Test
    public void testSearch_SingleElementValidCase() {
        String[] bogieIds = {"BG101"};
        assertTrue(UseCase20TrainConsistMgmnt.searchBogieID(bogieIds, "BG101"));
    }
}
