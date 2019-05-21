package lk.ijse.cmjd.fx.dto;

import java.sql.Date;
import java.time.LocalDate;

public class CleanDTO {

    private String code;
    private String description;
    private LocalDate Date;
    private String f1;

    public CleanDTO() {
    }

    public CleanDTO(String code, String description,  LocalDate Date, String f1) {
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



    public void setF1(String f1) {
        this.f1 = f1;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
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
