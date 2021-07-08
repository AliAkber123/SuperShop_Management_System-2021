package super_shop_management_system;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Super_Shop_Management_System extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
     Parent root=FXMLLoader.load(getClass().getResource("login.fxml"));
     Scene src = new Scene(root);
     primaryStage.setScene(src);
     primaryStage.setTitle("NSA Shop Manager");
     primaryStage.show();
     
    }


    public static void main(String[] args) {
        launch(args);
    }
    
}
