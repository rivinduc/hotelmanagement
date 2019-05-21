package lk.ijse.cmjd.fx.dao.custom.impl;

import lk.ijse.cmjd.fx.dao.custom.ItemDAO;
import lk.ijse.cmjd.fx.db.DBConnection;
import lk.ijse.cmjd.fx.entity.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

    @Override
    public Item find(String code) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
        pstm.setObject(1, code);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()){
            return  new Item(rst.getString("code"),
                    rst.getString("description"),
                    Double.parseDouble(rst.getString("unitPrice")),
                    Integer.parseInt(rst.getString("qtyOnHand"))
                    );
        }
        return null;
    }

    public List<Item> findAll() throws Exception {
        ArrayList<Item> alItemS = new ArrayList<>();
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item");
        ResultSet rst = pstm.executeQuery();
        while (rst.next()) {
            String code = rst.getString(1);
            String description = rst.getString(2);
            double unitPrice = Double.parseDouble(rst.getString(3));
            int qtyOnHand = Integer.parseInt(rst.getString(4));
            Item item = new Item(code, description, unitPrice, qtyOnHand);
            alItemS.add(item);
        }
        return alItemS;
    }

    public boolean save(Item item) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item VALUES (?,?,?,?)");
        pstm.setObject(1, item.getCode());
        pstm.setObject(2, item.getDescription());
        pstm.setObject(3, item.getUnitPrice());
        pstm.setObject(4, item.getQtyOnHand());
        return pstm.executeUpdate() > 0;
    }

    public boolean update(Item item) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
        pstm.setObject(4, item.getCode());
        pstm.setObject(1, item.getDescription());
        pstm.setObject(2, item.getUnitPrice());
        pstm.setObject(3, item.getQtyOnHand());
        return pstm.executeUpdate() > 0;
    }

    public boolean delete(String code) throws Exception {
        Connection connection = DBConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
        pstm.setObject(1, code);
        return pstm.executeUpdate() > 0;
    }

    @Override
    public boolean delete2(String key) throws Exception {
        return false;
    }
}
