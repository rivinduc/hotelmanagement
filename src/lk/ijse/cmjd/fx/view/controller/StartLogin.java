package lk.ijse.cmjd.fx.view.controller;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.cmjd.fx.main.AppInitializer;

import javax.swing.text.PasswordView;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
public class StartLogin implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private JFXTextField un;

    @FXML
    private JFXTextField pw;

    @FXML
    private JFXButton btnsignIn;

    @FXML
    private AnchorPane rootl;

    public void initialize() {

    }


    public void vx(ActionEvent actionEvent) throws Exception {

    }


    public void btnsignIn(ActionEvent actionEvent)  throws Exception {
        String userName = un.getText();
        String password = pw.getText();

        if (userName.trim().isEmpty() ) {
            new Alert(Alert.AlertType.INFORMATION, "Please Enter the UserName", ButtonType.OK).showAndWait();
            return;
        }
        if ( password.trim().isEmpty()) {
            new Alert(Alert.AlertType.INFORMATION, "Please Enter the Password", ButtonType.OK).showAndWait();
            return;
        }

        if (userName.equals("chamath") && (password.equals("1234"))) {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/MainForm.fxml"));
            Scene newScene = new Scene(root);
            Stage primeryStage = (Stage) btnsignIn.getScene().getWindow();
            primeryStage.setScene(newScene);


        } else {
            new Alert(Alert.AlertType.INFORMATION, "User Name Or Password is wrong", ButtonType.OK).showAndWait();
            pw.requestFocus();
            pw.selectAll();
        }

    }

    public void unaction(ActionEvent actionEvent) {
        pw.requestFocus();
    }

    public void pwonaction(ActionEvent actionEvent) throws IOException {
        String userName = un.getText();
        String password = pw.getText();

        if (userName.trim().isEmpty() ) {
            new Alert(Alert.AlertType.INFORMATION, "Please Enter the UserName", ButtonType.OK).showAndWait();
            un.requestFocus();
            return;
        }
        if ( password.trim().isEmpty()) {
            new Alert(Alert.AlertType.INFORMATION, "Please Enter the Password", ButtonType.OK).showAndWait();
            pw.requestFocus();
            return;
        }

        if (userName.equals("chamath") && (password.equals("1234"))) {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/MainForm.fxml"));
            Scene newScene = new Scene(root);
            Stage primeryStage = (Stage) btnsignIn.getScene().getWindow();
            primeryStage.setScene(newScene);


        } else {
            new Alert(Alert.AlertType.INFORMATION, "User Name Or Password is wrong", ButtonType.OK).showAndWait();
            pw.requestFocus();
            pw.selectAll();
        }
    }
}
