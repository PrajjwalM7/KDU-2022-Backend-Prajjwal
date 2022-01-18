package Tests;

import IPL.CSVFormatProcessor;
import IPL.Match;
import IPL.Team;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CSVFormatProcessorTest {
    static int currentTest = 1;
    @BeforeAll
    public static void testOnClass() {
        System.out.println("Tests on CSVFormatProcessor");
    }

    @BeforeEach
    public void beforeEachTest() {
        System.out.println("Test " + currentTest + " going on ...");
        currentTest++;
    }

    @Test
    public void formatMatchObject(){
        Team team1 = new Team("CSK", "Chennai Super Kings", "M. A. Chidambaram Stadium");
        Team team2 = new Team("PBKS", "Punjab Kings", "Punjab Cricket Association Cricket Stadium");
        Match match = new Match(team1, team2, 1, "M A Chidambaram Stadium");
        CSVFormatProcessor p = new CSVFormatProcessor();
        String output = "1,CSK,PBKS,M A Chidambaram Stadium";
        assertEquals(output, p.format(match));
    }

    @AfterAll
    public static void testComplete() {
        System.out.println("Tests on CSVParser Complete");
    }
}
