package lk.ijse.cmjd.fx.entity;

import java.sql.Date;

public class Clean {

    private String code;
    private String description;
    private Date Date;
    private String f1;

    public Clean() {
    }

    public Clean(String code, String description, java.sql.Date Date, String f1) {
        this.code = code;
        this.description = description;
        this.Date = Date;
        this.f1 = f1;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(java.sql.Date date) {
        Date = date;
    }

    public void setF1(String f1) {
        this.f1 = f1;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public java.sql.Date getDate() {
        return Date;
    }

    public String getF1() {
        return f1;
    }

    @Override
    public String toString() {
        return "Clean{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ",Date='" + Date+ '\'' +
                ",f1='" + f1+ '\'' +
                '}';
    }
}
