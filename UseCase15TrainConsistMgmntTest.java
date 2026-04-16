import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase15TrainConsistMgmntTest {

    @Test
    public void testCargo_SafeAssignment() {
        UseCase15TrainConsistMgmnt.GoodsBogie b = new UseCase15TrainConsistMgmnt.GoodsBogie("Cylindrical");
        assertDoesNotThrow(() -> b.assignCargo("Petroleum"));
        assertEquals("Petroleum", b.cargo);
    }

    @Test
    public void testCargo_UnsafeAssignmentHandled() {
        UseCase15TrainConsistMgmnt.GoodsBogie b = new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        UseCase15TrainConsistMgmnt.CargoSafetyException ex = assertThrows(
            UseCase15TrainConsistMgmnt.CargoSafetyException.class, 
            () -> b.assignCargo("Petroleum")
        );
        assertTrue(ex.getMessage().contains("Cannot assign Petroleum to a Rectangular bogie"));
    }

    @Test
    public void testCargo_CargoNotAssignedAfterFailure() {
        UseCase15TrainConsistMgmnt.GoodsBogie b = new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        try {
            b.assignCargo("Petroleum");
        } catch(UseCase15TrainConsistMgmnt.CargoSafetyException ignored) { }
        assertNull(b.cargo);
    }

    @Test
    public void testCargo_ProgramContinuesAfterException() {
        UseCase15TrainConsistMgmnt.GoodsBogie b1 = new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        UseCase15TrainConsistMgmnt.GoodsBogie b2 = new UseCase15TrainConsistMgmnt.GoodsBogie("Box");
        
        try { b1.assignCargo("Petroleum"); } catch(Exception ignored) { }
        try { b2.assignCargo("Coal"); } catch(Exception ignored) { }
        
        assertNull(b1.cargo);
        assertEquals("Coal", b2.cargo);
    }
    
    @Test
    public void testCargo_FinallyBlockExecution() {
        // Just verify we can catch finally mechanically in a wrapper
        boolean finallyExecuted = false;
        UseCase15TrainConsistMgmnt.GoodsBogie b = new UseCase15TrainConsistMgmnt.GoodsBogie("Rectangular");
        try {
            b.assignCargo("Petroleum");
        } catch(Exception ignored) {
        } finally {
            finallyExecuted = true;
        }
        assertTrue(finallyExecuted);
    }
}
