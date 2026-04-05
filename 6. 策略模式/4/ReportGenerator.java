interface ReportStrategy {
    void generate();
}

class ChemistryReport implements ReportStrategy {
    @Override
    public void generate() {
        System.out.println("Generating Chemistry report");
    }
}

class MathematicsReport implements ReportStrategy {
    @Override
    public void generate() {
        System.out.println("Generating Mathematics report");
    }
}

class PhysicsReport implements ReportStrategy {
    @Override
    public void generate() {
        System.out.println("Generating Physics report");
    }
}

public class ReportGenerator {
    private ReportStrategy reportStrategy;

    public ReportGenerator() {
    }
    public void setReportStrategy(ReportStrategy reportStrategy) { this.reportStrategy = reportStrategy; }
    public void generateReport() {
        reportStrategy.generate();
    }
    public static void main(String[] args) {
        ReportGenerator p = new ReportGenerator();
        p.setReportStrategy(new ChemistryReport());
        p.generateReport(); // 顯示 "Generating Chemistry report"

        p = new ReportGenerator();
        p.setReportStrategy(new MathematicsReport());
        p.generateReport(); // 顯示 "Generating Mathematics report"

        p = new ReportGenerator();
        p.setReportStrategy(new PhysicsReport());
        p.generateReport(); // 顯示 "Generating Physics report"
    }
}
