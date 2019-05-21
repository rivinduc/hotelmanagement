package lk.ijse.cmjd.fx.dao.custom.impl;


import javafx.event.ActionEvent;
import lk.ijse.cmjd.fx.dao.custom.BanquetDAO;
import lk.ijse.cmjd.fx.dao.custom.CustomerDAO;
import lk.ijse.cmjd.fx.db.DBConnection;
import lk.ijse.cmjd.fx.entity.Banquet;
import lk.ijse.cmjd.fx.entity.Customer;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class BanquetDAOImpl implements BanquetDAO {
    @Override
    public Banquet find(String id) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Banquet WHERE id=?");
        pstm.setObject(1, id);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return new Banquet(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address"),
                    rst.getString("email"),
                    rst.getDate("Date2"),
                    rst.getString("ppl"),
                    rst.getString("typec"),
                    rst.getString("chair"),
                    rst.getString("f1"),
                    rst.getString("f2"),
                    rst.getString("txtCustomerId12")
            );
        }
        return null;
    }


    public List<Banquet> findAll() throws Exception {
        ArrayList<Banquet> alBanquetsS = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Banquet");
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            String id = rst.getString(1);
            String name = rst.getString(2);
            String address = rst.getString(3);
            String email = rst.getString(4);

            Date Date2 = rst.getDate(5);
            String ppl = rst.getString(6);
            String typec = rst.getString(7);
            String chair = rst.getString(8);

            String f1 = rst.getString(9);

            String f2 = rst.getString(10);
            String txtCustomerId12 =rst.getString(11);
            Banquet banquet = new Banquet(
                    id,
                    name,
                    address,
                    email,
                    Date2,
                    ppl,
                    typec,
                    chair,
                    f1,
                    f2,
                    txtCustomerId12
            );
            alBanquetsS.add(banquet);
        }
        return alBanquetsS;
    }

    public boolean save(Banquet banquet) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Banquet VALUES (?,?,?,?,?,?,?,?,?,?,?)");
        pstm.setObject(1, banquet.getId());
        pstm.setObject(2, banquet.getName());
        pstm.setObject(3, banquet.getAddress());
        pstm.setObject(4, banquet.getEmail());
        pstm.setObject(5, banquet.getDate2());
        pstm.setObject(6, banquet.getPpl());
        pstm.setObject(7, banquet.getTypec());
        pstm.setObject(8, banquet.getChair());
        pstm.setObject(9, banquet.getF1());
        pstm.setObject(10, banquet.getF2());
        pstm.setObject(11,banquet.getTxtCustomerId12());
        return pstm.executeUpdate() > 0;
    }

    public boolean update(Banquet banquet) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Banquet SET name=?, address=? ,email=?,Date2 =?,ppl=?,typec=?,chair=?,f1=?,f2=?,txtCustomerId12=?  WHERE id=?");
        pstm.setObject(11, banquet.getId());
        pstm.setObject(1, banquet.getName());
        pstm.setObject(2, banquet.getAddress());
        pstm.setObject(3, banquet.getEmail());
        pstm.setObject(4, banquet.getDate2());
        pstm.setObject(5, banquet.getPpl());
        pstm.setObject(6, banquet.getTypec());
        pstm.setObject(7, banquet.getChair());
        pstm.setObject(8, banquet.getF1());
        pstm.setObject(9, banquet.getF2());
        pstm.setObject(10, banquet.getTxtCustomerId12());
        return pstm.executeUpdate() > 0;
    }

    public boolean delete(String BanquetId) throws Exception {
        return false;
    }

    @Override
    public boolean delete2(String BanquetId) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Banquet WHERE id=?");
        pstm.setObject(1, BanquetId);
        return pstm.executeUpdate() > 0;


    }
}