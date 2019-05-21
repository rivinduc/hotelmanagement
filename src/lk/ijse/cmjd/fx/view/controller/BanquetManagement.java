package lk.ijse.cmjd.fx.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import  javafx.scene.control.Button;
import java.awt.*;
import javafx.scene.Scene;
import java.awt.Label;
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
import lk.ijse.cmjd.fx.business.ManageBanquetBusiness;
import lk.ijse.cmjd.fx.business.ManageCustomersBusiness;
import lk.ijse.cmjd.fx.dto.BanquetDTO;
import lk.ijse.cmjd.fx.dto.CustomerDTO;
import lk.ijse.cmjd.fx.db.DBConnection;
import lk.ijse.cmjd.fx.entity.Banquet;
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
import static com.sun.corba.se.impl.util.Utility.printStackTrace;
import static javafx.application.Application.launch;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.awt.*;
import java.io.IOException;

public class BanquetManagement implements Initializable {

    @FXML
    private AnchorPane rootx;
    @FXML
    private JFXTextField txtCustomerId;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtCustomerAddress;

    @FXML
    private JFXTextField txtCustomerName1;
    @FXML
    private JFXTextField txtNoofChairs;
@FXML
private JFXTextField txtnoOfpeople;
    @FXML
    private JFXTextField typec;
    @FXML
    private JFXComboBox<?> roomTypeComboBox1;

    @FXML
    private JFXTextField txtCustomerId11;

    @FXML
    private JFXTextField txtCustomerId12;

    @FXML
    private JFXTextField txtCustomerName21;

    @FXML
    private JFXDatePicker Date2;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private TableView<BanquetDTO> tblCustomers;

    @FXML
    private JFXButton btnDelete1;

    @FXML
    private JFXButton btncalc;

    @FXML
    private JFXButton reset;
    @FXML
    private ComboBox<String> combomeal;
    @FXML
    private ComboBox<String> combotype;
    @FXML
    private JFXTextField txtCustomerName211;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXTextField txtCustomerName212;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), rootx);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
        combomeal.setItems(list);
        combotype.setItems(list2);


    }

    @FXML
    void tblCustomers_OnMouseClicked(MouseEvent event) throws Exception {
        email();
    }

    public void navigateToHomex(MouseEvent event) throws IOException {


        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent rootx = null;

            switch (icon.getId()) {
                case "homex":
                    rootx = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/MainForm.fxml"));
                    break;

                case "reservationx":
                    rootx = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/ManageCustomerForm.fxml"));
                    break;
                case "fb":
                    rootx = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/PlaceOrderForm.fxml"));
                    break;
                case "storex":
                    rootx = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/ManageItemForm.fxml"));
                    break;
                case "cleanx":
                    rootx = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/SearchOrderForm.fxml"));
                    break;

            }


            if (rootx != null) {
                Scene subScene = new Scene(rootx);
                Stage primaryStage = (Stage) this.rootx.getScene().getWindow();
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();

            }
        }

    }
        public void btnSave_OnAction (ActionEvent event) throws Exception {

            String f1 = (" " + combomeal.getValue());
            String f2 = (" " + combotype.getValue());
            txtCustomerId.requestFocus();
            txtCustomerId.setEditable(true);
            BanquetDTO banquetModel =
                    new BanquetDTO(
                            txtCustomerId.getText(),
                            txtCustomerName.getText(),
                            txtCustomerAddress.getText(),
                            txtCustomerName1.getText(),
                            Date2.getValue(),
                            txtNoofChairs.getText(),
                            txtnoOfpeople.getText(),
                            typec.getText(),
                            f1,
                            f2,
                            txtCustomerId12.getText()


                    );
            boolean result = ManageBanquetBusiness.createBanquet(
                    banquetModel
            );
            if (result) {
                new Alert(Alert.AlertType.CONFIRMATION,
                        "Customer Added Ok",
                        ButtonType.OK).showAndWait();

            } else {
                new Alert(Alert.AlertType.ERROR,
                        "Customer Added Error",
                        ButtonType.OK).showAndWait();
            }
        }


    public void btnAddNew_OnAction(ActionEvent actionEvent) throws Exception {
        String f1= (" "+combomeal.getValue());
        String f2= (" "+combotype.getValue());
        txtCustomerId.requestFocus();
        txtCustomerId.setEditable(true);
        BanquetDTO banquetModel2 =
                new BanquetDTO(
                        txtCustomerId.getText(),
                        txtCustomerName.getText(),
                        txtCustomerAddress.getText(),
                        txtCustomerName1.getText(),

                        Date2.getValue(),
                        txtNoofChairs.getText(),
                        txtnoOfpeople.getText(),
                        typec.getText(),
                        f1,
                        f2,txtCustomerId12.getText()

                );
        boolean result= ManageBanquetBusiness.updateBanquet(
                banquetModel2
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
    public void getAllBanquet() throws Exception {
        email();

    }
    public void email() throws Exception {
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

        tblCustomers.getColumns().get(6)
                .setCellValueFactory(
                        new PropertyValueFactory<>("ppl")//chair
                );
        tblCustomers.getColumns().get(7)
                .setCellValueFactory(
                        new PropertyValueFactory<>("typec")
                );
        tblCustomers.getColumns().get(5)
                .setCellValueFactory(
                        new PropertyValueFactory<>("chair")
                );
        tblCustomers.getColumns().get(8)
                .setCellValueFactory(
                        new PropertyValueFactory<>("f2")
                );
        tblCustomers.getColumns().get(9)
                .setCellValueFactory(
                        new PropertyValueFactory<>("f1")
                );
        tblCustomers.getColumns().get(10)
                .setCellValueFactory(
                        new PropertyValueFactory<>("txtCustomerId12")
                );




            List<BanquetDTO> banquetDTOS=
                    ManageBanquetBusiness.getBanquet();
            tblCustomers.setItems(FXCollections.observableList(banquetDTOS));

//            printStackTrace();

    }
    public void btnSearch_OnAction(ActionEvent actionEvent) throws Exception {

        String find = txtCustomerId.getText();
        BanquetDTO result = ManageBanquetBusiness.findBanquet(find);
        if( find ==String.valueOf(result)){
            ManageBanquetBusiness.findBanquet(
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

    }

    public void btnReport_OnAction(ActionEvent actionEvent) throws Exception {
        File file = new File("report/POSz.jasper");
        JasperReport compiledReport = (JasperReport)
                JRLoader.loadObject(file);

        JasperPrint filledReport = JasperFillManager
                .fillReport(compiledReport,
                        null,
                        DBConnection.getConnection()
                );
        JasperViewer.viewReport(filledReport,false);
    }

    public void combomeal(ActionEvent actionEvent) {
    }
    ObservableList <String> list =FXCollections.observableArrayList(
            "Breakfest Only",
            "Lunch Only",
            "Dinner Only",
            "Breakfest & Lunch",
            "Lunch & Dinner",
            "Full Board",
            "Breakfest, Lunch & 1 Coffee",
            "Lunch & 1 Coffee",
            "Full Board & 1 Coffee"
    );
    ObservableList <String> list2 =FXCollections.observableArrayList(
            "Rs: 2000.0",
            "Rs: 3000.0",
            "Rs: 4000.0"
    );
    public void combotype(ActionEvent actionEvent) throws  Exception{

        String i =combomeal.getValue();
        String j =combotype.getValue();


        if(i== "Breakfest Only" && j== "Rs: 4000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *15;//price for chairs
            int yy= i2 * 4000;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i== "Lunch Only" && j== "Rs: 4000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *15;//price for chairs
            int yy= i2 * 4000;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i== "Dinner Only" && j== "Rs: 4000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *15;//price for chairs
            int yy= i2 * 4000;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }


        if(i== "Breakfest & Lunch" && j== "Rs: 4000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *25;//price for chairs
            int yy= i2 * 8000;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i== "Lunch & Dinner" && j== "Rs: 4000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *25;//price for chairs
            int yy= i2 * 8000;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i== "Full Board" && j== "Rs: 4000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *30;//price for chairs
            int yy= i2 * 12000;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i==  "Breakfest, Lunch & 1 Coffee" && j== "Rs: 4000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *27;//price for chairs
            int yy= i2 * 8200;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i==  "Lunch & 1 Coffee" && j== "Rs: 4000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *27;//price for chairs
            int yy= i2 * 4200;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i==  "Full Board & 1 Coffee" && j== "Rs: 4000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *27;//price for chairs
            int yy= i2 * 12200;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }






        if(i== "Breakfest Only" && j== "Rs: 3000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *15;//price for chairs
            int yy= i2 * 3000;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i== "Lunch Only" && j== "Rs: 3000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *15;//price for chairs
            int yy= i2 * 3000;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i== "Dinner Only" && j== "Rs: 3000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *15;//price for chairs
            int yy= i2 * 3000;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }


        if(i== "Breakfest & Lunch" && j== "Rs: 3000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *25;//price for chairs
            int yy= i2 * 6000;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i== "Lunch & Dinner" && j== "Rs: 3000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *25;//price for chairs
            int yy= i2 * 6000;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i== "Full Board" && j== "Rs: 3000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *30;//price for chairs
            int yy= i2 * 9000;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i==  "Breakfest, Lunch & 1 Coffee" && j== "Rs: 3000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *27;//price for chairs
            int yy= i2 * 6200;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i==  "Lunch & 1 Coffee" && j== "Rs: 3000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *27;//price for chairs
            int yy= i2 * 3200;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i==  "Full Board & 1 Coffee" && j== "Rs: 3000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *27;//price for chairs
            int yy= i2 * 9200;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }






        if(i== "Breakfest Only" && j== "Rs: 2000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *15;//price for chairs
            int yy= i2 * 2000;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i== "Lunch Only" && j== "Rs: 2000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *15;//price for chairs
            int yy= i2 * 2000;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i== "Dinner Only" && j== "Rs: 2000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *15;//price for chairs
            int yy= i2 * 2000;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }


        if(i== "Breakfest & Lunch" && j== "Rs: 2000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *25;//price for chairs
            int yy= i2 * 4000;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i== "Lunch & Dinner" && j== "Rs: 2000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *25;//price for chairs
            int yy= i2 * 4000;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i== "Full Board" && j== "Rs: 2000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *30;//price for chairs
            int yy= i2 * 6000;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i==  "Breakfest, Lunch & 1 Coffee" && j== "Rs: 2000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *27;//price for chairs
            int yy= i2 * 4200;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i==  "Lunch & 1 Coffee" && j== "Rs: 2000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *27;//price for chairs
            int yy= i2 * 2200;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
        if(i==  "Full Board & 1 Coffee" && j== "Rs: 2000.0"){

            int i1 = Integer.parseInt(txtNoofChairs.getText());//chair
            int i2 = Integer.parseInt(txtnoOfpeople.getText());//ppl

            i1= i1 *27;//price for chairs
            int yy= i2 * 6200;//price for foods
            int yyy =  i1+yy;

            txtCustomerId11.setText("Rs: "+String.valueOf(i1));
            txtCustomerId12.setText("Rs: "+String.valueOf(yyy));
        }
    }

    public void  btnDelete_OnAction(ActionEvent actionEvent) throws Exception {
        txtCustomerId.requestFocus();
        txtCustomerId.setEditable(true);
        String del_id = txtCustomerId.getText();
        boolean result= ManageBanquetBusiness.deleteBanquet(del_id);
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


    public void idOnACTION(ActionEvent actionEvent) throws Exception {

        String del_code = txtCustomerId.getText();
        String d= ManageBanquetBusiness.findBanquet(del_code).getId();



    String d0 = ManageBanquetBusiness.findBanquet(del_code).getId();
    String d1 = ManageBanquetBusiness.findBanquet(del_code).getName();
    String d2 = ManageBanquetBusiness.findBanquet(del_code).getAddress();
    String d3 = ManageBanquetBusiness.findBanquet(del_code).getEmail();


    LocalDate d4 = ManageBanquetBusiness.findBanquet(del_code).getDate2();
    String d5 = ManageBanquetBusiness.findBanquet(del_code).getChair();
    String d6 = ManageBanquetBusiness.findBanquet(del_code).getPpl();
    String d7 = ManageBanquetBusiness.findBanquet(del_code).getTypec();
    String d8 = ManageBanquetBusiness.findBanquet(del_code).getF1();
    String d9 = ManageBanquetBusiness.findBanquet(del_code).getF2();


    txtCustomerId.setText(d0);
    txtCustomerName.setText(d1);
    txtCustomerAddress.setText(d2);
    txtCustomerName1.setText(d3);
    txtNoofChairs.setText(d5);
    txtnoOfpeople.setText(d6);
    typec.setText(d7);
    Date2.setValue(d4);
    // combotype.setValue(d9);

}


    public void ssss(MouseEvent event) throws Exception {}

    public void idc(ActionEvent actionEvent) { txtCustomerId.clear();txtCustomerId.requestFocus();}

    public void namec(ActionEvent actionEvent) {txtCustomerName.clear();txtCustomerName.requestFocus(); }

    public void countryc(ActionEvent actionEvent) {txtCustomerAddress.clear();txtCustomerAddress.requestFocus(); }

    public void emailc(ActionEvent actionEvent) {txtCustomerName1.clear();txtCustomerName1.requestFocus();  }

    public void typec(ActionEvent actionEvent) {typec.clear();typec.requestFocus(); }

    public void npplc(ActionEvent actionEvent) {txtnoOfpeople.clear();txtnoOfpeople.requestFocus(); }

    public void chc(ActionEvent actionEvent) {txtNoofChairs.clear();txtNoofChairs.requestFocus(); }

    public void Enter1(ActionEvent actionEvent) {
        txtCustomerAddress.requestFocus();
    }

    public void Enter2(ActionEvent actionEvent) {
        txtCustomerName1.requestFocus();
    }

    public void Enter3(ActionEvent actionEvent) {
        txtNoofChairs.requestFocus();
    }

    public void Enter5(ActionEvent actionEvent) {
        typec.requestFocus();
    }

    public void Enter7(ActionEvent actionEvent) {
        combomeal.requestFocus();
    }

    public void Enter4(ActionEvent actionEvent) {
        txtnoOfpeople.requestFocus();
    }

    public void Enter6(ActionEvent actionEvent) {
        Date2.requestFocus();
    }
}


