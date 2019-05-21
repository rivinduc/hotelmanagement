package lk.ijse.cmjd.fx.view.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.cmjd.fx.business.ManageBanquetBusiness;
import lk.ijse.cmjd.fx.business.ManageCleanBusiness;
import lk.ijse.cmjd.fx.dao.custom.CleanDAO;
import lk.ijse.cmjd.fx.dto.CleanDTO;
import lk.ijse.cmjd.fx.entity.Clean;
import lk.ijse.cmjd.fx.main.AppInitializer;
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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.cmjd.fx.business.ManageCustomersBusiness;
import lk.ijse.cmjd.fx.business.ManageItemsBusiness;
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
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.io.IOException;

public class SearchOrderFormController implements Initializable {

    @FXML
    private JFXTextField txtSearchOrder;
    @FXML
    private AnchorPane rootss;
    @FXML
    private TableView<CleanDTO> tblOrders;

    private ObservableList<?> olOrders;
    @FXML
    private JFXDatePicker Date;
    @FXML
     private  JFXTextField txtItemCode;

    @FXML
    private JFXTextField txtDescription;
    @FXML
    private ComboBox<String> combostate;

    public void initialize(){

    }


    @FXML
    private void txtOrderId_OnKeyReleased(KeyEvent keyEvent) {
    }

    @FXML
    private void navigateToHome(MouseEvent mouseEvent) throws IOException {

    }
    @FXML
    private void btnSave_OnAction(ActionEvent event) throws Exception {
        String f1= (combostate.getValue());
        CleanDTO cleanModel2 =
                new CleanDTO(
                        txtItemCode.getText(),
                        txtDescription.getText(),

                        Date.getValue(),
                        f1
                );
        boolean result= ManageCleanBusiness.updateClean(
                cleanModel2
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
        boolean result= ManageCleanBusiness.deleteClean(del_code);
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
        String f1= (combostate.getValue());
        CleanDTO cleanModel =
                new CleanDTO(
                        txtItemCode.getText(),
                        txtDescription.getText(),

                        Date.getValue(),
                        f1
                );
        boolean result= ManageCleanBusiness.createClean(
                cleanModel
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

    public void update(ActionEvent actionEvent) {
    }

    public void navigateToHomess(MouseEvent event)  throws IOException {


        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent rootss = null;

            switch (icon.getId()) {
                case "hss":
                    rootss = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/MainForm.fxml"));
                    break;

                case "fss":
                    rootss = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/PlaceOrderForm.fxml"));
                    break;
                case "rss":
                    rootss = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/ManageCustomerForm.fxml"));
                    break;
                case "wss":
                    rootss = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/BanquetManagement.fxml"));
                    break;
                case "sss":
                    rootss= FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/ManageItemForm.fxml"));
                    break;

            }


            if (rootss != null) {
                Scene subScene = new Scene(rootss);
                Stage primaryStage = (Stage) this.rootss.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }
    }

    @FXML
    void tblOrders_OnMouseClicked(MouseEvent event) {
        tblOrders.getColumns().get(0)
                .setCellValueFactory(
                        new PropertyValueFactory<>("code")
                );
        tblOrders.getColumns().get(2)
                .setCellValueFactory(
                        new PropertyValueFactory<>("description")
                );
        tblOrders.getColumns().get(1)
                .setCellValueFactory(
                        new PropertyValueFactory<>("f1")
                );
        tblOrders.getColumns().get(3)
                .setCellValueFactory(
                        new PropertyValueFactory<>("Date")
                );
        try {
            List<CleanDTO> cleanDTOS=
                    ManageCleanBusiness.getItems();
            tblOrders.setItems(FXCollections.observableList(cleanDTOS));
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

        txtItemCode.requestFocus();
        txtItemCode.setEditable(true);


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        combostate.setItems(list);
    }
    ObservableList <String> list =FXCollections.observableArrayList(
            "Cleaned","Not Cleaned",
            "Issu"
    );


    public void e0(InputMethodEvent inputMethodEvent) {


    }

    public void e1(KeyEvent keyEvent) {


    }

    public void e2(KeyEvent keyEvent) throws  Exception{

    }

    public void e3(KeyEvent keyEvent) {

    }

    public void dd(KeyEvent keyEvent)throws  Exception {


    }

    public void d1(KeyEvent keyEvent) throws Exception {

    }

    public void findclean(MouseEvent event) throws Exception {
        String del_code = txtSearchOrder.getText();
        String d=  ManageCleanBusiness.findClean(del_code).getCode();
        String d1=  ManageCleanBusiness.findClean(del_code).getDescription();
        LocalDate d2=  ManageCleanBusiness.findClean(del_code).getDate();
        String d3=  ManageCleanBusiness.findClean(del_code).getF1();

       txtItemCode.setText(d);
       txtDescription.setText(d1);
       Date.setValue(d2);
       combostate.setValue(d3);
    }

    public void find(ActionEvent actionEvent) throws Exception {

        String del_code = txtSearchOrder.getText();
        String d0= ManageCleanBusiness.findClean(del_code).getCode();
        String d1= ManageCleanBusiness.findClean(del_code).getDescription();
        LocalDate d4=  ManageCleanBusiness.findClean(del_code).getDate();
        txtItemCode.setText(d0);
        txtDescription.setText(d1);
        Date.setValue(d4);
    }

    public void ds(ActionEvent actionEvent) throws Exception {
        String del_code = txtItemCode.getText();
        String d0= ManageCleanBusiness.findClean(del_code).getCode();
        String d1= ManageCleanBusiness.findClean(del_code).getDescription();
        LocalDate d4=  ManageCleanBusiness.findClean(del_code).getDate();
        txtSearchOrder.setText(d0);
        txtDescription.setText(d1);
        Date.setValue(d4);
    }
}
