/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package super_shop_management_system;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class InputpageController implements Initializable {

    @FXML
    private TextField name;
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

    @FXML
    private void sumitDataEntry(ActionEvent event) {
        if(!(name.getText().equals("")||price.getText().equals("")||unit.getText().equals("")||size.getText().equals("")||quantity.getText().equals(""))){
            
        
        System.out.println(this.name.getText());
        System.out.println(this.price.getText());
        System.out.println(this.quantity.getText());
        System.out.println(this.size.getText());
        System.out.println(this.unit.getText());
        
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            
            a.setContentText("CONFIRM ENTERED DATA");
            Optional<ButtonType> res = a.showAndWait();
         if(res.get()== ButtonType.OK){   
        dbConnect d = new dbConnect();
        try{
             System.out.println(Double.parseDouble(price.getText())+ "  " + Integer.parseInt(quantity.getText())+" " + Double.parseDouble(size.getText()));
        d.insert(name.getText(), Double.parseDouble(price.getText()), Integer.parseInt(quantity.getText()), Double.parseDouble(size.getText()), unit.getText());
        this.showPreviousEntry.setText(name.getText()+ " " +price.getText() + " " +quantity.getText() + " " +size.getText() + " " +unit.getText());
        }
        
        catch(Exception e){
            Alert ab = new Alert(Alert.AlertType.ERROR);
            
            ab.setContentText("INCORRECT ENTRY");
            ab.show();
        }
        this.name.setText("");
        this.price.setText("");
        this.quantity.setText("");
        this.size.setText("");
        this.unit.setText("");
         }
        
    }else{
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("NO FIELD CAN BE NULL!!!");
            a.show();
        }}
      @FXML
    private void back(ActionEvent event) throws IOException {
        Parent After_Login = FXMLLoader.load(getClass().getResource("After_Login.fxml"));
        Scene src1 = new Scene (After_Login);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src1);
        app_primaryStage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
    
}
