package ru.job4j.ood.lsp.foul;

/* Нарушает принцип LSP, так как усилено предусловие на регион доставки */
public class InternationalShippingCalculator extends ShippingCalculator {
    @Override
    public double calculateCost(double weight, String destination) {
        if (destination.equals("Mexico")) {
            throw new UnsupportedOperationException("Unsupported destination");
        }
        return weight * 10;
    }
}
