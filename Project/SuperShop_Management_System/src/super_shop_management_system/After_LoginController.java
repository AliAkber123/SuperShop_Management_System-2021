
package super_shop_management_system;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class After_LoginController implements Initializable {

    @FXML
    private Button Import_btn;
    @FXML
    private Button Sell_btn;
    @FXML
    private Button Product_btn;
    @FXML
    private Button Employee_btn;
    @FXML
    private Button Credits_btn;
    @FXML
    private AnchorPane Back_btn;
    @FXML
    private Button Backbtn1;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Import_btn_Action(ActionEvent event) throws IOException {
        Parent After_Login = FXMLLoader.load(getClass().getResource("inputpage.fxml"));
        Scene src1 = new Scene (After_Login);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src1);
        app_primaryStage.show();
    }

    @FXML
    private void Sell_btn_Action(ActionEvent event) throws IOException {
        Parent After_Login = FXMLLoader.load(getClass().getResource("Selll.fxml"));
        Scene src1 = new Scene (After_Login);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src1);
        app_primaryStage.show();
    }

    @FXML
    private void Product_btn_Action(ActionEvent event) throws IOException {
        Parent After_Login = FXMLLoader.load(getClass().getResource("TableCurrentProducts.fxml"));
        Scene src1 = new Scene (After_Login);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src1);
        app_primaryStage.show();
    }

    @FXML
    private void Employee_btn_Action(ActionEvent event) throws IOException {
        Parent Credits = FXMLLoader.load(getClass().getResource("Employee.fxml"));
        Scene src2 = new Scene (Credits);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();
    }

    @FXML
    private void Credits_btn_Action(ActionEvent event) throws IOException {
        Parent Credits = FXMLLoader.load(getClass().getResource("Credits.fxml"));
        Scene src2 = new Scene (Credits);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src2);
        app_primaryStage.show();
    }

    @FXML
    private void Backbtn1_Action(ActionEvent event) throws IOException {
        Parent After_Login = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene src4 = new Scene (After_Login);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src4);
        app_primaryStage.show();
    }
    
}
