enum FileType {
    PDF, CSV;
}

interface Exporter {
    void writeToFile(String data, String filename);
}

class PDFExporter implements Exporter {
    @Override
    public void writeToFile(String data, String filename) {
        System.out.println("寫入 PDF檔案: " + data + " 到 " + filename);
    }
}

class CSVExporter implements Exporter {
    @Override
    public void writeToFile(String data, String filename) {
        System.out.println("寫入 CSV: " + data + " 到 " + filename);
    }
}

abstract class Document {
    private Exporter exporter;

    final void export(String data, String filename) {
        exporter = genExporter(); // 生成匯出工具
        exporter.writeToFile(data, filename); // 執行匯出
    }

    abstract Exporter genExporter();
}

class PDF extends Document {
    @Override
    Exporter genExporter() {
        return new PDFExporter();
    }
}

class CSV extends Document {
    @Override
    Exporter genExporter() {
        return new CSVExporter();
    }
}

class DocumentFactory {
    public Document getType(String fileType) {
        if (fileType == null)
            throw new IllegalArgumentException("FillType should not be a null value");
        try {
            FileType type = FileType.valueOf(fileType.toUpperCase());
            return switch (type) {
                case PDF -> new PDF();
                case CSV -> new CSV();
            };
        } catch (Exception e) {
            throw new IllegalArgumentException("Unsupported file type:" + fileType);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        DocumentFactory documentFactory = new DocumentFactory();
        Document exporter = documentFactory.getType("Pdf");
        exporter.export("Hello", "file1.pdf");
        exporter = documentFactory.getType("CSV");
        exporter.export("Hello", "file2.csv");
    }
}
