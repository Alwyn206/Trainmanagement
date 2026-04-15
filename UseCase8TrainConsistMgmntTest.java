import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase8TrainConsistMgmntTest {

    @Test
    public void testFilter_CapacityGreaterThanThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("AC Chair", 56));
        
        List<UseCase8TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());
                
        assertEquals(1, result.size());
        assertEquals("Sleeper", result.get(0).name);
    }

    @Test
    public void testFilter_CapacityEqualToThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("Sleeper", 70));
        
        List<UseCase8TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());
                
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_CapacityLessThanThreshold() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("AC Chair", 60));
        
        List<UseCase8TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());
                
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_MultipleBogiesMatching() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("General", 90));
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("AC Chair", 56));
        
        List<UseCase8TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());
                
        assertEquals(2, result.size());
    }

    @Test
    public void testFilter_NoBogiesMatching() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("AC Chair", 56));
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("First Class", 24));
        
        List<UseCase8TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());
                
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_AllBogiesMatching() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("General 1", 90));
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("General 2", 95));
        
        List<UseCase8TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());
                
        assertEquals(2, result.size());
    }

    @Test
    public void testFilter_EmptyBogieList() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        
        List<UseCase8TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());
                
        assertTrue(result.isEmpty());
    }

    @Test
    public void testFilter_OriginalListUnchanged() {
        List<UseCase8TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("General", 90));
        bogies.add(new UseCase8TrainConsistMgmnt.Bogie("First Class", 24));
        
        List<UseCase8TrainConsistMgmnt.Bogie> result = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());
                
        assertEquals(2, bogies.size());
        assertEquals("General", bogies.get(0).name);
        assertEquals("First Class", bogies.get(1).name);
    }
}
