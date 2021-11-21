package Unify;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class changePasswordPageController {

    @FXML
    PasswordField passwordField;
    @FXML
    PasswordField passwordConfirmField;
    @FXML
    Button enterButton;

    User user;
    Stage stage;
    Scene scene;

    @FXML
    public void changePassword(ActionEvent event) throws SQLException, IOException {
        String password, confirmPassword;

        UserDatabase database = new UserDatabase();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        user = (User) stage.getUserData();

        password = passwordField.getText();
        confirmPassword = passwordConfirmField.getText();

        if(password.equals(confirmPassword)){
            user.changePassword(password);
            database.changePassword(user);

            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
            confirmation.setHeaderText("Password Reset Confirmation");
            confirmation.setContentText("You have successfully changed your password!\n" +
                    "Once you hit 'OK' you will be redirected to the home page to log back in.");
            confirmation.showAndWait();

            Parent root = FXMLLoader.load(getClass().getResource("homePage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else {
            Alert diffPasswords = new Alert(Alert.AlertType.ERROR);
            diffPasswords.setHeaderText("Incorrect Inputs");
            diffPasswords.setContentText("Password does not match confirmation");
            diffPasswords.showAndWait();
            passwordField.clear();
            passwordConfirmField.clear();
        }
    }
}
