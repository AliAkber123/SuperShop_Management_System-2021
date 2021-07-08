/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package super_shop_management_system;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asif Farrah
 */
public class TableCurrentProductsController implements Initializable {

    @FXML
    private TableView<dbModel> Tb1;
    @FXML
    private TableColumn<dbModel, String> nametb1;
    @FXML
    private TableColumn<dbModel, String> pricetb1;
    @FXML
    private TableColumn<dbModel, String> quantitytb1;
    @FXML
    private TableColumn<dbModel, String> sizetb1;
    @FXML
    private TableColumn<dbModel, String> unittb1;
    @FXML
    private TableColumn<dbModel, String> datetimetb1;
    @FXML
    private TableColumn<dbModel, String> idtb1;
    
    ObservableList<dbModel> oblist = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            dbConnect db = new dbConnect();
            Connection conn = db.connect();
            ResultSet rs = conn.createStatement().executeQuery("select * from imports1");
            while(rs.next()){
                int x = rs.getInt("ID");
                Integer y = new Integer(x);
                String str = y.toString();
                Double d = rs.getDouble("SIZE");
                
                String ddd = d.toString();
                Double p = rs.getDouble("PRICE");
                
                String ppp = p.toString();
                String uni = rs.getString("UNIT");
                int q = rs.getInt("QUANTITY");
                Integer qq = new Integer(q);
                String qqq = qq.toString();
                
                
                
                oblist.add(new dbModel(str, rs.getString("name"),  ppp,qqq, ddd, uni, rs.getTimestamp("DATETIME").toString()));
            }} catch (SQLException ex) {
            Logger.getLogger(TableCurrentProductsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        nametb1.setCellValueFactory(new PropertyValueFactory<>("name"));
        pricetb1.setCellValueFactory(new PropertyValueFactory<>("price"));
        idtb1.setCellValueFactory(new PropertyValueFactory<>("id"));
        unittb1.setCellValueFactory(new PropertyValueFactory<>("unit"));
        sizetb1.setCellValueFactory(new PropertyValueFactory<>("size"));
        quantitytb1.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        datetimetb1.setCellValueFactory(new PropertyValueFactory<>("datetime"));
        Tb1.setItems(oblist);
    }    
     @FXML
    private void back2main(ActionEvent event) throws IOException {
        Parent After_Login = FXMLLoader.load(getClass().getResource("After_Login.fxml"));
        Scene src1 = new Scene (After_Login);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src1);
        app_primaryStage.show();
    }

    @FXML
    private void updatae2main(ActionEvent event) throws IOException {
            Parent After_Login = FXMLLoader.load(getClass().getResource("updatetable.fxml"));
        Scene src1 = new Scene (After_Login);
        Stage app_primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_primaryStage.setScene(src1);
        app_primaryStage.show();
    }
    
}
