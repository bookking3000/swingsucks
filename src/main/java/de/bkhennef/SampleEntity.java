package de.bkhennef;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SampleEntity {

    int id;
    String name;
    String content;

    public SampleEntity(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void loadAll() throws SQLException {
        Statement statement = DBConn.getConnection().createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet rs = statement.executeQuery("SELECT * FROM users");

        while (rs.next()) {
            String name = rs.getString(2);
            String content = rs.getString(3);
        }
    }
}
