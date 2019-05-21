package lk.ijse.cmjd.fx.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.cmjd.fx.main.AppInitializer;

import javax.swing.text.PasswordView;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

public class SignIn implements Initializable {

    @FXML
    private JFXTextField txtname;

    @FXML
    private JFXTextField txtpassword;

    @FXML
    private JFXButton btnsignin;
    @FXML
    private AnchorPane rootq;


    public void initialize() {

    }

    public void initialize(URL location, ResourceBundle resources) {

    }
    public void navigatetoHome(MouseEvent mouseEvent) throws Exception{



    }

    public void btnsignin(ActionEvent actionEvent) throws Exception {
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

        if (userName.equals("chamath") && (password.equals("1234"))) {
            Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/ManagementController.fxml"));
            Scene newScene = new Scene(root);
            Stage primeryStage = (Stage) btnsignin.getScene().getWindow();
            primeryStage.setScene(newScene);


        } else {
            new Alert(Alert.AlertType.INFORMATION, "User Name Or Password is wrong", ButtonType.OK).showAndWait();
            txtpassword.requestFocus();
            txtpassword.selectAll();
        }

    }

    public void sign(MouseEvent mouseEvent) throws Exception {
//        String v= txtname.getText();
//        String v2 = txtpassword.getText();
//        Parent root = null;
//        if(v.equals("ch")&&(v2.equals("1234"))
//        ){
//
//            root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/ManageCustomerForm.fxml"));
//
//        }
//        else {
//            new Alert(Alert.AlertType.ERROR,
//                    "Invalid Input",
//                    ButtonType.OK).showAndWait();
//        }
//    }
    }

    public void navigatetoHomeqq(MouseEvent event)
        throws IOException {


            if (event.getSource() instanceof ImageView) {
                ImageView icon = (ImageView) event.getSource();

                Parent rootq = null;

                switch (icon.getId()) {
                    case "qq":
                        rootq = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/MainForm.fxml"));
                        break;
                }


                if (rootq != null) {
                    Scene subScene = new Scene(rootq);
                    Stage primaryStage = (Stage) this.rootq.getScene().getWindow();
                    primaryStage.setScene(subScene);
                    primaryStage.centerOnScreen();

                    TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                    tt.setFromX(-subScene.getWidth());
                    tt.setToX(0);
                    tt.play();

                }
            }
        }
    }
