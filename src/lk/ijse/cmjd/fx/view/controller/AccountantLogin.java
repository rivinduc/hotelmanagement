package lk.ijse.cmjd.fx.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AccountantLogin implements Initializable {
    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXTextField txtpassword;

    @FXML
    private JFXButton btnsignin;
    @FXML
    private AnchorPane rootaaa;

    public void btnsignin(ActionEvent actionEvent)throws Exception {
        String userName = txtname.getText();
        String password = txtpassword.getText();

        if (userName.trim().isEmpty() ) {
            new Alert(Alert.AlertType.INFORMATION, "Please Enter the UserName", ButtonType.OK).showAndWait();
            return;
        }
        if ( password.trim().isEmpty()) {
            new Alert(Alert.AlertType.INFORMATION, "Please Enter the Password", ButtonType.OK).showAndWait();
            return;
        }

        if (userName.equals("rivindu") && (password.equals("1234"))) {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/accountant.fxml"));
            Scene newScene = new Scene(root);
            Stage primeryStage = (Stage) btnsignin.getScene().getWindow();
            primeryStage.setScene(newScene);


        } else {
            new Alert(Alert.AlertType.INFORMATION, "User Name Or Password is wrong", ButtonType.OK).showAndWait();
            txtpassword.requestFocus();
            txtpassword.selectAll();
        }

    }
    public void sign(MouseEvent event) {
    }

    public void navigatetoHomeaaa(MouseEvent event)  throws IOException {


        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent rootaaa = null;

            switch (icon.getId()) {
                case "aaa":
                    rootaaa = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/MainForm.fxml"));
                    break;
            }


            if (rootaaa != null) {
                Scene subScene = new Scene(rootaaa);
                Stage primaryStage = (Stage) this.rootaaa.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

