import formatter.MainException;
import formatter.Main;
import org.junit.Test;


/**
 * Test for main.
 */
public class MainTest {
    @Test
    public void mains() throws Exception, MainException {
        Main.main(new String[]{"src/main/resources/input", "src/main/resources/output"});
    }
}