import java.util.LinkedList;

class Connection {
    public void connect() {
        System.out.println("Connected successfully.");
    }
}

class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int maxSize) {
        for (int i = 0; i < maxSize; i++) {
            pool.add(new Connection());
        }
    }

    public synchronized Connection borrowConnection() throws InterruptedException {
        if (pool.isEmpty()) {
            wait();
        }
        return pool.poll();
    }
    public synchronized void returnConnection(Connection conn) {
        pool.add(conn);
        notifyAll();
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ConnectionPool pool = new ConnectionPool(1);

        Connection conn1 = pool.borrowConnection();
        new Thread(() -> {
            try {
                System.out.println("Trying to borrow a connection...");
                Connection conn2 = pool.borrowConnection();
                conn2.connect();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        Thread.sleep(2000); // 模擬連線使用時間
        pool.returnConnection(conn1);
    }
}