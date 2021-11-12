package Unify;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class WalletApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WalletApplication.class.getResource("homePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Unify Wallet");
        Image logo = new Image(WalletApplication.class.getResourceAsStream("Unify_Wallet_Logo.jpg"));
        stage.getIcons().add(logo);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}