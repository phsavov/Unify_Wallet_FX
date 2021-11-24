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
import java.util.Objects;

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
    public void LogIn(ActionEvent event) throws IOException, SQLException {
        int loginAttempt;
        boolean loginSuccessful = false;

        String username = usernameField.getText();
        String password = passwordField.getText();
        UserDatabase db = new UserDatabase();

        loginAttempt = db.checkCredentials(username, password);
        if(loginAttempt == 2){

            if (db.isBlocked(username, password)){
                Alert blocked = new Alert(Alert.AlertType.ERROR);
                blocked.setHeaderText("Account Has Been Blocked");
                blocked.setContentText("ATTENTION USER\nYour Account has been blocked due to too many incorrect login attempts.\n Please hit the 'OK' button to enter your Mnemonic Phrase to unlock your Account.");
                blocked.showAndWait();
                // TODO make a page to enter the Mnemonic Phrase and then another page to change the password

                Parent root = FXMLLoader.load(getClass().getResource("mnemonicPage.fxml"));
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
            loginSuccessful = true;
        } else if (loginAttempt == 0){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("Invalid Username");
            error.setContentText("The Username cannot be located in the database\nPlease re-enter the credentials");
            error.showAndWait();
            usernameField.clear();
            passwordField.clear();
            loginSuccessful = false;
        } else if (loginAttempt == 1){
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("Invalid Password");
            error.setContentText("The Password is entered incorrectly\nPlease re-enter the credentials");
            error.showAndWait();
            usernameField.clear();
            passwordField.clear();

            loginSuccessful = false;
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

