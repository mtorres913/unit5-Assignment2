public class Temperature {
    String city;
    String state;
    int low;
    int high;

    public Temperature(String city, String state, int low, int high) {
        this.city = city;
        this.state = state;
        this.low = low;
        this.high = high;
    }

    public int differential() {
        return Math.abs(high - low);
    }
}
