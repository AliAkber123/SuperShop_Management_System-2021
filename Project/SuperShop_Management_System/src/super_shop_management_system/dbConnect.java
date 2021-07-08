
package super_shop_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.control.Alert;

public class dbConnect{
    public Connection connect() {
        // SQLite connection string
        String url = "jdbc:mysql://127.0.0.1/test";
        String user = "root";
        String pass = "";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insert(String name, double price, int quantity, double size, String unit) {
        // OPTINT means UNIT
            String sql = "INSERT INTO imports1(NAME, PRICE, QUANTITY, SIZE, UNIT, DATETIME) VALUES(?, ?, ?, ?, ?, now())";
            String sql2 = "INSERT INTO imports2(NAME, PRICE, QUANTITY, SIZE, UNIT, DATETIME) VALUES(?, ?, ?, ?, ?, now())";

        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setInt(3, quantity);
            pstmt.setDouble(4, size);
            pstmt.setString(5, unit);
            
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("INCORRECT DATA TYPE");
            a.show();
        }
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql2)) {
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setInt(3, quantity);
            pstmt.setDouble(4, size);
            pstmt.setString(5, unit);
            
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        
        }
        
    }

    /**
     * @param args the command line arguments
    public static void main(String[] args) {

        InsertApp app = new InsertApp();
        // insert three new rows
        app.insert("Raw Materials", 3000);
        app.insert("Semifinished Goods", 4000);
        app.insert("Finished Goods", 5000);
    }
     */


}
