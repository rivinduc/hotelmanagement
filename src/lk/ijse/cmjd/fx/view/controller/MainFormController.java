package lk.ijse.cmjd.fx.view.controller;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MainFormController implements Initializable { 
    
    @FXML
    private AnchorPane root;
    @FXML
    private ImageView imgCustomer;
    @FXML
    private ImageView imgItem;
    @FXML
    private ImageView imgOrder;
    @FXML
    private ImageView imgViewOrders;

    @FXML
    private Label lblMenu;
    @FXML
    private Label lblDescription;    

    /**
     * Initializes the business class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }    

    @FXML
    private void playMouseExitAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play(); 
            
            icon.setEffect(null);
            lblMenu.setText("Welcome");
            lblDescription.setText("Please select one of above main operations to proceed");
        }
    }

    @FXML
    private void playMouseEnterAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            
            switch(icon.getId()){
                case "imgCustomer":
                    lblMenu.setText("Reservation");
                    lblDescription.setText("Click to add, update, delete, search or view guest");
                    break;
                case "imgItem":
                    lblMenu.setText("Store Room");
                    lblDescription.setText("Click here if you want to place a new order");
                    break;
                case "imgOrder":
                    lblMenu.setText("Food & Beverage");
                    lblDescription.setText("Click to add, edit, delete, search or view items");
                    break;
                case "imgViewOrders":
                    lblMenu.setText("House Keeping");
                    lblDescription.setText("Click View Room States");
                    break;
                case "imgSettings":
                    lblMenu.setText("Management Settings");
                    lblDescription.setText("Click here to Management Settings");
                    break;
                case "imgSettings1":
                    lblMenu.setText("Visit Us");
                    lblDescription.setText("Click here to Visit Web & Reservation Details");
                    break;
                case "wedding":
                    lblMenu.setText("Banquet Management");
                    lblDescription.setText("Click to add, update, delete, search or view Banquet Management");
                    break;
                case "store":
                    lblMenu.setText("Store Room");
                    lblDescription.setText("Click here to view Store Room Details");
                    break;
                case "acc":
                    lblMenu.setText("Account Details");
                    lblDescription.setText("Click here to Visit Account Details");
                    break;

            }
            
            ScaleTransition scaleT =new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play(); 
            
            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);            
        }
    }  
    
    
@FXML
    private void navigate(MouseEvent event) throws IOException, URISyntaxException {
        if (event.getSource() instanceof ImageView){
            ImageView icon = (ImageView) event.getSource();
            
            Parent root = null;
            
            switch(icon.getId()){
                case "wedding":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/BanquetManagement.fxml"));
                    break;
                case "imgCustomer":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/ManageCustomerForm.fxml"));
                    break;
                case "imgItem":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/ManageItemForm.fxml"));
                    break;
                case "imgOrder":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/PlaceOrderForm.fxml"));
                    break;
                case "imgViewOrders":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/SearchOrderForm.fxml"));
                    break;
                case "imgSettings":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/ManagerLogin.fxml"));
                    break;
                case "acc":
                    root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/accountantLogin.fxml"));
                    break;
                case "imgSettings1":
                    Desktop d = Desktop.getDesktop();
                    d.browse(new URI("http://localhost:55063/POS-System/lk/ijse/cmjd/fx/view/SignUp.html?_ijt=8vj5061f4bvhssaofto7pis2d9"));

                    break;
            }
            
            if (root != null){
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.root.getScene().getWindow();
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
