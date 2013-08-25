import java.sql.*;

public class JDBCfirst {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/test","twer","");
        statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from test.vaboo");
        writeResult(resultSet);
    }

    private void writeResult(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println(resultSet.getString("yourID"));
            System.out.println(resultSet.getString("yourName"));
        }
    }
}
