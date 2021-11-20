package Unify;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

public class MainPageController {

    @FXML
    Label cardanoPrice;
    @FXML
    Label displayTotal;

    protected User user;
    double cardanoCurrentPrice;

    /**
     * Update the cardano price
     * @param event
     */
    @FXML
    public void refreshButtonPushed(ActionEvent event){
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        user = (User) stage.getUserData();
        cardanoCurrentPrice = user.currentADAMarketPrice();
        cardanoPrice.setText(String.valueOf(cardanoCurrentPrice));
        displayTotal.setText(String.valueOf(user.getAccountTotal()));
    }

    @FXML
    public void sendButtonPushed(){

    }

    @FXML
    public void generateAddressButtonPushed(/*ActionEvent event*/) {
    }

    @FXML
    public void ADDButtonPushed(/*ActionEvent event*/) {
    }
}
