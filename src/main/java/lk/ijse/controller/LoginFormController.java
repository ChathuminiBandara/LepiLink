package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.util.mailPack.Mail;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Optional;

public class LoginFormController {

    public AnchorPane root;
    public TextField username;
    public PasswordField password;

    public void loginOnAction(ActionEvent actionEvent) throws IOException {
        String enteredUsername = username.getText();
        String enteredPassword = password.getText();

        // Check if the entered credentials are correct
        if ("visitor".equals(enteredUsername) && "1234".equals(enteredPassword)) {
            // After the user has successfully logged in, prompt for email
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Email Input");
            dialog.setHeaderText("Enter your email address (optional)");
            dialog.setContentText("Email:");

            Optional<String> result = dialog.showAndWait();
            result.ifPresent(email -> {
                try {
                    if (!email.isEmpty()) {
                        sendEmail(email);
                    }
                } catch (MessagingException | IOException e) {
                    new Alert(Alert.AlertType.ERROR, "Failed to send email: " + e.getMessage()).show();
                }
            });

            // Your existing code to load the dashboard
            try {
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Alldashboards/visitordashboard.fxml"));
                Scene scene = new Scene(pane);
                Stage stage = (Stage) root.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
            } catch (IOException e) {
                e.printStackTrace(); // Handle this exception appropriately in a real application
            }
        } else {
            // Incorrect credentials, show an error message
            new Alert(Alert.AlertType.ERROR, "Invalid username or password").show();
        }
    }

    private void sendEmail(String email) throws MessagingException, IOException {
        // Create an instance of the Mail class
        Mail mail = new Mail();
        mail.setTo(email);
        mail.setSubject("Login Notification");
        mail.setMsg("Thank you for logging into the application!");

        // You may want to customize the message and subject as needed.

        // Call the run method to send the email
        mail.outMail();
    }

    public void adminEmpOnAction(ActionEvent actionEvent) {
        try {
            Stage currentStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/users/chooseUser_login.fxml"));
            AnchorPane anchorPane = loader.load();
            Stage newStage = new Stage();
            newStage.setTitle("Choose User");
            newStage.setScene(new Scene(anchorPane));
            currentStage.close();
            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
