import java.util.LinkedList;

class Logger {
    public void log(String msg) {
        System.out.println("Logging " + msg);
    }
}

class LoggerPool {
    private LinkedList<Logger> pool = new LinkedList<>();
    private int maxSize;

    public LoggerPool(int maxSize) {
        this.maxSize = maxSize;
        for (int i = 0; i < maxSize; i++) {
            pool.add(new Logger());
        }
    }

    public synchronized Logger getLogger() {
        while (pool.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return pool.removeFirst();
    }

    public synchronized void releaseLogger(Logger logger) {
        pool.addLast(logger);
        notifyAll();
    }
}

class LoggingService {
    private LoggerPool pool;

    public LoggingService(int size) {
        pool = new LoggerPool(size);
    }
    public void logMessage(String message) {
        Logger logger = pool.getLogger();
        try {
            logger.log(message);
        } finally {
            pool.releaseLogger(logger);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LoggingService ls = new LoggingService(100);
        ls.logMessage("Hello");
        ls.logMessage("I am Tom");
    }
}