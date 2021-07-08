/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package super_shop_management_system;

import com.mysql.cj.protocol.Resultset;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asif Farrah
 */
public class SelllController implements Initializable {

    @FXML
    private Button Back_btn;
    @FXML
    private Button Submit_btn;
    @FXML
    private TextField ProductName;
    @FXML
    private TextField Quantity;
    @FXML
    private Text Size;
    @FXML
    private TextField ProductSize;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Back_btn_Action(ActionEvent event) throws IOException {
        Parent After_Login = FXMLLoader.load(getClass().getResource("After_Login.fxml"));
        Scene src1 = new Scene (After_Login);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src1);
        app_primaryStage.show();
    }

    @FXML
    private void Submit_btn_Action(ActionEvent event) throws SQLException {
        dbConnect dbobj= new dbConnect();
        Connection conn = dbobj.connect();
        String prdt = ProductName.getText();
        String q = Quantity.getText();
        int qq = Integer.parseInt(q);
        String qry = "select QUANTITY from imports1 where NAME = \'"+prdt+"\'";
        System.out.println(qry);
        String sql = "UPDATE imports1 SET QUANTITY=? WHERE NAME = ?";
            
        Statement stmt = conn.createStatement();
        try {
            ResultSet rset = stmt.executeQuery(qry);
            
            while(rset.next()){
               qq =  rset.getInt("QUANTITY")-qq;
               if(qq*2> qq){
                try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,qq );
            pstmt.setString(2, prdt);
            pstmt.executeUpdate();
            }
                catch(SQLException ex){
                    System.out.println("");
                }}
               else{
                   Alert ab = new Alert(Alert.AlertType.ERROR);
            
            ab.setContentText("You have less number of product");
            ab.show();
               }
                   }
        } catch (SQLException ex) {
            Logger.getLogger(SelllController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ProductName.setText("");
        ProductSize.setText("");
        Quantity.setText("");
        
    }

    @FXML
    private void ProductName_Action(ActionEvent event) {
    }


    @FXML
    private void Quantity_Action(ActionEvent event) {
    }

    @FXML
    private void Size_Action(ActionEvent event) {
    }
    
}
