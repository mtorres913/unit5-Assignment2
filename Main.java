public class Main {
    public static void main(String[] args) {
        // Create 4 identical WeatherReport objects
        WeatherReport original = new WeatherReport("weather.txt");
        WeatherReport collCity = new WeatherReport("weather.txt");
        WeatherReport mergeCity = new WeatherReport("weather.txt");
        WeatherReport collHigh = new WeatherReport("weather.txt");
        WeatherReport mergeHigh = new WeatherReport("weather.txt");

        // Confirm none are sorted
        System.out.println("Original isSortedByCity: " + original.isSortedByCity());
        System.out.println("Original isSortedByHigh: " + original.isSortedByHigh());

        // Sort by City using Collections
        long startCollCity = System.nanoTime();
        collCity.sortWithCollections("City");
        long endCollCity = System.nanoTime();
        System.out.println("Collections sort by City took: " + (endCollCity - startCollCity) + " ns");
        System.out.println("collCity isSortedByCity: " + collCity.isSortedByCity());

        // Sort by City using Merge Sort
        long startMergeCity = System.nanoTime();
        mergeCity.sortWithMerge("City");
        long endMergeCity = System.nanoTime();
        System.out.println("Merge sort by City took: " + (endMergeCity - startMergeCity) + " ns");
        System.out.println("mergeCity isSortedByCity: " + mergeCity.isSortedByCity());

        // Sort by High using Collections
        long startCollHigh = System.nanoTime();
        collHigh.sortWithCollections("High");
        long endCollHigh = System.nanoTime();
        System.out.println("Collections sort by High took: " + (endCollHigh - startCollHigh) + " ns");
        System.out.println("collHigh isSortedByHigh: " + collHigh.isSortedByHigh());

        // Sort by High using Merge Sort
        long startMergeHigh = System.nanoTime();
        mergeHigh.sortWithMerge("High");
        long endMergeHigh = System.nanoTime();
        System.out.println("Merge sort by High took: " + (endMergeHigh - startMergeHigh) + " ns");
        System.out.println("mergeHigh isSortedByHigh: " + mergeHigh.isSortedByHigh());
    }
}
