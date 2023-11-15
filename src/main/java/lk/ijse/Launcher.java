package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

        lk.ijse.util.mailPack.Mail mail=new lk.ijse.util.mailPack.Mail(

        );
        mail.outMail();

    }

    public static void main(String[] args) {
        launch(args);
    }
}


