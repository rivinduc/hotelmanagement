package lk.ijse.cmjd.fx.dto;

import java.sql.Date;
import java.time.LocalDate;

public class OrderDTO {


    private String id;
    private String customerId;
    private  String itemCode;
    private  String  qtyOnHand;
    private LocalDate date1;
    private  String customerName;
    private String discription;
    private String unitePrice;
    private  String qty;
    private String total;

    public OrderDTO() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public void setQtyOnHand(String qtyOnHand) {
        this.qtyOnHand = qtyOnHand;
    }

    public void setDate1(LocalDate date1) {
        this.date1 = date1;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setUnitePrice(String unitePrice) {
        this.unitePrice = unitePrice;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public String getQtyOnHand() {
        return qtyOnHand;
    }

    public LocalDate getDate1() {
        return date1;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDiscription() {
        return discription;
    }

    public String getUnitePrice() {
        return unitePrice;
    }

    public String getQty() {
        return qty;
    }

    public String getTotal() {
        return total;
    }
    public OrderDTO(String id, String customerId, String itemCode, String qtyOnHand, LocalDate date1, String customerName, String discription, String unitePrice, String qty, String total) {
        this.id = id;
        this.customerId = customerId;
        this.itemCode = itemCode;
        this.qtyOnHand = qtyOnHand;
        this.date1 = date1;
        this.customerName = customerName;
        this.discription = discription;
        this.unitePrice = unitePrice;
        this.qty = qty;
        this.total = total;
    }
    @Override
    public String toString() {
        return "Customer{" + "id='" + id + '\'' +
                ", customerId='" + customerId + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ",qtyOnHand='" + qtyOnHand + '\'' +
                ",date1='" + date1 + '\'' +
                ",customerName='" + customerName + '\'' +
                ",discription='" + discription + '\'' +
                ",unitePrice='" + unitePrice + '\'' +
                ",qty='" + qty + '\'' +
                ",total='" + total + '\'' +
                '}';
    }
}
