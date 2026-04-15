import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase10TrainConsistMgmntTest {

    @Test
    public void testReduce_TotalSeatCalculation() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("AC Chair", 56));
        
        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
                
        assertEquals(128, total);
    }

    @Test
    public void testReduce_MultipleBogiesAggregation() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("AC Chair", 56));
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("General", 90));
        
        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
                
        assertEquals(218, total);
    }

    @Test
    public void testReduce_SingleBogieCapacity() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("First Class", 24));
        
        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
                
        assertEquals(24, total);
    }

    @Test
    public void testReduce_EmptyBogieList() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        
        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
                
        assertEquals(0, total);
    }

    @Test
    public void testReduce_CorrectCapacityExtraction() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("General", 90));
        
        assertEquals(90, bogies.get(0).capacity);
        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
                
        assertEquals(90, total);
    }

    @Test
    public void testReduce_AllBogiesIncluded() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("Bog1", 10));
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("Bog2", 20));
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("Bog3", 30));
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("Bog4", 40));
        
        int total = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
                
        assertEquals(100, total);
    }

    @Test
    public void testReduce_OriginalListUnchanged() {
        List<UseCase10TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase10TrainConsistMgmnt.Bogie("AC Chair", 56));
        
        bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
                
        assertEquals(2, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
        assertEquals(72, bogies.get(0).capacity);
        assertEquals("AC Chair", bogies.get(1).name);
        assertEquals(56, bogies.get(1).capacity);
    }
}
