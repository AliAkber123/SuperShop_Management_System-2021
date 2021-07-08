
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main_GUIController implements Initializable {

    private TextField txtfld_userID;
    private PasswordField passfld_pass;
    @FXML
    private AnchorPane pane_login;
    @FXML
    private TextField txt_username;
    @FXML
    private PasswordField txt_pass;
    @FXML
    private Button btn_login;
    @FXML
    private AnchorPane pane_signup;
    @FXML
    private TextField txt_username_up;
    @FXML
    private TextField txt_pass_up;
    @FXML
    private TextField txt_email_up;
    @FXML
    private Button btn_signup;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    


    private void btn_submit_Action(ActionEvent event)throws IOException {
        if("".equals(txtfld_userID.getText()) & "".equals(passfld_pass.getText()) ){
            
        Parent After_Login = FXMLLoader.load(getClass().getResource("After_Login.fxml"));
        Scene src1 = new Scene (After_Login);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src1);
        app_primaryStage.show();
        }else{
            Alert a = new Alert(AlertType.NONE);
            a.setAlertType(AlertType.ERROR);
            a.setContentText("INCORRECT PASSWORD or USERNAME");
            a.show();
        }

    }

    @FXML
    private void LoginpaneShow(ActionEvent event) {
    }

    @FXML
    private void SignuppaneShow(ActionEvent event) {
    }

    @FXML
    private void Login(ActionEvent event) {
    }

    @FXML
    private void add_users(ActionEvent event) {
    }

 
    
}
