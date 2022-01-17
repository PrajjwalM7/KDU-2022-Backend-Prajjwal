import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class HW_5_Q_3_Tests {
    @BeforeAll
    public static void setUp() throws Exception {
        System.out.println("Input : An array of double type numbers.");
        System.out.println("Output : Average of the numbers.");
    }

    @BeforeEach
    public void startOfTest() throws Exception {
        System.out.println("Test is about to start!");
    }

    @Test
    public void findAverage(){
        assertEquals(1, HW_5_Q_3.findAverage(new double[]{1,1,1,1}));
        assertEquals(15.2,HW_5_Q_3.findAverage(new double[]{4,50,7,6,9}));
    }

    @Test
    public void findAverageEmptyArray() {
        assertEquals(0, HW_5_Q_3.findAverage(new double[]{}));
    }

    @AfterEach
    public void afterTest() throws Exception {
        System.out.println("Test Complete");
    }

    @AfterAll
    public static void afterAllTests() throws Exception {
        System.out.println("All tests completed");
    }
}
