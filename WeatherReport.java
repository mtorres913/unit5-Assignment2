import java.io.*;
import java.util.*;

public class WeatherReport {
    LinkedList<WindSpeed> speeds;

    public WeatherReport() {
        speeds = new LinkedList<>();
        speeds.add(new WindSpeed("Alabama", 4.33));
        speeds.add(new WindSpeed("Alabama", 3.86));
        speeds.add(new WindSpeed("Alabama", 9.73));
        speeds.add(new WindSpeed("Alaska", 7.8));
        speeds.add(new WindSpeed("Alaska", 16.46));
        speeds.add(new WindSpeed("Alaska", 2.2));
        speeds.add(new WindSpeed("Alaska", 21.8));
        speeds.add(new WindSpeed("Alaska", 11.76));
        speeds.add(new WindSpeed("Alaska", 3.7));
        speeds.add(new WindSpeed("Alaska", 9.76));
    }

    public WeatherReport(String filename) {
        speeds = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine(); // Skip header
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String state = parts[10];
                double wind = Double.parseDouble(parts[9]);
                speeds.add(new WindSpeed(state, wind));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public Map<String, Double> getWindSpeedRangeByState() {
        Map<String, List<Double>> stateToValues = new HashMap<>();

        for (WindSpeed ws : speeds) {
            stateToValues
                    .computeIfAbsent(ws.state, k -> new ArrayList<>())
                    .add(ws.value);
        }

        Map<String, Double> stateToRange = new HashMap<>();
        for (Map.Entry<String, List<Double>> entry : stateToValues.entrySet()) {
            List<Double> values = entry.getValue();
            double max = Collections.max(values);
            double min = Collections.min(values);
            stateToRange.put(entry.getKey(), max - min);
        }

        return stateToRange;
    }

    public List<StateRange> computeByList() {
        List<StateRange> result = new ArrayList<>();

        for (WindSpeed ws : speeds) {
            boolean found = false;
            for (StateRange sr : result) {
                if (sr.state.equals(ws.state)) {
                    sr.update(ws.value);
                    found = true;
                    break;
                }
            }
            if (!found) {
                result.add(new StateRange(ws.state, ws.value));
            }
        }

        return result;
    }

    public TreeMap<String, StateRange> computeByTree() {
        TreeMap<String, StateRange> result = new TreeMap<>();

        for (WindSpeed ws : speeds) {
            if (result.containsKey(ws.state)) {
                result.get(ws.state).update(ws.value);
            } else {
                result.put(ws.state, new StateRange(ws.state, ws.value));
            }
        }

        return result;
    }

    public void printWindSpeedRanges() {
        Map<String, Double> ranges = getWindSpeedRangeByState();
        for (Map.Entry<String, Double> entry : ranges.entrySet()) {
            System.out.printf("%s: %.2f mph%n", entry.getKey(), entry.getValue());
        }
    }

    public void printListRanges() {
        List<StateRange> ranges = computeByList();
        for (StateRange sr : ranges) {
            System.out.printf("%s: %.2f mph%n", sr.state, sr.getRange());
        }
    }

    public void printTreeRanges() {
        TreeMap<String, StateRange> ranges = computeByTree();
        for (Map.Entry<String, StateRange> entry : ranges.entrySet()) {
            System.out.printf("%s: %.2f mph%n", entry.getKey(), entry.getValue().getRange());
        }
    }

}
