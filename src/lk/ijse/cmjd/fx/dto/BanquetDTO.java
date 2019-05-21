package lk.ijse.cmjd.fx.dto;

import lk.ijse.cmjd.fx.entity.Banquet;
import lk.ijse.cmjd.fx.entity.Order;


import java.time.LocalDate;
import java.util.Date;

public class BanquetDTO extends OrderDTO {
    private String id;
    private String name;
    private String address;
    private String email;
    private LocalDate Date2;
    private String f1;
    private String f2;
    private String chair;
    private String ppl;
    private String typec;
    private  String txtCustomerId12;


    @Override
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDate2(LocalDate Date2) { this.Date2 = Date2; }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public void setF2(String f2) {
        this.f2 = f2;
    }

    public void setChair(String chair) {
        this.chair = chair;
    }

    public void setPpl(String ppl) {
        this.ppl = ppl;
    }



    @Override
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDate2() { return Date2; }

    public String getF1() {
        return f1;
    }

    public String getF2() {
        return f2;
    }

    public String getChair() {
        return chair;
    }

    public String getPpl() {
        return ppl;
    }

    public String getTypec() {
        return typec;
    }

    public void setTypec(String typec) {
        this.typec = typec;
    }

    public String getTxtCustomerId12() {
        return txtCustomerId12;
    }

    public void setTxtCustomerId12(String txtCustomerId12) {
        this.txtCustomerId12 = txtCustomerId12;
    }

    public BanquetDTO(String id,
                      String name,
                      String address,
                      String email,

                      LocalDate Date2,


                      String ppl,
                      String typec, String chair,
                      String f1,

                      String f2,
                      String txtCustomerId12
    )
    {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;

        this.Date2= Date2;


        this.ppl = ppl;
        this.typec =typec; this.chair =chair;
        this.f1 = f1;

        this.f2 =f2;
        this.txtCustomerId12 =txtCustomerId12;
    }
    @Override
    public String toString() {
        return "Customer{" + "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ",email='" + email+ '\'' +
                ",Date2='" + Date2+ '\'' +
                ",ppl='" + ppl+ '\'' +
                ",typec='" + typec+ '\'' +
                ",chair='" + chair+ '\'' +
                ",f1='" + f1+ '\'' +
                ",f2='" + f2+ '\'' +
                ",txtCustomerId12='" + txtCustomerId12+ '\'' +
                '}';
    }

}
