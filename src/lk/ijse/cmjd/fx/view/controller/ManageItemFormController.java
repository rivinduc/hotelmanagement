package lk.ijse.cmjd.fx.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.cmjd.fx.business.ManageCustomersBusiness;
import lk.ijse.cmjd.fx.business.ManageItemsBusiness;
import lk.ijse.cmjd.fx.business.ManageOrdersBusiness;
import lk.ijse.cmjd.fx.db.DBConnection;
import lk.ijse.cmjd.fx.dto.CustomerDTO;
import lk.ijse.cmjd.fx.dto.ItemDTO;
import lk.ijse.cmjd.fx.main.AppInitializer;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public class ManageItemFormController implements Initializable {

    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXTextField txtItemCode;
    @FXML
    private JFXTextField txtDescription;
    @FXML
    private JFXTextField txtUnitPrice;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private AnchorPane roots;
    @FXML
    private TableView<ItemDTO> tblItems;
    @FXML
    private JFXButton btnReport;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void navigateToHome(MouseEvent event) throws IOException {

    }

    @FXML
    private void btnSave_OnAction(ActionEvent event) throws Exception {
        ItemDTO itemModel2 =
                new ItemDTO(
                        txtItemCode.getText(),
                        txtDescription.getText(),
                        Double.parseDouble(txtUnitPrice.getText()),
                        Integer.parseInt(txtQty.getText())
                );
        boolean result= ManageItemsBusiness.updateItem(
                itemModel2
        );
        if (result){
            new Alert(Alert.AlertType.CONFIRMATION,
                    "Item Updated",
                    ButtonType.OK).showAndWait();
        }else {
            new Alert(Alert.AlertType.ERROR,
                    "Item Update Error",
                    ButtonType.OK).showAndWait();
        }
    }

    @FXML
    private void btnDelete_OnAction(ActionEvent event) throws Exception {
        String del_code = txtItemCode.getText();
        boolean result= ManageItemsBusiness.deleteItem(del_code);
        if (result){
            new Alert(Alert.AlertType.CONFIRMATION,
                    "Item Deleted",
                    ButtonType.OK).showAndWait();
        }else {
            new Alert(Alert.AlertType.ERROR,
                    "Item Deleting Error",
                    ButtonType.OK).showAndWait();
        }
    }

    @FXML
    private void btnAddNew_OnAction(ActionEvent actionEvent) throws Exception {
        ItemDTO itemModel =
                new ItemDTO(
                        txtItemCode.getText(),
                        txtDescription.getText(),
                        Double.parseDouble(txtUnitPrice.getText()),
                        Integer.parseInt(txtQty.getText())
                );
        boolean result= ManageItemsBusiness.createItem(
                itemModel
        );
        if (result){
            new Alert(Alert.AlertType.CONFIRMATION,
                    "Item Added Ok",
                    ButtonType.OK).showAndWait();
        }else {
            new Alert(Alert.AlertType.ERROR,
                    "Item Added Error",
                    ButtonType.OK).showAndWait();
        }
    }


    @FXML
    void tblItems_OnMouseClicked(MouseEvent event) {
        tblItems.getColumns().get(0)
                .setCellValueFactory(
                        new PropertyValueFactory<>("code")
                );
        tblItems.getColumns().get(1)
                .setCellValueFactory(
                        new PropertyValueFactory<>("description")
                );
        tblItems.getColumns().get(2)
                .setCellValueFactory(
                        new PropertyValueFactory<>("unitPrice")
                );
        tblItems.getColumns().get(3)
                .setCellValueFactory(
                        new PropertyValueFactory<>("qtyOnHand")
                );
        try {
            List<ItemDTO> itemDTOS=
                    ManageItemsBusiness.getItems();
            tblItems.setItems(FXCollections.observableList(itemDTOS));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnReport_OnAction(ActionEvent event) throws Exception {
        File file = new File("report/POS_Item_Report.jasper");
        JasperReport compiledReport = (JasperReport)
                JRLoader.loadObject(file);

        JasperPrint filledReport = JasperFillManager
                .fillReport(compiledReport,
                        null,
                        DBConnection.getConnection()
                );
        JasperViewer.viewReport(filledReport,false);
    }



    @FXML
    private void reset() {
        txtItemCode.clear();
        txtDescription.clear();
        txtUnitPrice.clear();
        txtQty.clear();
        txtItemCode.requestFocus();
        txtItemCode.setEditable(true);


    }


    public void navigateToHomes(MouseEvent event) throws IOException {


        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent roots = null;

            switch (icon.getId()) {
                case "hs":
                    roots = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/MainForm.fxml"));
                    break;

                case "fs":
                    roots = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/PlaceOrderForm.fxml"));
                    break;
                case "rs":
                    roots = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/ManageCustomerForm.fxml"));
                    break;
                case "ws":
                    roots = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/BanquetManagement.fxml"));
                    break;
                case "cs":
                    roots= FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/SearchOrderForm.fxml"));
                    break;

            }


            if (roots != null) {
                Scene subScene = new Scene(roots);
                Stage primaryStage = (Stage) this.roots.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }
    }

    public void ssaction(ActionEvent actionEvent) throws Exception{
        String s = txtItemCode.getText();
        System.out.println(s);
        String d1= ManageItemsBusiness.findItem(s).getDescription();
        double d3= Double.parseDouble(String.valueOf(ManageItemsBusiness.findItem(s).getUnitPrice()));
        int d2=ManageItemsBusiness.findItem(s).getQtyOnHand();
        txtDescription.setText(d1);
        txtUnitPrice.setText(String.valueOf(d3));
        txtQty.setText(String.valueOf(d2));
    }
}
