package lk.ijse.cmjd.fx.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.cmjd.fx.business.ManageBanquetBusiness;
import lk.ijse.cmjd.fx.business.ManageCustomersBusiness;
import lk.ijse.cmjd.fx.business.ManageItemsBusiness;
import lk.ijse.cmjd.fx.business.ManageOrdersBusiness;
import lk.ijse.cmjd.fx.dto.BanquetDTO;
import lk.ijse.cmjd.fx.dto.OrderDTO;
import lk.ijse.cmjd.fx.entity.Order;
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

import static com.sun.corba.se.impl.util.Utility.printStackTrace;

public class PlaceOrderFormController implements Initializable {
    @FXML
    private JFXButton btnPlaceOrder;
    @FXML
    private JFXTextField txtCustomerId;
    @FXML
    private JFXTextField txtItemCode;
    @FXML
    private JFXTextField txtCustomerName;
    @FXML
    private JFXTextField txtDescription;
    @FXML
    private JFXTextField txtQtyOnHand;

    @FXML
    private JFXDatePicker Date1;
    @FXML
    private JFXTextField txtUnitPrice;
    @FXML
    private JFXTextField txtQty;
    @FXML
    private TableView<OrderDTO> tblCustomers;
    @FXML
    private JFXButton btnRemove;
    @FXML
    private Label lblTotal;
    @FXML
    private JFXTextField txtOrderID;
    @FXML
    private JFXDatePicker txtOrderDate;

    private ObservableList<?> tempItemsDB = FXCollections.observableArrayList();

    @FXML
    private TextField txtTotal;

    @FXML
    private JFXButton btnReport;
    @FXML
    private AnchorPane roota;



    public void initialize(URL location, ResourceBundle resources) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), roota);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }
    @FXML
    void tblCustomers_OnMouseClicked(MouseEvent event) throws Exception {
        email();
    }

    public void navigateToHomea(MouseEvent event) throws IOException {


        if (event.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) event.getSource();

            Parent roota = null;

            switch (icon.getId()) {
                case "ha":
                    roota = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/MainForm.fxml"));
                    break;

                case "sa":
                    roota = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/ManageItemForm.fxml"));
                    break;
                case "ra":
                    roota = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/ManageCustomerForm.fxml"));
                    break;
                case "wa":
                    roota = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/BanquetManagement.fxml"));
                    break;
                case "ca":
                    roota= FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/SearchOrderForm.fxml"));
                    break;

            }


            if (roota != null) {
                Scene subScene = new Scene(roota);
                Stage primaryStage = (Stage) this.roota.getScene().getWindow();
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

        txtOrderID.requestFocus();
        txtOrderID.setEditable(true);
        OrderDTO orderModel =
                new OrderDTO(
                        txtOrderID.getText(),
                        txtCustomerId.getText(),
                        txtItemCode.getText(),
                        txtQtyOnHand.getText(),
                        Date1.getValue(),
                        txtCustomerName.getText(),
                        txtDescription.getText(),
                        txtUnitPrice.getText(),
                        txtQty.getText(),
                        txtTotal.getText()


                );
        boolean result = ManageOrdersBusiness.createOrder(
                orderModel
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

        txtOrderID.requestFocus();
        txtOrderID.setEditable(true);
      OrderDTO orderModel2 =
                new OrderDTO(
                        txtOrderID.getText(),
                        txtCustomerId.getText(),
                        txtItemCode.getText(),
                        txtQtyOnHand.getText(),
                        Date1.getValue(),
                        txtCustomerName.getText(),
                        txtDescription.getText(),
                        txtUnitPrice.getText(),
                        txtQty.getText(),
                        txtTotal.getText()

                );
        boolean result= ManageOrdersBusiness.updateOrder(
                orderModel2
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


    public void getAllOrder() throws Exception {
        email();

    }


    public void email() throws Exception {
        tblCustomers.getColumns().get(0)
                .setCellValueFactory(
                        new PropertyValueFactory<>("id")
                );
        tblCustomers.getColumns().get(2)
                .setCellValueFactory(
                        new PropertyValueFactory<>("customerId")
                );
        tblCustomers.getColumns().get(4)
                .setCellValueFactory(
                        new PropertyValueFactory<>("itemCode")
                );
        tblCustomers.getColumns().get(1)
                .setCellValueFactory(
                        new PropertyValueFactory<>("date1")
                );
        tblCustomers.getColumns().get(3)
                .setCellValueFactory(
                        new PropertyValueFactory<>("customerName")
                );
        tblCustomers.getColumns().get(5)
                .setCellValueFactory(
                        new PropertyValueFactory<>("discription")
                );


        tblCustomers.getColumns().get(7)
                .setCellValueFactory(
                        new PropertyValueFactory<>("unitePrice")
                );
        tblCustomers.getColumns().get(8)
                .setCellValueFactory(
                        new PropertyValueFactory<>("qty")
                );
        tblCustomers.getColumns().get(9)
                .setCellValueFactory(
                        new PropertyValueFactory<>("total")
                );
        tblCustomers.getColumns().get(6)
                .setCellValueFactory(
                        new PropertyValueFactory<>("qtyOnHand")
                );
        List<OrderDTO> orderDTOS=
                ManageOrdersBusiness.getOrder();
        tblCustomers.setItems(FXCollections.observableList(orderDTOS));

    }
    public void btnSearch_OnAction(ActionEvent actionEvent) throws Exception {

        String find = txtOrderID.getText();
        OrderDTO result = ManageOrdersBusiness.findOrder(find);
        if( find ==String.valueOf(result)){
            ManageOrdersBusiness.findOrder(
                    String.valueOf(find)
            );}
        else
            return;
    }

    public void btnPlaceOrder(ActionEvent actionEvent) {
        txtOrderID.clear();
        txtCustomerId.clear();
        txtCustomerName.clear();
        txtItemCode.clear();
        txtDescription.clear();
        txtUnitPrice.clear();
        txtQty.clear();
        txtQtyOnHand.clear();
        txtOrderID.requestFocus();
        txtOrderID.setEditable(true);
        tblCustomers.getSelectionModel().clearSelection();

    }

    @FXML
    private void btnRemoveOnAction(ActionEvent actionEvent) throws Exception {
        txtOrderID.requestFocus();
        txtOrderID.setEditable(true);
        String del_id = txtOrderID.getText();
        boolean result= ManageOrdersBusiness.deleteOrder(del_id);
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
    private void navigateToMain(MouseEvent event) throws IOException {
        Label lblMainNav = (Label) event.getSource();
        Stage primaryStage = (Stage) lblMainNav.getScene().getWindow();
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/cmjd/fx/view/MainForm.fxml"));
        Scene mainScene = new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.centerOnScreen();
    }





    @FXML
    private void txtCustomerID_OnAction(ActionEvent actionEvent) throws Exception {

        String del_code = txtCustomerId.getText();
        String d1=  ManageCustomersBusiness.findCustomer(del_code).getName();
        txtCustomerName.setText(d1);
    }

    @FXML
    private void txtItemCode_OnAction(ActionEvent actionEvent) throws Exception {
        String del_code = txtItemCode.getText();
        String d1= ManageItemsBusiness.findItem(del_code).getDescription();
        int d2= ManageItemsBusiness.findItem(del_code).getQtyOnHand();
        double d3= ManageItemsBusiness.findItem(del_code).getUnitPrice();

        txtDescription.setText(d1);
        txtQtyOnHand.setText(String.valueOf(d2));
        txtUnitPrice.setText(String.valueOf(d3));

    }

    @FXML
    private void txtQty_OnAction(ActionEvent actionEvent) throws Exception{
        int d0 = Integer.parseInt(txtQty.getText());
        double d1 = Double.parseDouble(txtUnitPrice.getText());

        double x = d1 * d0;
        txtTotal.setText("Rs: "+String.valueOf(x));

    }

    @FXML
    void btnReportOnAction(ActionEvent event) throws JRException {
        File file = new File("report/Order_Report.jasper");
        JasperReport compiledReport = (JasperReport)
                JRLoader.loadObject(file);

        Map<String, Object> parms = new HashMap<>();
        parms.put("id",txtOrderID.getText());
        parms.put("customerId", txtCustomerId.getText());
        parms.put("itemCode", txtItemCode.getText());
        parms.put("qtyOnHand", txtDescription.getText());
        parms.put("date", Date1.getValue().toString());
        parms.put("customerName", txtCustomerName.getText());
        parms.put("discription", txtDescription.getText());
        parms.put("unitePrice", txtUnitPrice.getText());
        parms.put("qty", txtQty.getText());
        parms.put("total", txtTotal.getText());
        JasperPrint filledReport = JasperFillManager
                .fillReport(compiledReport,
                        parms,
                        new JREmptyDataSource()
                );
        JasperViewer.viewReport(filledReport, false);
    }

    public void navigateToHome(MouseEvent mouseEvent)throws Exception {
       // AppInitializer.navigateToHome(root, (Stage) this.root.getScene().getWindow());
    }


    public void uniteaaction(ActionEvent actionEvent) {
        int d0 = Integer.parseInt(txtQty.getText());
        double d1 = Integer.parseInt(txtUnitPrice.getText());

        double x = d1 * d0;
        txtTotal.setText("Rs: "+String.valueOf(x));
    }

    public void OnactionOrderId(ActionEvent actionEvent) throws Exception {
        String del_code = txtOrderID.getText();
        String d1= String.valueOf(ManageOrdersBusiness.findOrder(del_code).getDate1());
        String d2= ManageOrdersBusiness.findOrder(del_code).getCustomerId();
        String d3= ManageOrdersBusiness.findOrder(del_code).getCustomerName();
        String d4= ManageOrdersBusiness.findOrder(del_code).getItemCode();
        String d5= ManageOrdersBusiness.findOrder(del_code).getDiscription();
        String d6= ManageOrdersBusiness.findOrder(del_code).getQtyOnHand();
        String d7= ManageOrdersBusiness.findOrder(del_code).getUnitePrice();
        String d8= ManageOrdersBusiness.findOrder(del_code).getQty();
        String d9 = ManageOrdersBusiness.findOrder(del_code).getTotal();

        Date1.setValue(LocalDate.parse(d1));
        txtCustomerId.setText(d2);
        txtCustomerName.setText(d3);
        txtItemCode.setText(d4);
        txtDescription.setText(d5);
        txtQtyOnHand.setText(d6);
        txtUnitPrice.setText(d7);
         txtQty.setText(d8);
      txtTotal.setText(d9);
    }
}