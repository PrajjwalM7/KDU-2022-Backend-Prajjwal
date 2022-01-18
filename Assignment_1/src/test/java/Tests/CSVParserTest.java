package Tests;

import IPL.CSVParser;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CSVParserTest {
    static int currentTest = 1;
    @BeforeAll
    public static void testOnClass() {
        System.out.println("Tests on CSVParser");
    }

    @BeforeEach
    public void beforeEachTest() {
        System.out.println("Test " + currentTest + " going on ...");
        currentTest++;
    }

    @Test
    public void parseString(){
        String input = "Prajjwal,21,prajjwal@kickdrum.com,35000";
        List<String> output = new ArrayList<>(List.of("Prajjwal", "21", "prajjwal@kickdrum.com", "35000"));
        assertEquals(output, CSVParser.parseLine(input));
    }

    @Test
    public void parseEmptyString(){
        String input = "";
        List<String> output = new ArrayList<>(List.of(""));
        assertEquals(output, CSVParser.parseLine(input));
    }

    @AfterAll
    public static void testComplete() {
        System.out.println("Tests on CSVParser Complete");
    }
}
