abstract class DocumentProcessor {
    public void execute() {
        readFile();
        processData();
        saveFile();
    }

    abstract void readFile();
    abstract void processData();
    abstract void saveFile();
}

class CSVProcessor extends DocumentProcessor {
    @Override
    void readFile() {
        System.out.println("讀取 CSV 文件");
    }
    @Override
    void processData() {
        System.out.println("處理 CSV 數據");
    }
    @Override
    void saveFile() {
        System.out.println("儲存 CSV 文件");
    }
}

class JSONProcessor extends DocumentProcessor {
    @Override
    void readFile() {
        System.out.println("讀取 JSON 文件");
    }
    @Override
    void processData() {
        System.out.println("處理 JSON 數據");
    }
    @Override
    void saveFile() {
        System.out.println("儲存 JSON 文件");
    }
}

public class Main {
    public static void main(String[] args) {
        DocumentProcessor dp = new CSVProcessor();
        dp.execute();

        System.out.println("———");

        DocumentProcessor json = new JSONProcessor();
        json.execute();
    }
}