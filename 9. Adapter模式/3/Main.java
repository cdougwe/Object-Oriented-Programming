class LegacyFileReader {
    public void readFromFile(String filePath) {
        System.out.println("Reading from file: " + filePath);
    }
}

interface DataProcessingTarget {
    void processData(String file);
}

class LegacyAdapter implements DataProcessingTarget {
    private LegacyFileReader legacyFileReader = new LegacyFileReader();

    @Override
    public void processData(String file) {
        legacyFileReader.readFromFile(file);
    }
}

class DataProcessingSystem {
    private DataProcessingTarget dataProcessingTarget;

    public DataProcessingSystem(DataProcessingTarget dataProcessingTarget) {
        this.dataProcessingTarget = dataProcessingTarget;
    }

    public void processData(String file) {
        dataProcessingTarget.processData(file);
    }
}

class Main {
    public static void main(String[] args) {
        DataProcessingSystem p = new DataProcessingSystem(new LegacyAdapter());
        p.processData("data.txt"); // 顯示 ""Reading from file: data.txt"。
    }
}
