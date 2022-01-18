package IPL;

import java.util.ArrayList;
import java.util.List;

public class CSVParser {
    public static List<String> parseLine(String line) {
        List<String> values = new ArrayList<String>();

        String eachValue = "";
        for (int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == ',') {
                values.add(eachValue);
                eachValue = "";
            } else {
                eachValue += line.charAt(i);
            }
        }
        values.add(eachValue);

        return values;
    }
}
