import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase13TrainConsistMgmntTest {

    @Test
    public void testLoopFilteringLogic() {
        List<UseCase13TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("Bog1", 70));
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("Bog2", 50));
        
        List<UseCase13TrainConsistMgmnt.Bogie> res = UseCase13TrainConsistMgmnt.filterWithLoop(bogies);
        assertEquals(1, res.size());
        assertEquals(70, res.get(0).capacity);
    }

    @Test
    public void testStreamFilteringLogic() {
        List<UseCase13TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("Bog1", 70));
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("Bog2", 50));
        
        List<UseCase13TrainConsistMgmnt.Bogie> res = UseCase13TrainConsistMgmnt.filterWithStream(bogies);
        assertEquals(1, res.size());
        assertEquals(70, res.get(0).capacity);
    }

    @Test
    public void testLoopAndStreamResultsMatch() {
        List<UseCase13TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("Bog1", 80));
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("Bog2", 40));
        bogies.add(new UseCase13TrainConsistMgmnt.Bogie("Bog3", 90));
        
        List<UseCase13TrainConsistMgmnt.Bogie> resLoop = UseCase13TrainConsistMgmnt.filterWithLoop(bogies);
        List<UseCase13TrainConsistMgmnt.Bogie> resStream = UseCase13TrainConsistMgmnt.filterWithStream(bogies);
        
        assertEquals(resLoop.size(), resStream.size());
    }

    @Test
    public void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        int sum = 0;
        for(int i=0; i<100; i++) sum += i;
        long end = System.nanoTime();
        assertTrue((end - start) > 0);
    }

    @Test
    public void testLargeDatasetProcessing() {
        List<UseCase13TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            bogies.add(new UseCase13TrainConsistMgmnt.Bogie("Mock", 80));
        }
        
        List<UseCase13TrainConsistMgmnt.Bogie> res = UseCase13TrainConsistMgmnt.filterWithStream(bogies);
        assertEquals(100_000, res.size());
    }
}
