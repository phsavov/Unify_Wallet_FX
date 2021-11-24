package Unify;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


/*HEI*/

public class HomePageController {

    private Scene scene;
    private Parent root;
    private Stage stage;

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void logInButton(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("logInPage.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param event
     * @throws IOException
     */
    @FXML
    public void createAccountButton(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("createAccountPage.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
