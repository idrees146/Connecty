import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class selectController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void controlPanel(ActionEvent e) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("controller.fxml"));

        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaximized(true);

        stage.show();

    }

    @FXML
    void waitPanel(ActionEvent event) throws Exception{
        

        root = FXMLLoader.load(getClass().getResource("wait.fxml"));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.setMaximized(true);

        stage.show();
    }

}
