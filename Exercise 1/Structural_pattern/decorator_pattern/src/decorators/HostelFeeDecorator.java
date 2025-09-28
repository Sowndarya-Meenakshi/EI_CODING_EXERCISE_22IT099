package decorators;
import base.FeeComponent; 
public class HostelFeeDecorator extends FeeDecorator {
    private final double hostelFee;

    public HostelFeeDecorator(FeeComponent feeComponent, double hostelFee) {
        super(feeComponent);
        if(hostelFee < 0) throw new IllegalArgumentException("Hostel fee cannot be negative");
        this.hostelFee = hostelFee;
    }

    @Override
    public double getFee() {
        return super.getFee() + hostelFee;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\n+ Hostel Fee: $" + hostelFee;
    }
}
