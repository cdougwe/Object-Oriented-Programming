interface InventoryApp {
    void updateStock(String item, int quantity);
}

class LegacyInventorySystem {
    public void updateLegacyStock(String item, int quantity) {
        System.out.println("Updating legacy stock: " + item + " - " + quantity);
    }
}

class ModernInventoryAppAdapter implements InventoryApp {
    private LegacyInventorySystem legacyInventorySystem;

    public ModernInventoryAppAdapter() {
        this.legacyInventorySystem = new LegacyInventorySystem();
    }
    public void updateStock(String item, int quantity) {
        legacyInventorySystem.updateLegacyStock(item, quantity);
    }
}

class Main {
    public static void main(String[] args) {
        InventoryApp p = new ModernInventoryAppAdapter();
        p.updateStock("筆電", 5); // 顯示 "Updating legacy stock: 筆電 - 5"。
    }
}