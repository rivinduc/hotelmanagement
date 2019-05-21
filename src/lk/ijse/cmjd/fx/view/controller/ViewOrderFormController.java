package lk.ijse.cmjd.fx.view.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class ViewOrderFormController {
    @FXML
    private JFXDatePicker txtOrderDate;
    @FXML
    private JFXTextField txtOrderID;
    @FXML
    private JFXTextField txtCustomerID;
    @FXML
    private JFXTextField txtItemCode;
    @FXML
    private JFXTextField txtCustomerName;
    @FXML
    private JFXTextField txtDescription;
    @FXML
    private JFXTextField txtQtyOnHand;
    @FXML
    private JFXTextField txtUnitPrice;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private TableView<?> tblOrderDetails;
    @FXML
    private Label lblTotal;

    private String orderId;

    @FXML
    private void navigateToMain(MouseEvent mouseEvent) throws IOException {

        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/SearchOrderForm.fxml"));
        Scene mainScene = new Scene(root);
        Stage mainStage = (Stage) lblTotal.getScene().getWindow();
        mainStage.setScene(mainScene);

        TranslateTransition tt1 = new TranslateTransition(Duration.millis(300), root.lookup("AnchorPane"));
        tt1.setToX(0);
        tt1.setFromX(-mainScene.getWidth());
        tt1.play();

        mainStage.centerOnScreen();
    }

    public void initialize() {

    }
}
