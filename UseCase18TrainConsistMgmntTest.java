import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Use Case 18: Linear Search for Bogie ID
 */
public class UseCase18TrainConsistMgmntTest {

    @Test
    public void testSearch_BogieFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UseCase18TrainConsistMgmnt.searchBogieID(bogieIds, "BG309"));
    }

    @Test
    public void testSearch_BogieNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(UseCase18TrainConsistMgmnt.searchBogieID(bogieIds, "BG999"));
    }

    @Test
    public void testSearch_FirstElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UseCase18TrainConsistMgmnt.searchBogieID(bogieIds, "BG101"));
    }

    @Test
    public void testSearch_LastElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UseCase18TrainConsistMgmnt.searchBogieID(bogieIds, "BG550"));
    }

    @Test
    public void testSearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};
        assertTrue(UseCase18TrainConsistMgmnt.searchBogieID(bogieIds, "BG101"));
    }
}
