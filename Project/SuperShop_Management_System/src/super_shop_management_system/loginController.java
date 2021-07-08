
package super_shop_management_system;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Asif Farrah
 */
public class loginController implements Initializable {

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
      Connection conn = null;
    ResultSet rs=null;
    PreparedStatement pst = null;
    
    
    
    public void LoginpaneShow(){
        
        pane_login.setVisible(true);
        pane_signup.setVisible(false);
        
    }
    
    public void SignuppaneShow(){
        
        pane_login.setVisible(false);
        pane_signup.setVisible(true);
        
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LoginpaneShow(ActionEvent event) {
            pane_login.setVisible(true);
        pane_signup.setVisible(false);
    }

    @FXML
    private void SignuppaneShow(ActionEvent event) {
        pane_login.setVisible(false);
        pane_signup.setVisible(true);
    }

    @FXML
    private void Login(ActionEvent event) {
        dbConnect db = new dbConnect();
        conn = db.connect();
        String sql = "Select * from users where username = ? and password = ? ";
        
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1,txt_username.getText());
            pst.setString(2, txt_pass.getText());
            rs= pst.executeQuery();
            
            if(rs.next()){
               // JOptionPane.showMessageDialog(null, "username and password is correct");
               
         Parent After_Login = FXMLLoader.load(getClass().getResource("After_Login.fxml"));
        Scene src1 = new Scene (After_Login);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src1);
        app_primaryStage.show();
                
            }
            else{
                JOptionPane.showMessageDialog(null,"invalid username and password");
            }
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    }

    @FXML
    private void add_users(ActionEvent event) throws IOException {
            dbConnect db = new dbConnect();
            conn = db.connect();
        String sql = "insert into users (username,password,email) values (?,?,?)";
        try{
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_username_up.getText());
            pst.setString(2, txt_pass_up.getText());
            pst.setString(3, txt_email_up.getText());
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Saved");  
        }catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
    }
    }
    
}
