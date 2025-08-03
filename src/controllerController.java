import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.Socket;
import java.io.*;


public class controllerController {

    @FXML
    private TextField ip;

    @FXML
    private TextField port;

    @FXML
    private TextField resolution;



 

    private Stage stage;
    private Scene scene;
    private Parent root;
    

    @FXML
    void goBack(ActionEvent e) throws Exception {

        


        Parent root = FXMLLoader.load(getClass().getResource("select.fxml"));

       
       
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

    @FXML
    void monitory(ActionEvent e) throws Exception {

        
        String ipAddress = ip.getText();
        String portNumber = port.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("monitor.fxml"));
        Parent root = loader.load();

        monitorController mc = loader.getController();
        mc.setConnectionInfo(ipAddress, portNumber);
       
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.setMaximized(true);


    }

}
