public class Main {
    public static void main(String[] args) {
        WeatherReport report = new WeatherReport();

        System.out.println("=== Map-based Wind Speed Ranges ===");
        report.printWindSpeedRanges();

        System.out.println("\n=== List-based Wind Speed Ranges ===");
        report.printListRanges();

        System.out.println("\n=== TreeMap-based Wind Speed Ranges ===");
        report.printTreeRanges();
    }
}
