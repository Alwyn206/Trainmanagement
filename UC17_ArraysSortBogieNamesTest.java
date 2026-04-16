import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Use Case 17: Sort Bogie Names Using Arrays.sort()
 */
public class UseCase17TrainConsistMgmntTest {

    @Test
    public void testSort_BasicAlphabeticalSorting() {
        String[] names = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        UseCase17TrainConsistMgmnt.sortBogieNames(names);
        assertArrayEquals(new String[]{"AC Chair", "First Class", "General", "Luxury", "Sleeper"}, names);
    }

    @Test
    public void testSort_UnsortedInput() {
        String[] names = {"Luxury", "General", "Sleeper", "AC Chair"};
        UseCase17TrainConsistMgmnt.sortBogieNames(names);
        assertArrayEquals(new String[]{"AC Chair", "General", "Luxury", "Sleeper"}, names);
    }

    @Test
    public void testSort_AlreadySortedArray() {
        String[] names = {"AC Chair", "First Class", "General"};
        UseCase17TrainConsistMgmnt.sortBogieNames(names);
        assertArrayEquals(new String[]{"AC Chair", "First Class", "General"}, names);
    }

    @Test
    public void testSort_DuplicateBogieNames() {
        String[] names = {"Sleeper", "AC Chair", "Sleeper", "General"};
        UseCase17TrainConsistMgmnt.sortBogieNames(names);
        assertArrayEquals(new String[]{"AC Chair", "General", "Sleeper", "Sleeper"}, names);
    }

    @Test
    public void testSort_SingleElementArray() {
        String[] names = {"Sleeper"};
        UseCase17TrainConsistMgmnt.sortBogieNames(names);
        assertArrayEquals(new String[]{"Sleeper"}, names);
    }
}
