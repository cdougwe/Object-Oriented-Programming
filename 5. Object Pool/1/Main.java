import java.util.LinkedList;

class Connection {
    public void connect() {
        System.out.println("Connected successfully.");
    }
}

class ConnectionPool {
    private int maxSize, Count = 0;
    private LinkedList<Connection> pool = new LinkedList<>();

    public ConnectionPool(int size) {
        this.maxSize = size;
    }

    public Connection borrowConnection() {
        if (!pool.isEmpty()) {
            return pool.removeFirst();
        }
        if (Count < maxSize) {
            Count++;
            return new Connection();
        }
        return null;
    }
    public void returnConnection(Connection connection) {
        if (connection != null && pool.size() < maxSize) {
            pool.addLast(connection);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool(2);

        Connection conn1 = pool.borrowConnection();
        conn1.connect();

        pool.returnConnection(conn1);
        Connection conn2 = pool.borrowConnection();
        conn2.connect();
    }
}