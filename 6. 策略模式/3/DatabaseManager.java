interface DatabaseStrategy {
    void connection();
}

class CassandraStrategy implements DatabaseStrategy {
    @Override
    public void connection() {
        System.out.println("Connecting to Cassandra");
    }
}

class MySQLStrategy implements DatabaseStrategy {
    @Override
    public void connection() {
        System.out.println("Connecting to MySQL");
    }
}

class PostgreSQLStrategy implements DatabaseStrategy {
    @Override
    public void connection() {
        System.out.println("Connecting to PostgreSQL");
    }
}

public class DatabaseManager {
    private DatabaseStrategy databaseStrategy;

    public DatabaseManager() {
    }

    public void setDatabaseStrategy(DatabaseStrategy databaseStrategy) { this.databaseStrategy = databaseStrategy; }
    public void connect() {
        databaseStrategy.connection();
    }
    public static void main(String[] args) {
        DatabaseManager p = new DatabaseManager();
        p.setDatabaseStrategy(new CassandraStrategy());
        p.connect(); // 顯示 "Connecting to Cassandra"

        p = new DatabaseManager();
        p.setDatabaseStrategy(new MySQLStrategy());
        p.connect(); // 顯示 "Connecting to MySQL"

        p = new DatabaseManager();
        p.setDatabaseStrategy(new PostgreSQLStrategy());
        p.connect(); // 顯示 "Connecting to PostgreSQL"
    }

}
