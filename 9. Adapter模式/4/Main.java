class LegacyInventorySystem {
    public void updateLegacyStock(String item, int quantity) {
        System.out.println("Updating legacy stock: " + item + " - " + quantity);
    }
}

interface InventoryTarget {
    void updateStock(String item, int quantity);
}

class LegacyInventorySystemAdapter implements InventoryTarget {
    private LegacyInventorySystem legacyInventorySystem = new LegacyInventorySystem();

    @Override
    public void updateStock(String item, int quantity) {
        legacyInventorySystem.updateLegacyStock(item, quantity);
    }
}

class ModernInventoryApp implements InventoryTarget {
    private InventoryTarget inventoryTarget;

    public ModernInventoryApp(InventoryTarget inventoryTarget) {
        this.inventoryTarget = inventoryTarget;
    }

    public void updateStock(String item, int quantity) {
        inventoryTarget.updateStock(item, quantity);
    }
}

class Main {
    public static void main(String[] args) {
        ModernInventoryApp p = new ModernInventoryApp(new LegacyInventorySystemAdapter());
        p.updateStock("筆電", 5); // 顯示 "Updating legacy stock: 筆電 - 5"。
    }
}