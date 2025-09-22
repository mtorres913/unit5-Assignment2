public class Main {
    public static void main(String[] args) {
        // First WeatherReport: test data
        WeatherReport report1 = new WeatherReport();

        System.out.println("=== Report 1: Test Data ===");

        long startList1 = System.nanoTime();
        var list1 = report1.computeByList();
        long endList1 = System.nanoTime();
        System.out.println("computeByList() took: " + (endList1 - startList1) + " ns");

        for (StateRange sr : list1) {
            System.out.printf("%s: %.2f mph%n", sr.state, sr.getRange());
        }

        long startTree1 = System.nanoTime();
        var tree1 = report1.computeByTree();
        long endTree1 = System.nanoTime();
        System.out.println("computeByTree() took: " + (endTree1 - startTree1) + " ns");

        for (var entry : tree1.entrySet()) {
            System.out.printf("%s: %.2f mph%n", entry.getKey(), entry.getValue().getRange());
        }

        // Second WeatherReport: from file
        WeatherReport report2 = new WeatherReport("weather.txt");

        System.out.println("\n=== Report 2: File Data ===");

        long startList2 = System.nanoTime();
        var list2 = report2.computeByList();
        long endList2 = System.nanoTime();
        System.out.println("computeByList() took: " + (endList2 - startList2) + " ns");

        for (StateRange sr : list2) {
            System.out.printf("%s: %.2f mph%n", sr.state, sr.getRange());
        }

        long startTree2 = System.nanoTime();
        var tree2 = report2.computeByTree();
        long endTree2 = System.nanoTime();
        System.out.println("computeByTree() took: " + (endTree2 - startTree2) + " ns");

        for (var entry : tree2.entrySet()) {
            System.out.printf("%s: %.2f mph%n", entry.getKey(), entry.getValue().getRange());
        }
    }
}
