package lk.ijse.cmjd.fx.dto;

import java.time.LocalDate;

public class CustomerDTO extends OrderDTO {

    private String id;
    private String name;
    private String address;
    private String email;
    private String days;
    private LocalDate Date2;
    private LocalDate Date1;
    private String rn;
    private String daysi;
    private String  f1;
    private String f3;
    private String f2;
    private  String label31;

    public void setLabel31(String label31) {
        this.label31 = label31;
    }

    public String getLabel31() {
        return label31;
    }

    public String getDaysi() {
        return daysi;
    }

    public void setDaysi(String daysi) {
        this.daysi = daysi;
    }

    public String getF2() { return f2; }

    public void setF2(String f2) { this.f2 = f2; }

    public String getF3() { return f3; }

    public void setF3(String f3) { this.f3 = f3; }

    public void setF1(String f1) { this.f1 = f1; }

    public String getF1() { return f1; }

    public String getRn() { return rn; }

    public void setRn(String rn) { this.rn = rn; }

    public void setDate2(LocalDate Date2) { this.Date2 = Date2; }

    public LocalDate getDate2() { return Date2; }

    public LocalDate getDate1() { return Date1; }


    public void setDate1(LocalDate Date1){ this.Date1 = Date1;}

    @Override

    public void setId(String id) {
        this.id = id;
    }

    public void setDays(String days) {
        this.days = days;
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

    public String getDays() {
        return days;
    }

    public CustomerDTO(String id,
                       String name,
                       String address,
                       String email,
                       String days,
                       LocalDate Date2,
                       LocalDate Date1,
                       String rn,
                       String daysi,
                       String f1,
                       String f3,
                       String f2,
                       String label31
    )
    {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.days  = days;
        this.Date2= Date2;
        this.Date1 = Date1;
        this.rn =rn;
        this.daysi=daysi;
        this.f1 = f1;
        this.f3 = f3;
        this.f2 =f2;
        this.label31 =label31;

    }



    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id='" + id + '\'' +
                ",name='" + name + '\'' +
                ",address='" + address + '\'' +
                ",email='" + email+ '\'' +
                ",days='" + days+ '\'' +
                ",Date2='" + Date2+ '\'' +
                ",Date1='" + Date1+ '\'' +
                ",rn='" + rn+ '\'' +
                ",daysi='" + daysi+ '\'' +
                ",f1='" + f1+ '\'' +
                ",f3='" + f3+ '\'' +
                ",f2='" + f2+ '\'' +
                ",label31='" +label31+ '\'' +
                '}';
    }
}
