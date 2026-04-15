import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase9TrainConsistMgmntTest {

    @Test
    public void testGrouping_BogiesGroupedByType() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72));
        
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
                
        assertTrue(result.containsKey("Sleeper"));
        assertEquals(2, result.get("Sleeper").size());
    }

    @Test
    public void testGrouping_MultipleBogiesInSameGroup() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("General", 90));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("General", 90));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("General", 90));
        
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
                
        assertEquals(3, result.get("General").size());
    }

    @Test
    public void testGrouping_DifferentBogieTypes() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("AC Chair", 56));
        
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
                
        assertEquals(2, result.size());
        assertTrue(result.containsKey("Sleeper"));
        assertTrue(result.containsKey("AC Chair"));
    }

    @Test
    public void testGrouping_EmptyBogieList() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
                
        assertTrue(result.isEmpty());
    }

    @Test
    public void testGrouping_SingleBogieCategory() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("First Class", 24));
        
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
                
        assertEquals(1, result.size());
        assertTrue(result.containsKey("First Class"));
    }

    @Test
    public void testGrouping_MapContainsCorrectKeys() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("AC Chair", 56));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("First Class", 24));
        
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
                
        assertTrue(result.keySet().containsAll(List.of("Sleeper", "AC Chair", "First Class")));
    }

    @Test
    public void testGrouping_GroupSizeValidation() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("AC Chair", 56));
        
        Map<String, List<UseCase9TrainConsistMgmnt.Bogie>> result = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
                
        assertEquals(2, result.get("Sleeper").size());
        assertEquals(1, result.get("AC Chair").size());
    }

    @Test
    public void testGrouping_OriginalListUnchanged() {
        List<UseCase9TrainConsistMgmnt.Bogie> bogies = new ArrayList<>();
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("Sleeper", 72));
        bogies.add(new UseCase9TrainConsistMgmnt.Bogie("AC Chair", 56));
        
        bogies.stream().collect(Collectors.groupingBy(b -> b.name));
                
        assertEquals(2, bogies.size());
        assertEquals("Sleeper", bogies.get(0).name);
        assertEquals("AC Chair", bogies.get(1).name);
    }
}
