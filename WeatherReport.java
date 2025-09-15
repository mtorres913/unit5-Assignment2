import java.io.*;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Comparator;

public class WeatherReport {
    LinkedList<Temperature> temps;

    public WeatherReport() {
        temps = new LinkedList<>();
        temps.add(new Temperature("Phoenix", "AZ", 75, 105));
        temps.add(new Temperature("Denver", "CO", 45, 78));
        temps.add(new Temperature("Chicago", "IL", 38, 65));
        temps.add(new Temperature("Miami", "FL", 80, 95));
        temps.add(new Temperature("Seattle", "WA", 50, 68));
        temps.add(new Temperature("Boston", "MA", 42, 70));
        temps.add(new Temperature("Dallas", "TX", 60, 90));
        temps.add(new Temperature("Minneapolis", "MN", 30, 60));
        temps.add(new Temperature("San Diego", "CA", 62, 77));
    }

    public WeatherReport(String filename) {
        temps = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String city = parts[1];
                String state = parts[10];
                int high = Integer.parseInt(parts[5]);
                int low = Integer.parseInt(parts[6]);
                temps.add(new Temperature(city, state, low, high));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public boolean isSortedByCity() {
        for (int i = 0; i < temps.size() - 1; i++) {
            String currentCity = temps.get(i).city;
            String nextCity = temps.get(i + 1).city;
            if (currentCity.compareToIgnoreCase(nextCity) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isSortedByHigh() {
        for (int i = 0; i < temps.size() - 1; i++) {
            if (temps.get(i).high > temps.get(i + 1).high) {
                return false;
            }
        }
        return true;
    }
    
public void sortWithCollections(String by) {
    if (by.equalsIgnoreCase("City")) {
        Collections.sort(temps, Comparator.comparing(t -> t.city.toLowerCase()));
    } else if (by.equalsIgnoreCase("High")) {
        Collections.sort(temps, Comparator.comparingInt(t -> t.high));
    } else {
        System.err.println("Invalid sort key: " + by);
    }
}
}
