package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.InetAddress;
import java.util.Objects;

public class Controller {
    public Text descriptionBox;
    @FXML
    public Label ip_label;
    public InetAddress myIP;


    //    runs when the "join chat button is pressed"
    public void joinChat(ActionEvent actionEvent) throws Exception {
        System.out.println("Pressed button 2");
        // TODO open dialog for entering ip adress and username

        // opening dialogue for entering ip adress
        Stage dialog = new Stage();
        Parent root2 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("joinServer.fxml")));
        dialog.setTitle("join server");
        dialog.setScene(new Scene(root2, 200, 200));
        dialog.show();
    }

//    runs when the "host chat button is pressed"
    public void hostChat(ActionEvent actionEvent) throws Exception {
        // Todo all the code from the server side of the application
        try{
            InetAddress myIP = InetAddress.getLocalHost();
            System.out.print(myIP);

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        Stage chatWindow = new Stage();
        Parent root3 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("chatScreen.fxml")));
        chatWindow.setTitle("Fnatter");
        chatWindow.setScene(new Scene(root3, 500, 600));
        // TODO fnd out how to get to myIP Text Field
        ip_label.setText(myIP.toString());
        chatWindow.show();
    }

    public void leaveChat(ActionEvent actionEvent) {
        // leave chat
    }
}
