import java.util.LinkedList;

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
}
