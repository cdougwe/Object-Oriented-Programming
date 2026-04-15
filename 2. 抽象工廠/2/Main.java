interface OperatingSystem {
    void display();
}

class Windows10 implements OperatingSystem {
    @Override
    public void display() {
        System.out.println("Displaying Windows 10");
    }
}

class Windows11 implements OperatingSystem {
    @Override
    public void display() {
        System.out.println("Displaying Windows 11");
    }
}

interface OperatingSystemFactory {
    OperatingSystem createWindows();
}

class Windows10Factory implements OperatingSystemFactory {
    @Override
    public OperatingSystem createWindows() {
        return new Windows10();
    }
}

class Windows11Factory implements OperatingSystemFactory {
    @Override
    public OperatingSystem createWindows() {
        return new Windows11();
    }
}

class OSClient {
    private OperatingSystem operatingSystem;

    public OSClient(OperatingSystemFactory operatingSystemFactory) {
        this.operatingSystem = operatingSystemFactory.createWindows();
    }

    public void displayOperatingSystem() {
        operatingSystem.display();
    }
}

public class Main {
    public static void main(String[] args) {
        OSClient os = new OSClient(new Windows10Factory());
        os.displayOperatingSystem();
        os = new OSClient(new Windows11Factory());
        os.displayOperatingSystem();
    }
}