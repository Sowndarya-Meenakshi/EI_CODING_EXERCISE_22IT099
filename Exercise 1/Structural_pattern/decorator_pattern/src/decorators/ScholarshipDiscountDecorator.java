package decorators;
import base.FeeComponent; 
public class ScholarshipDiscountDecorator extends FeeDecorator {
    private final double discount;

    public ScholarshipDiscountDecorator(FeeComponent feeComponent, double discount) {
        super(feeComponent);
        if(discount < 0) throw new IllegalArgumentException("Discount cannot be negative");
        this.discount = discount;
    }

    @Override
    public double getFee() {
        double total = super.getFee() - discount;
        return total >= 0 ? total : 0;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\n- Scholarship Discount: $" + discount;
    }
}
