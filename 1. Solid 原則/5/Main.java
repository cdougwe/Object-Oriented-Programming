interface Database {
    void connect();
}

class PostgreSQLDatabase implements Database {
    @Override
    public void connect() {
        System.out.println("連接 PostgreSQL");
    }
}

class MySQLDatabase implements Database {
    public void connect() {
        System.out.println("連接 MySQL");
    }
}

class Application {
    private Database database;

    public Application(Database database) {
        this.database = database;
    }
    public void start() {
        database.connect();
    }
}

class Main {
    public static void main(String[] args) {
        Database database = new MySQLDatabase();
        Application app = new Application(database);
        app.start();

        database = new PostgreSQLDatabase();
        app = new Application(database);
        app.start();
    }
}