package lk.ijse.cmjd.fx.dao.custom.impl;

import lk.ijse.cmjd.fx.dao.custom.CleanDAO;
import lk.ijse.cmjd.fx.db.DBConnection;
import lk.ijse.cmjd.fx.entity.Clean;
import lk.ijse.cmjd.fx.entity.Item;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CleanDAOImpl implements CleanDAO {
    @Override
    public Clean find(String code) throws Exception {

        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Clean WHERE code=?");
        pstm.setObject(1, code);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            return  new Clean(rst.getString("code"),
                    rst.getString("description"),
                    rst.getDate("Date"),
                    rst.getString("f1")
            );
        }
        return null;

    }

    @Override
    public List<Clean> findAll() throws Exception {
        ArrayList<Clean> alClean = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Clean");
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            String code = rst.getString(1);
            String description = rst.getString(2);
            Date Date = rst.getDate(3);
            String f1 = rst.getString(4);
            Clean clean = new Clean(code, description,Date,f1);
            alClean.add(clean);
        }
        return alClean;
    }

    @Override
    public boolean save(Clean clean) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Clean VALUES (?,?,?,?)");
        pstm.setObject(1, clean.getCode());
        pstm.setObject(2, clean.getDescription());
        pstm.setObject(3, clean.getDate());
        pstm.setObject(4, clean.getF1());
        return pstm.executeUpdate() > 0;
    }


    @Override
    public boolean update(Clean clean) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Clean SET description=?, Date=?, f1=? WHERE code=?");
        pstm.setObject(4, clean.getCode());
        pstm.setObject(1, clean.getDescription());
        pstm.setObject(2, clean.getDate());
        pstm.setObject(3, clean.getF1());
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String code) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Clean WHERE code=?");
        pstm.setObject(1, code);
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete2(String key) throws Exception {
        return false;
    }
}
