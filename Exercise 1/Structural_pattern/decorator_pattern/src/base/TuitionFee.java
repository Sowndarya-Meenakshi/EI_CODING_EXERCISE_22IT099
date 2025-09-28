package base;

public class TuitionFee implements FeeComponent {
    private final double tuitionAmount;

    public TuitionFee(double tuitionAmount) {
        if (tuitionAmount < 0) throw new IllegalArgumentException("Tuition fee cannot be negative");
        this.tuitionAmount = tuitionAmount;
    }

    @Override
    public double getFee() {
        return tuitionAmount;
    }

    @Override
    public String getDescription() {
        return "Base Tuition Fee: $" + tuitionAmount;
    }
}
