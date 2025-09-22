public class StateRange {
    public String state;
    public double min;
    public double max;

    public StateRange(String state, double value) {
        this.state = state;
        this.min = value;
        this.max = value;
    }

    public void update(double value) {
        if (value < min) min = value;
        if (value > max) max = value;
    }

    public double getRange() {
        return max - min;
    }
}
