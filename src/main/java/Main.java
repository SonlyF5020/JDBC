import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        JDBCfirst jdbCfirst = new JDBCfirst();
        jdbCfirst.readDataBase();

        jdbCfirst.put(5020, "mei");
        String value = jdbCfirst.get(5020);
        System.out.println(value);
    }
}
