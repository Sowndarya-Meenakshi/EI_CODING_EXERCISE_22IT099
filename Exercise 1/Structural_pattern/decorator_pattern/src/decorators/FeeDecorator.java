//This is the abstract class that makes use of the all fees,This itself is not the fee
package decorators;

import base.FeeComponent;

public abstract class FeeDecorator implements FeeComponent {
    protected final FeeComponent feeComponent;

    public FeeDecorator(FeeComponent feeComponent) {
        if (feeComponent == null) throw new IllegalArgumentException("Fee component cannot be null");
        this.feeComponent = feeComponent;
    }

    @Override
    public double getFee() {
        return feeComponent.getFee();
    }

    @Override
    public String getDescription() {
        return feeComponent.getDescription();
    }
}


