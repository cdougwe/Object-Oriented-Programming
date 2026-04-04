interface Report {
    void generate();
}

class PDFReport implements Report {
    @Override
    public void generate() {
        System.out.println("產生 PDF 報告");
    }
}

class WordReport implements Report {
    @Override
    public void generate() {
        System.out.println("產生 Word 報告");
    }
}

class Main {
    public static void main(String[] args) {
        Report p = new PDFReport();
        p.generate();

        p = new WordReport();
        p.generate();
    }
}