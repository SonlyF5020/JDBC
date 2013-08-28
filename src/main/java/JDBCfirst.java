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
        while (resultSet.next()) {}
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
        resultSet = statement.executeQuery("select mapValue from test.map WHERE mapKey="+key+";");
        if (resultSet.next()){
            //here the "1" in getString() means the first column in result sub-table.
            //since I selected only one column "mapValue" , so the result sub-table contains only one column
            //so if I use getString(2), it will come out some exceptions.

            // GOT IT!!
            return resultSet.getString(1);
        }
        return "";
    }
}
