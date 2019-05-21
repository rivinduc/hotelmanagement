package lk.ijse.cmjd.fx.view.controller;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ManagementController {
    @FXML
    private AnchorPane rooty;


    public void navigateToHomey(MouseEvent event)throws IOException, URISyntaxException {
        if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();

            Parent rooty = null;

            switch(icon.getId()){
                case "hy":
                    rooty = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/MainForm.fxml"));
                    break;
                case "ry":
                    rooty = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/ManageCustomerForm.fxml"));
                    break;
                case "fy":
                    rooty = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/PlaceOrderForm.fxml"));
                    break;
                case "wy":
                    rooty = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/BanquetManagement.fxml"));
                    break;
                case "sy":
                    rooty = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/ManageItemForm.fxml"));
                    break;
                case "cy":
                    rooty = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/SearchOrderForm.fxml"));
                    break;
                case "ay":
                    rooty = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/accountant.fxml"));
                    break;
                case "weby":
                    Desktop d = Desktop.getDesktop();
                    d.browse(new URI("http://localhost:56519/POS-System/lk/ijse/cmjd/fx/view/SignUp.html?_ijt=8vj5061f4bvhssaofto7pis2d9"));

                    break;
            }

            if (rooty != null){
                Scene subScene = new Scene(rooty);
                Stage primaryStage = (Stage) this.rooty.getScene().getWindow();
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
