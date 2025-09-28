package decorators;
import base.FeeComponent; 
public class SportsFeeDecorator extends FeeDecorator {
    private final double sportsFee;

    public SportsFeeDecorator(FeeComponent feeComponent, double sportsFee) {
        super(feeComponent);
        if(sportsFee < 0) throw new IllegalArgumentException("Sports fee cannot be negative");
        this.sportsFee = sportsFee;
    }

    @Override
    public double getFee() {
        return super.getFee() + sportsFee;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\n+ Sports Fee: $" + sportsFee;
    }
}
