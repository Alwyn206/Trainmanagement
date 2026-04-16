import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Use Case 19: Binary Search for Bogie ID
 */
public class UseCase19TrainConsistMgmntTest {

    @Test
    public void testBinarySearch_BogieFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UseCase19TrainConsistMgmnt.binarySearchBogieID(bogieIds, "BG309"));
    }

    @Test
    public void testBinarySearch_BogieNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(UseCase19TrainConsistMgmnt.binarySearchBogieID(bogieIds, "BG999"));
    }

    @Test
    public void testBinarySearch_FirstElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UseCase19TrainConsistMgmnt.binarySearchBogieID(bogieIds, "BG101"));
    }

    @Test
    public void testBinarySearch_LastElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(UseCase19TrainConsistMgmnt.binarySearchBogieID(bogieIds, "BG550"));
    }

    @Test
    public void testBinarySearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};
        assertTrue(UseCase19TrainConsistMgmnt.binarySearchBogieID(bogieIds, "BG101"));
    }

    @Test
    public void testBinarySearch_EmptyArray() {
        String[] bogieIds = {};
        assertFalse(UseCase19TrainConsistMgmnt.binarySearchBogieID(bogieIds, "BG101"));
    }

    @Test
    public void testBinarySearch_UnsortedInputHandled() {
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        assertTrue(UseCase19TrainConsistMgmnt.binarySearchBogieID(bogieIds, "BG205"));
    }
}
