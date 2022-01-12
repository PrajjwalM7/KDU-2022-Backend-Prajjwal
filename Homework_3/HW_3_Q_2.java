import java.io.*;
import java.util.*;

class Country {
    String country, capital;
    Country(String country, String capital) {
        this.country = country;
        this.capital = capital;
    }
}

public class HW_3_Q_2 {
    public static Country parseLine(String line) {
        int first_comma = line.indexOf(',');
        int second_comma = line.lastIndexOf(',');
        String country = line.substring(1, first_comma - 1);
        String capital = line.substring(first_comma + 2, second_comma - 1);
        Country cou = new Country(country, capital);
        return cou;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader buf = new BufferedReader(new FileReader(new File("country-list.csv")));
        String s;
        int i = 10;
        System.out.println("First 10 lines of the file :\n");
        Map<String, String> mp = new HashMap<String, String>();
        while((s = buf.readLine()) != null) {
            if(i-- > 0) {
                System.out.println(s);
            }
            Country c = parseLine(s);
            mp.put(c.country, c.capital);
        }
        mp.remove("country");
        List<Country> items = new ArrayList<Country>();
        int k = 0;
        for (Map.Entry<String,String> entry: mp.entrySet()) {
            items.add(new Country(entry.getKey(), entry.getValue()));
        }
        Collections.sort(items, new Comparator<Country>() {
            @Override
            public int compare(Country c1, Country c2) {
                return c1.capital.compareTo(c2.capital);
            }
        });
        System.out.println("\nLast 10 values after sorting : ");
        for(i = mp.size() - 10; i < mp.size(); i++) {
            System.out.println(items.get(i).country + " - " + items.get(i).capital);
        }
    }
}
