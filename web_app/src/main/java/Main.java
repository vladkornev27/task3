public class Main {
    public static void main(String[] args) throws Exception {
        PostgresConnection postgresConnection = new PostgresConnection();
        ServerContainer serverContainer = new ServerContainer(postgresConnection);
        serverContainer.serverDrive();
    }
}
