import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;

public class Idrees {

    public static void main(String args[]) {

        try {
            ServerSocket server = new ServerSocket(5000);
            System.out.println("The server has started....waiting for client");

            Socket socket = server.accept();
            System.out.println("Connection Has been established Successfully");

            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            while (true) {
                BufferedImage screenshot = robot.createScreenCapture(screenRect);

              
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(screenshot, "jpg", baos);
                byte[] imageBytes = baos.toByteArray();

            
                dos.writeInt(imageBytes.length);

            
                dos.write(imageBytes);
                dos.flush();

           
                Thread.sleep(200);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
