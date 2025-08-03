import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;

public class waitingController {

    @FXML
    private Button back;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private ServerSocket server;
    private Socket socket;
    private volatile boolean running = true;
    private Thread serverThread;

    @FXML
    public void initialize() {
        startServer();
    }

    private void startServer() {
        serverThread = new Thread(() -> {
            try {
                server = new ServerSocket(5000);
                System.out.println("The server has started .... waiting for client");

                socket = server.accept();
                System.out.println("Connection has been established successfully");

                Robot robot = new Robot();
                Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                while (running) {
                    BufferedImage screenshot = robot.createScreenCapture(screenRect);

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(screenshot, "jpg", baos);
                    byte[] imageBytes = baos.toByteArray();

                    dos.writeInt(imageBytes.length);
                    dos.write(imageBytes);
                    dos.flush();

                    Thread.sleep(200);
                }

              
                dos.close();
                socket.close();
                server.close();
                System.out.println("Server stopped.");

            } catch (Exception e) {
                if (running) e.printStackTrace(); 
            }
        });

        serverThread.setDaemon(true);
        serverThread.start();
    }

    @FXML
    void goBack(ActionEvent event) throws Exception {
 
        running = false;
        try {
            if (socket != null) socket.close();
            if (server != null) server.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

      
        Parent root = FXMLLoader.load(getClass().getResource("select.fxml"));

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
