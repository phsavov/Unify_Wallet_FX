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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class LogInPageController {

    @FXML
    TextField usernameField;
    @FXML
    PasswordField passwordField;
    @FXML
    Button logInButton;

    Stage stage;
    Scene scene;

    @FXML
    public void LogIn(ActionEvent event) throws IOException {
        boolean loginSuccessful = false;

        String username = usernameField.getText();
        String password = passwordField.getText();
        UserDatabase db = null;
        try {
            db = new UserDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            loginSuccessful = db.checkCredentials(username, password);
        } catch (SQLException e) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("Incorrect Inputs");
            error.setContentText("The Username or Password entered was Incorrect\nPlease re-enter the credentials");
            error.showAndWait();
            usernameField.clear();
            passwordField.clear();
        }

        if (loginSuccessful) {
            Parent root = FXMLLoader.load(getClass().getResource("mainPage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                stage.setUserData(db.getUserInfo(username, password));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }

    }
}
