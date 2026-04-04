interface TaxStrategy {
    double calculate(double base);
}

class USATax implements TaxStrategy {
    @Override
    public double calculate(double base) {
        return base * 0.1;
    }
}

class UKTax implements TaxStrategy {
    @Override
    public double calculate(double base) {
        return base * 0.2;
    }
}

class CanadaTax implements TaxStrategy {
    @Override
    public double calculate(double base) {
        return base * 0.15;
    }
}

public class TaxCalculator {
    private TaxStrategy taxStrategy;

    public TaxCalculator() {
    }
    public void setTaxStrategy(TaxStrategy taxStrategy) { this.taxStrategy = taxStrategy; }
    public double calculateTax(double base) {
        return taxStrategy.calculate(base);
    }
    public static void main(String[] args) {
        TaxCalculator p = new TaxCalculator();
        p.setTaxStrategy(new USATax());
        System.out.println(p.calculateTax(1000)); // 回傳 100
        p = new TaxCalculator();
        p.setTaxStrategy(new UKTax());
        System.out.println(p.calculateTax(1000)); // 回傳 200
        p = new TaxCalculator();
        p.setTaxStrategy(new CanadaTax());
        System.out.println(p.calculateTax(1000)); // 回傳 150
    }

}
