import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


public class AddEventFormScoup {
    @BeforeClass
    // Инициализация драйвера
    public static void setup() {

        AddEventTestStep.setUp();
    }
    @Test
    public void testEventForm1() throws InterruptedException {
        AddEventTestCases.addEventTestCases("10:00 AM","11:00 AM");
    }
    @Test
    public void testEventForm2() throws InterruptedException {
        AddEventTestCases.addEventTestCases("12:00 AM","1:00 PM");
    }


    @AfterClass

    public static  void tearDown() {

        AddEventTestStep.driver.quit();

    }
}
