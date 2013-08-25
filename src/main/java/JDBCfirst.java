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
        connection.close();
    }


    private void writeResult(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.println(resultSet.getString("yourID"));
            System.out.println(resultSet.getString("yourName"));
            System.out.println(resultSet.getString("pointID"));
        }
    }

    public void put(int key, String value) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/test", "twer", "");
        statement = connection.createStatement();
        String insertSentense = "insert into test.map values("+key+",'"+value+"');";
        statement.execute(insertSentense);
        connection.close();
    }

    public String get(int key) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/test","twer","");
        statement = connection.createStatement();
        resultSet = statement.executeQuery("select * from test.map");
        if (resultSet.next()){
            return resultSet.getString(2);
        }
        return "";
    }
}
