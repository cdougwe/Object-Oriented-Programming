interface DataProcessingSystem {
    void processData(String filePath);
}

class LegacyFileReader {
    public void readFromFile(String filePath) {
        System.out.println("Reading from file: " + filePath);
    }
}

class LegacyAdapter implements DataProcessingSystem {
    private LegacyFileReader legacyFileReader;

    public LegacyAdapter() {
        this.legacyFileReader = new LegacyFileReader();
    }
    public void processData(String filePath) {
        legacyFileReader.readFromFile(filePath);
    }
}

class Main {
    public static void main(String[] args) {
        DataProcessingSystem p = new LegacyAdapter();
        p.processData("data.txt"); // 顯示 ""Reading from file: data.txt"。
    }
}