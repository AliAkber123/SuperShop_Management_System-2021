/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package super_shop_management_system;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asif Farrah
 */
public class UpdatetableController implements Initializable {
    int r;
    @FXML
    private TextField name;
    @FXML
    private TextField id;
    @FXML
    private TextField price;
    @FXML
    private TextField quantity;
    @FXML
    private TextField size;
    @FXML
    private TextField unit;
    @FXML
    private Label showPreviousEntry;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sumitDataEntry(ActionEvent event) {
        
            dbConnect db = new dbConnect();
            Connection conn = db.connect();
            
            String max = "SELECT ID FROM imports1;";
        try {
            PreparedStatement pstm = conn.prepareStatement(max);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
            r = rs.getInt("ID");
            }
        } catch (SQLException ex) {
            System.out.println("something wrong");
        }
        
            
         try{ 
             
             int error = Integer.parseInt(id.getText());
             System.out.println(r);
             if(error < r){
        if( !name.getText().equals("") ){
            String sql = "UPDATE imports1 SET NAME=? WHERE ID = ?";
            
        
            try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1,name.getText());
                pstmt.setInt(2, Integer.parseInt(id.getText()));
                pstmt.executeUpdate();
            }
            catch(SQLException ex){
                System.out.println("");
            }
            System.out.println("name not null"); 
            
        }
        if( !price.getText().equals("") ){
            String sql = "UPDATE imports1 SET  PRICE=? WHERE ID = ?";
            
        
            try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setDouble(1,Double.parseDouble(price.getText()));
                pstmt.setInt(2, Integer.parseInt(id.getText()));
                pstmt.executeUpdate();
            }
            catch(SQLException ex){
                System.out.println("");
            }
            System.out.println("price not null");    
        }
        if( !size.getText().equals("") ){
            String sql = "UPDATE imports1 SET  SIZE=? WHERE ID = ?";
            
        
            try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setDouble(1,Double.parseDouble(size.getText()));
                pstmt.setInt(2, Integer.parseInt(id.getText()));
                pstmt.executeUpdate();
            }
            catch(SQLException ex){
                System.out.println("");
            }
            System.out.println("size not null");    
        }
        if( !quantity.getText().equals("") ){
            String sql = "UPDATE imports1 SET  QUANTITY=? WHERE ID = ?";
            
        
            try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1,Integer.parseInt(quantity.getText()));
                pstmt.setInt(2, Integer.parseInt(id.getText()));
                pstmt.executeUpdate();
            }
            catch(SQLException ex){
                System.out.println("");
            }
            System.out.println("quantity not null");    
        }
        if( !unit.getText().equals("") ){
            String sql = "UPDATE imports1 SET  UNIT=? WHERE ID = ?";
            
        
            try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1,unit.getText());
                pstmt.setInt(2, Integer.parseInt(id.getText()));
                pstmt.executeUpdate();
            }
            catch(SQLException ex){
                System.out.println("");
            }
            System.out.println("unit not null");    
        }
        this.showPreviousEntry.setText(name.getText()+ " " +price.getText() + " " +quantity.getText() + " " +size.getText() + " " +unit.getText() + "'''Updated''' ");
        this.id.setText("");
        this.name.setText("");
        this.price.setText("");
        this.quantity.setText("");
        this.size.setText("");
        this.unit.setText("");
         }
             else{
                 Alert a = new Alert(Alert.AlertType.ERROR);
             a.setContentText("ID DOSE NOT EXIT");
             a.show();
             }
                 
         }
         catch(Exception e){
             Alert a = new Alert(Alert.AlertType.ERROR);
             a.setContentText("Please Enter correct Product ID or Datatype");
             a.show();
         }
         }
        
    

    @FXML
    private void back(ActionEvent event) throws IOException {
        Parent After_Login = FXMLLoader.load(getClass().getResource("TableCurrentProducts.fxml"));
        Scene src1 = new Scene (After_Login);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src1);
        app_primaryStage.show();
    }
    
}
