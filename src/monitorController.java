import java.net.Socket;
import java.io.DataInputStream;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class monitorController {

    private String ip;
    private int port;

    @FXML
    private ImageView imageView;

    @FXML
    private VBox vbox;

    @FXML
    public void initialize() {
      
        imageView.fitWidthProperty().bind(vbox.widthProperty());

      
        imageView.fitHeightProperty().bind(
                vbox.heightProperty().subtract(40).multiply(0.95));

        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        imageView.setCache(true);
    }

    public void setConnectionInfo(String ip, String port) {
        this.ip = ip;
        this.port = Integer.parseInt(port);
        connectToServer();
    }

    private void connectToServer() {
        new Thread(() -> {
            try (Socket socket = new Socket(ip, port)) {
                System.out.println("Connected to: " + ip + ":" + port);

                DataInputStream dis = new DataInputStream(socket.getInputStream());

                while (true) {
                 
                    int length = dis.readInt();
                    if (length <= 0) {
                        continue;
                    }
 
                    byte[] imageBytes = new byte[length];
                    dis.readFully(imageBytes);

                  
                    Image image = new Image(new java.io.ByteArrayInputStream(imageBytes));
                    javafx.application.Platform.runLater(() -> {
                        imageView.setImage(image);
                    });
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
