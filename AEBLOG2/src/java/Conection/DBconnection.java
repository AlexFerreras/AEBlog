package Conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author alexf
 */
public class DBconnection {

    private final String host = "localhost";
    private final String user = "root";
    private final String password = "123456";
    private final String db = "blogdb";
    protected Connection con;
    protected PreparedStatement estado;
    protected ResultSet rs;
    public String sql;
    Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    protected String fecha = dateFormat.format(date);

    public DBconnection() {
    }

    public void Conectar() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://" + host + "/" + db + "?user=" + user + "&password=" + password;
        con = DriverManager.getConnection(url);
     
    }

    public void Desconectar() throws SQLException {

        try {
            if (con != null) {
                con.close();
            }
            if (estado != null) {
                estado.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("desconecte!");
        }

    }

}
