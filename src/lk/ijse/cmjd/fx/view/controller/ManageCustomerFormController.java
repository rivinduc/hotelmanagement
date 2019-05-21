package lk.ijse.cmjd.fx.view.controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import  javafx.scene.control.Button;
import java.awt.*;
import javafx.scene.Scene;
import java.awt.Label;
import java.lang.ref.Reference;
import java.time.LocalDate;
import java.util.Collection;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.cmjd.fx.business.ManageCleanBusiness;
import lk.ijse.cmjd.fx.business.ManageCustomersBusiness;
import lk.ijse.cmjd.fx.dto.CustomerDTO;
import lk.ijse.cmjd.fx.db.DBConnection;
import lk.ijse.cmjd.fx.main.AppInitializer;
import lk.ijse.cmjd.fx.view.controller.Calculator.CalculatorForm;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.*;
import java.util.List;
import java.util.List.*;

import static javafx.application.Application.launch;

public class ManageCustomerFormController implements Initializable {

    @FXML
    private JFXButton btnSave;
    @FXML
    private JFXButton btnDelete;
    @FXML
    private AnchorPane root;
    @FXML
    private AnchorPane root1;
    @FXML
    private JFXTextField lable;
    @FXML
    private JFXTextField lable1;
    @FXML
    private JFXTextField lable2;
    @FXML
    private JFXTextField label3;
    @FXML
    private JFXTextField label31;
    @FXML
    private JFXTextField label4;
    @FXML
    private JFXTextField txtCustomerId;
    @FXML
    private JFXTextField daysi1;
    @FXML
    private JFXTextField rn;
    @FXML
    private JFXTextField label41;
    @FXML
    private JFXTextField txtCustomerName;
    @FXML
    private ComboBox<String> combobox1;
    @FXML
    private ComboBox<String> combobox2;
    @FXML
    private JFXTextField days;
    @FXML
    private JFXTextField daysi;
    @FXML
    private JFXTextField txtCustomerName1;
    @FXML
    private JFXTextField txtCustomerAddress;
    @FXML
    private ComboBox<String> combomeal;
    @FXML
    private TableView<CustomerDTO> tblCustomers;
    @FXML
    private JFXDatePicker Date2;
    @FXML
    private JFXDatePicker Date1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), root1);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
        combobox1.setItems(list);
        combobox2.setItems(list2);
        combomeal.setItems(list1);

    }
    @FXML
    void tblCustomers_OnMouseClicked(MouseEvent  event) {
       email();

    }


    @FXML
    private void navigateToHome(MouseEvent event) throws IOException {


        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent root1 = null;

            switch (icon.getId()) {
                case "h":
                    root1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/MainForm.fxml"));
                    break;

                case "st":
                    root1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/ManageItemForm.fxml"));
                    break;
                case "fb":
                    root1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/PlaceOrderForm.fxml"));
                    break;
                case "wd":
                    root1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/BanquetManagement.fxml"));
                    break;
                case "cl":
                    root1 = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/SearchOrderForm.fxml"));
                    break;

            }


            if (root1 != null) {
                Scene subScene = new Scene(root1);
                Stage primaryStage = (Stage) this.root1.getScene().getWindow();
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
    private void btnSave_OnAction(ActionEvent event) throws Exception{
        String f1= (" "+combobox1.getValue());
        String f3= (" "+combomeal.getValue());
        String f2= (" "+combobox2.getValue());
        txtCustomerId.requestFocus();
        txtCustomerId.setEditable(true);
        CustomerDTO customerModel =
                new CustomerDTO(
                        txtCustomerId.getText(),
                        txtCustomerName.getText(),
                        txtCustomerAddress.getText(),
                        txtCustomerName1.getText(),
                        days.getText(),
                        Date2.getValue(),
                        Date1.getValue(),
                        rn.getText(),
                        daysi.getText(),
                        f1,
                        f3,
                        f2,
                       label31.getText()


                );
        boolean result= ManageCustomersBusiness.createCustomer(
                customerModel
        );
        if (result){
            new Alert(Alert.AlertType.CONFIRMATION,
                    "Customer Added Ok",
                    ButtonType.OK).showAndWait();

        }else {
            new Alert(Alert.AlertType.ERROR,
                    "Customer Added Error",
                    ButtonType.OK).showAndWait();
        }
    }

    @FXML
    private void btnDelete_OnAction(ActionEvent event) throws Exception {
        txtCustomerId.requestFocus();
        txtCustomerId.setEditable(true);
        String del_id = txtCustomerId.getText();
        boolean result= ManageCustomersBusiness.deleteCustomer(del_id);
        if (result){
            new Alert(Alert.AlertType.CONFIRMATION,
                    "Customer Deleted",
                    ButtonType.OK).showAndWait();
        }else {
            new Alert(Alert.AlertType.ERROR,
                    "Customer Deleting Error",
                    ButtonType.OK).showAndWait();
        }
    }

    @FXML
    private void btnAddNew_OnAction(ActionEvent actionEvent) throws Exception {
        String f1= (" "+combobox1.getValue());
        String f2= (" "+combobox2.getValue());
        String f3= (" "+combomeal.getValue());
        txtCustomerId.requestFocus();
        txtCustomerId.setEditable(true);
        CustomerDTO customerModel2 =
                new CustomerDTO(
                        txtCustomerId.getText(),
                        txtCustomerName.getText(),
                        txtCustomerAddress.getText(),
                        txtCustomerName1.getText(),
                        days.getText(),
                        Date2.getValue(),
                        Date1.getValue(),
                        rn.getText(),
                        daysi.getText(),
                        f1,
                        f3,
                        f2,
                       label31.getText()

                );
        boolean result= ManageCustomersBusiness.updateCustomer(
                customerModel2
        );
        if (result){
            new Alert(Alert.AlertType.CONFIRMATION,
                    "Customer Updated",
                    ButtonType.OK).showAndWait();
        }else {
            new Alert(Alert.AlertType.ERROR,
                    "Customer Update Error",
                    ButtonType.OK).showAndWait();
        }
    }


    public void btnReport_OnAction(ActionEvent actionEvent) throws Exception {

        File file = new File("report/c1.jasper");
        JasperReport compiledReport = (JasperReport)
                JRLoader.loadObject(file);

        JasperPrint filledReport = JasperFillManager
                .fillReport(compiledReport,
                        null,
                        DBConnection.getConnection()
                );
        JasperViewer.viewReport(filledReport,false);
    }

    public void getAllCustomer(){
        email();

    }

    public void email() {
        tblCustomers.getColumns().get(0)
                .setCellValueFactory(
                        new PropertyValueFactory<>("id")
                );
        tblCustomers.getColumns().get(1)
                .setCellValueFactory(
                        new PropertyValueFactory<>("name")
                );
        tblCustomers.getColumns().get(2)
                .setCellValueFactory(
                        new PropertyValueFactory<>("address")
                );
        tblCustomers.getColumns().get(3)
                .setCellValueFactory(
                        new PropertyValueFactory<>("email")
                );

        tblCustomers.getColumns().get(4)
                .setCellValueFactory(
                        new PropertyValueFactory<>("Date2")
                );
        tblCustomers.getColumns().get(5)
                .setCellValueFactory(
                        new PropertyValueFactory<>("Date1")
                );
        tblCustomers.getColumns().get(6)
                .setCellValueFactory(
                        new PropertyValueFactory<>("days")
                );
        tblCustomers.getColumns().get(7)
                .setCellValueFactory(
                        new PropertyValueFactory<>("f1")
                );
        tblCustomers.getColumns().get(8)
                .setCellValueFactory(
                        new PropertyValueFactory<>("rn")
                );
        tblCustomers.getColumns().get(9)
                .setCellValueFactory(
                        new PropertyValueFactory<>("daysi")
                );
        tblCustomers.getColumns().get(10)
                .setCellValueFactory(
                        new PropertyValueFactory<>("f3")
                );
        tblCustomers.getColumns().get(11)
                .setCellValueFactory(
                        new PropertyValueFactory<>("f2")
                );
        tblCustomers.getColumns().get(12)
                .setCellValueFactory(
                        new PropertyValueFactory<>("label31")
                );

        try {
            List<CustomerDTO> customerDTOS=
                    ManageCustomersBusiness.getCustomers();
            tblCustomers.setItems(FXCollections.observableList(customerDTOS));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void btnSearch_OnAction(ActionEvent actionEvent) throws Exception {

        String find = txtCustomerId.getText();
       CustomerDTO result = ManageCustomersBusiness.findCustomer(find);
if( find ==String.valueOf(result)){
        ManageCustomersBusiness.findCustomer(
                String.valueOf(find)
        );}
        else
            return;
    }


    public void btncalc_OnAction(ActionEvent actionEvent) {
        CalculatorForm g = new CalculatorForm();
        g.setVisible(true);
    }

    public void reset(ActionEvent actionEvent) {
        txtCustomerName.clear();
        txtCustomerId.clear();
        txtCustomerAddress.clear();
        txtCustomerName1.clear();
        txtCustomerId.requestFocus();
        txtCustomerId.setEditable(true);
        days.clear();
        rn.clear();
        daysi.clear();
        combobox2.setEditable(true);
        combobox2.setPromptText("Payment Type");
       }

// Superior Double Room 1 large double bed   Superior Double Room 1 large double bed

    public void combobox1(ActionEvent actionEvent) {
        String  r = combobox1.getValue();
        int e = Integer.parseInt(days.getText());
        int e1 = Integer.parseInt(daysi.getText());//Room Type
        if(r == "Deluxe Room With Sea View \n 1 extra-large double bed"){
            int rq = 30000;
            double wq = e*(e1*((rq/100)*0.5));
            double sas = (rq *e)*e1;

            label4.setText("Rs: "+String.valueOf(rq));//room price
            label3.setText("Rs: "+String.valueOf(sas));
        }
        if(r=="One-Bedroom Suite with \n Sea View \n 1 double bed"){
            int rq= 25000;
            double sas = (rq *e)*e1;
            double wq = e*(e1*((rq/100)*0.5));

            label4.setText("Rs: "+String.valueOf(rq));
            label3.setText("Rs: "+String.valueOf(sas));
        }
        if(r== "Deluxe Double Room \n 1 double bed"){
            int rq= 20000;
            double sas = (rq *e)*e1;
            double wq = e*(e1*((rq/100)*0.5));

            label4.setText("Rs: "+String.valueOf(rq));
            label3.setText("Rs: "+String.valueOf(sas));
        }
        if(r==  "Superior Double Room \n 1 large double bed"){
            int rq= 20000;
            double sas = (rq *e)*e1;
            double wq = e*(e1*((rq/100)*0.5));

            label4.setText("Rs: "+String.valueOf(rq));
            label3.setText("Rs: "+String.valueOf(sas));
        }
        if(r==  "Family Suite \n 2 extra-large double bed"){
            int rq= 27000;
            double sas = (rq *e)*e1;
            double wq = e*(e1*((rq/100)*0.5));

            label4.setText("Rs: "+String.valueOf(rq));
            label3.setText("Rs: "+String.valueOf(sas));
        }  if(r==   "Family Suite with Sea view\n 2 extra-large double bed"){
            int rq= 35000;
            double sas = (rq *e)*e1;
            double wq = e*(e1*((rq/100)*0.5));

            label4.setText("Rs: "+String.valueOf(rq));
            label3.setText("Rs: "+String.valueOf(sas));
        }
    }


    public void combobox2(ActionEvent actionEvent) throws Exception{

         String i =combobox1.getValue();
         String j = combomeal.getValue();
       //  String z = lable2.getText();




        String  r = combobox2.getValue();




        if(r == "Sri Lankan Rupees" && i == "Deluxe Room With Sea View \n 1 extra-large double bed" && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
             int h = t *e1;
            int e = (h* 30000) + (h * 10000);
           // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);

            double ex =(e/100)*.5;
            label41.setText(String.valueOf(1.00));
            label31.setText("Rs: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));

        }
        if(r== "USA Doller" && i ==  "Deluxe Room With Sea View \n 1 extra-large double bed" && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 30000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
             wq = wq /177;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(177.00));
            label31.setText("$: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "British Pound" && i ==  "Deluxe Room With Sea View \n 1 extra-large double bed" && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 30000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /217;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(217.00));
            label31.setText("£: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "Sri Lankan Rupees" && i ==   "Deluxe Double Room \n 1 double bed" && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 20000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /1;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(1.00));
            label31.setText("Rs: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "USA Doller" && i ==   "Deluxe Double Room \n 1 double bed" && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 20000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /177;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(177.00));
            label31.setText("$: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "British Pound" && i ==   "Deluxe Double Room \n 1 double bed" && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 20000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /217;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(217.00));
            label31.setText("£: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "Sri Lankan Rupees" && i ==  "Superior Double Room \n 1 large double bed" && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 25000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /1;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(1.00));
            label31.setText("Rs: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "USA Doller" && i ==   "Superior Double Room \n 1 large double bed" && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 25000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /177;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(177.00));
            label31.setText("$: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "British Pound" && i ==  "Superior Double Room \n 1 large double bed" && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 25000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /217;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(217.00));
            label31.setText("£: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }


        if(r==  "Sri Lankan Rupees" && i ==  "Family Suite \n 2 extra-large double bed"  && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 35000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /1;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(1.00));
            label31.setText("Rs: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "USA Doller" && i ==   "Family Suite \n 2 extra-large double bed" && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 35000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /177;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(177.00));
            label31.setText("$: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "British Pound" && i ==  "Family Suite \n 2 extra-large double bed"  && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 35000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /217;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(217.00));
            label31.setText("£: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }





        if(r == "Sri Lankan Rupees" && i == "Deluxe Room With Sea View \n 1 extra-large double bed" && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 30000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);

            double ex =(e/100)*.5;
            label41.setText(String.valueOf(1.00));
            label31.setText("Rs: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));

        }
        if(r== "USA Doller" && i ==  "Deluxe Room With Sea View \n 1 extra-large double bed" && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 30000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /177;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(177.00));
            label31.setText("$: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "British Pound" && i ==  "Deluxe Room With Sea View \n 1 extra-large double bed" && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 30000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /217;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(217.00));
            label31.setText("£: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "Sri Lankan Rupees" && i ==   "Deluxe Double Room \n 1 double bed" && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 20000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /1;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(1.00));
            label31.setText("Rs: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "USA Doller" && i ==   "Deluxe Double Room \n 1 double bed" && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 20000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /177;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(177.00));
            label31.setText("$: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "British Pound" && i ==   "Deluxe Double Room \n 1 double bed" && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 20000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /217;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(217.00));
            label31.setText("£: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "Sri Lankan Rupees" && i ==  "Superior Double Room \n 1 large double bed" && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 25000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /1;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(1.00));
            label31.setText("Rs: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "USA Doller" && i ==   "Superior Double Room \n 1 large double bed" && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 25000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /177;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(177.00));
            label31.setText("$: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "British Pound" && i ==  "Superior Double Room \n 1 large double bed" && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 25000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /217;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(217.00));
            label31.setText("£: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }


        if(r==  "Sri Lankan Rupees" && i ==  "Family Suite \n 2 extra-large double bed"  && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 35000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /1;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(1.00));
            label31.setText("Rs: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "USA Doller" && i ==   "Family Suite \n 2 extra-large double bed" && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 35000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /177;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(177.00));
            label31.setText("$: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "British Pound" && i ==  "Family Suite \n 2 extra-large double bed"  && j == "Full Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 35000) + (h * 10000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /217;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(217.00));
            label31.setText("£: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }

        if(r == "Sri Lankan Rupees" && i == "Deluxe Room With Sea View \n 1 extra-large double bed" && j == "Half Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 30000) + (h * 7000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);

            double ex =(e/100)*.5;
            label41.setText(String.valueOf(1.00));
            label31.setText("Rs: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));

        }
        if(r== "USA Doller" && i ==  "Deluxe Room With Sea View \n 1 extra-large double bed" && j == "Half Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 30000) + (h * 7000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /177;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(177.00));
            label31.setText("$: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "British Pound" && i ==  "Deluxe Room With Sea View \n 1 extra-large double bed" && j == "Half Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 30000) + (h * 7000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /217;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(217.00));
            label31.setText("£: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "Sri Lankan Rupees" && i ==   "Deluxe Double Room \n 1 double bed" && j == "Half Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 20000) + (h * 7000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /1;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(1.00));
            label31.setText("Rs: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "USA Doller" && i ==   "Deluxe Double Room \n 1 double bed" && j == "Half Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 20000) + (h * 7000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /177;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(177.00));
            label31.setText("$: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "British Pound" && i ==   "Deluxe Double Room \n 1 double bed" && j == "Half Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 20000) + (h * 7000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /217;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(217.00));
            label31.setText("£: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "Sri Lankan Rupees" && i ==  "Superior Double Room \n 1 large double bed" && j == "Half Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 25000) + (h * 7000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /1;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(1.00));
            label31.setText("Rs: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "USA Doller" && i ==   "Superior Double Room \n 1 large double bed" && j == "Half Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 25000) + (h * 7000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /177;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(177.00));
            label31.setText("$: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "British Pound" && i ==  "Superior Double Room \n 1 large double bed" && j == "Half Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 25000) + (h * 7000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /217;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(217.00));
            label31.setText("£: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }


        if(r==  "Sri Lankan Rupees" && i ==  "Family Suite \n 2 extra-large double bed"  && j == "Half Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 35000) + (h * 7000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /1;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(1.00));
            label31.setText("Rs: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "USA Doller" && i ==   "Family Suite \n 2 extra-large double bed" && j == "Half Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 35000) + (h * 7000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /177;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(177.00));
            label31.setText("$: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }
        if(r==  "British Pound" && i ==  "Family Suite \n 2 extra-large double bed"  && j == "Half Board"){
            int e1 = Integer.parseInt(daysi.getText());
            int t = Integer.parseInt(days.getText());
            int h = t *e1;
            int e = (h* 35000) + (h * 7000);
            // double sas = (rq *e)*e1;
            double wq =(e+(e/100)*0.5);
            wq = wq /217;
            double ex =(e/100)*.5;
            label41.setText(String.valueOf(217.00));
            label31.setText("£: "+String.valueOf(wq));
            lable2.setText("Rs: "+String.valueOf(ex));
        }

        //
//      if(r== "Yen"){
//            label41.setText(String.valueOf(4.00));
//            label31.setText("¥: "+String.valueOf(y));
//        }
       }

    ObservableList <String> list2 =FXCollections.observableArrayList(
            "Sri Lankan Rupees",
            "USA Doller",
            "British Pound"

    );

    ObservableList <String> list =FXCollections.observableArrayList(
            "Deluxe Room With Sea View \n 1 extra-large double bed",//30000
            "Deluxe Double Room \n 1 double bed",                          //20000
            "Superior Double Room \n 1 large double bed",                  //20000
            "Family Suite \n 2 extra-large double bed"                  //27000

    );

    public void idc(ActionEvent actionEvent) {
        txtCustomerId.clear();
        txtCustomerId.requestFocus();
    }

    public void namec(ActionEvent actionEvent) {
        txtCustomerName.clear();
        txtCustomerName.requestFocus();
    }

    public void countryc(ActionEvent actionEvent) {
        txtCustomerAddress.clear();
        txtCustomerAddress.requestFocus();
    }

    public void emailc(ActionEvent actionEvent) {
        txtCustomerName1.clear();
        txtCustomerName1.requestFocus();
    }


    public void roomnc(ActionEvent actionEvent) {
        rn.clear();
        rn.requestFocus();
    }

    public void nodaysc(ActionEvent actionEvent) {
        days.clear();
        days.requestFocus();
    }

    ObservableList <String> list1 =FXCollections.observableArrayList(
            "Full Board",//10000
            "Half Board"         //7000
    );


    public void combomeal(ActionEvent actionEvent) {
        String  r = combomeal.getValue();//Room Type
       // int t = Integer.parseInt(daysi1.getText());
      int  y = Integer.parseInt(days.getText());
      int x = Integer.parseInt(daysi.getText());
        if(r == "Full Board"){

            int rq = (10000*(y*x));

            lable1.setText(String.valueOf(rq));
        }
        if(r == "Half Board"){
            int rq = 7000*(y*x);
            lable1.setText(String.valueOf(rq));
        }
    }




    public void noRoomsc(ActionEvent actionEvent) {
        combomeal.setEditable(true);
        daysi.clear();
        daysi.requestFocus();
    }

    public void SearchGuest(MouseEvent event) throws Exception {}

    public void dd(KeyEvent del_cod) throws  Exception{}

    public void onEnter(ActionEvent actionEvent) throws Exception {
        String del_code = txtCustomerId.getText();

        //String d= ManageCustomersBusiness.findCustomer(del_code).getId();


        String d0= ManageCustomersBusiness.findCustomer(del_code).getId();
        String d1=  ManageCustomersBusiness.findCustomer(del_code).getName();
        String d2=  ManageCustomersBusiness.findCustomer(del_code).getAddress();
        String d3=  ManageCustomersBusiness.findCustomer(del_code).getEmail();
        String d4=  ManageCustomersBusiness.findCustomer(del_code).getDays();
        LocalDate d5=  ManageCustomersBusiness.findCustomer(del_code).getDate2();
        LocalDate d6=  ManageCustomersBusiness.findCustomer(del_code).getDate1();
        String d7=  ManageCustomersBusiness.findCustomer(del_code).getRn();
        String d8 =  ManageCustomersBusiness.findCustomer(del_code).getDaysi();
        String d9 =  ManageCustomersBusiness.findCustomer(del_code).getF2();
        String d10 =  ManageCustomersBusiness.findCustomer(del_code).getF3();

        txtCustomerId.setText(d0);
        txtCustomerName.setText(d1);
        txtCustomerAddress.setText(d2);
        txtCustomerName1.setText(d3);
        days.setText(d4);
        Date2.setValue(d5);
        Date1.setValue(d6);
        rn.setText(d7);
        daysi.setText(d8);
        txtCustomerName.requestFocus();

    }


    public void roomst(ActionEvent actionEvent) throws Exception {


            String del_code = rn.getText();

            String d = ManageCleanBusiness.findClean(del_code).getF1();

            new Alert(Alert.AlertType.CONFIRMATION,
                    d,
                    ButtonType.OK).showAndWait();
                   rn.requestFocus();



    }

    public void guestnameOnaction(ActionEvent actionEvent) { txtCustomerAddress.requestFocus(); }

    public void ddaaa(ContextMenuEvent contextMenuEvent) { txtCustomerId.requestFocus(); }

    public void fdddd(KeyEvent keyEvent) { }

    public void country(ActionEvent actionEvent) { txtCustomerName1.requestFocus(); }

    public void days(ActionEvent actionEvent) {rn.requestFocus(); }

    public void sssss(ActionEvent actionEvent) { days.requestFocus(); }

    public void rn(ActionEvent actionEvent) {Date2.requestFocus(); }

    public void date(ActionEvent actionEvent) { daysi.requestFocus();}

    public void date2(ActionEvent actionEvent) { Date1.requestFocus();}

    public void nrr(ActionEvent actionEvent) { combomeal.requestFocus();}
}
