import java.util.*;

class Connection {
    public void connect() {
        System.out.println("Connected successfully.");
    }
}

class ConnectionPool {
    private LinkedList<Connection> pool = new LinkedList<>();
    private Set<Connection> using = new HashSet<>();

    public ConnectionPool(int maxSize) {
        for (int i = 0; i < maxSize; i++) {
            pool.add(new Connection());
        }
    }

    public Connection borrowConnection() {
        if (!pool.isEmpty()) {
            Connection connection = pool.removeFirst();
            using.add(connection);
            return connection;
        }

        return null;
    }

    public void returnConnection(Connection conn) {
        if (!using.contains(conn)) {
            System.out.println("Warning: This connection was not borrowed from the pool.");
        } else {
            pool.add(conn);
            using.remove(conn);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool(1);

        Connection conn1 = pool.borrowConnection();
        conn1.connect();

        pool.returnConnection(conn1);
        pool.returnConnection(conn1);

    }
}